package me.oganesson.gregica.common.tileentities;

import me.oganesson.gregica.common.thaumcraft.LargeEssentiaEnergyData;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import thaumcraft.api.ThaumcraftApiHelper;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.aspects.IAspectContainer;
import thaumcraft.api.aspects.IEssentiaTransport;

import javax.annotation.Nonnull;
import java.util.ArrayList;

public class EssentiaHatch extends TileEntity implements IAspectContainer, IEssentiaTransport, ITickable {

    private Aspect mLocked;
    private AspectList current = new AspectList();
    public int mState = 0;

    public void setLockedAspect(Aspect aAspect) {
        this.mLocked = aAspect;
    }

    @Override
    public void readFromNBT(@Nonnull NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);

        this.mLocked = Aspect.getAspect(tagCompound.getString("mLocked"));
        this.mState = tagCompound.getInteger("mState");
        current = new AspectList();
        NBTTagList tlist = tagCompound.getTagList("Aspects", 10);
        for (int j = 0; j < tlist.tagCount(); ++j) {
            NBTTagCompound rs = tlist.getCompoundTagAt(j);
            if (rs.hasKey("key")) {
                current.add(Aspect.getAspect(rs.getString("key")), rs.getInteger("amount"));
            }
        }
    }

    @Nonnull
    @Override
    public NBTTagCompound writeToNBT(@Nonnull NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);
        tagCompound.setString("mLocked", this.mLocked == null ? "" : this.mLocked.getTag());
        tagCompound.setInteger("mState", mState);
        NBTTagList tlist = new NBTTagList();
        Aspect[] aspectA = current.getAspects();
        for (Aspect aspect : aspectA) {
            if (aspect != null) {
                NBTTagCompound f = new NBTTagCompound();
                f.setString("key", aspect.getTag());
                f.setInteger("amount", current.getAmount(aspect));
                tlist.appendTag(f);
            }
        }
        tagCompound.setTag("Aspects", tlist);
        return tagCompound;
    }

    @Override
    public final SPacketUpdateTileEntity getUpdatePacket() {
        NBTTagCompound nbt = new NBTTagCompound();
        writeToNBT(nbt);
        return new SPacketUpdateTileEntity(this.getPos(), 0, nbt);
    }

    @Override
    public void onDataPacket(@Nonnull NetworkManager net, SPacketUpdateTileEntity pkt) {
        NBTTagCompound nbt = pkt.getNbtCompound();
        readFromNBT(nbt);
    }

    @Override
    public void update() {
        fillfrompipe();
    }

    public void fillfrompipe() {
        if (getEssentiaAmount(null) >= 1000) return;
        TileEntity[] te = new TileEntity[EnumFacing.VALUES.length];
        for (int i = 0; i < EnumFacing.VALUES.length; i++) {
            te[i] = ThaumcraftApiHelper.getConnectableTile(
                    this.world,
                    this.getPos(),
                    EnumFacing.VALUES[i]);
            if (te[i] != null) {
                IEssentiaTransport pipe = (IEssentiaTransport) te[i];
                if (!pipe.canOutputTo(EnumFacing.VALUES[i])) {
                    return;
                }
                if ((pipe.getEssentiaType(EnumFacing.VALUES[i].getOpposite()) != null)
                        && (pipe.getSuctionAmount(EnumFacing.VALUES[i])
                        < getSuctionAmount(EnumFacing.VALUES[i]))) {
                    Aspect readyInput = pipe.getEssentiaType(EnumFacing.VALUES[i].getOpposite());
                    int type = LargeEssentiaEnergyData.getAspectTypeIndex(readyInput);
                    if (type != -1 && (mState & (1 << type)) == 0) continue;
                    if (readyInput.equals(mLocked)) {
                        addToContainer(mLocked, pipe.takeEssentia(mLocked, 1, EnumFacing.VALUES[i]));
                    }
                    if (mLocked == null) addToContainer(
                            pipe.getEssentiaType(EnumFacing.VALUES[i]),
                            pipe.takeEssentia(
                                    pipe.getEssentiaType(EnumFacing.VALUES[i]),
                                    1,
                                    EnumFacing.VALUES[i]));
                }
            }
        }
    }

    @Override
    public AspectList getAspects() {
        return current;
    }

    @Override
    public void setAspects(AspectList aspectList) {
        this.current.add(aspectList);
    }

    @Override
    public boolean doesContainerAccept(Aspect aspect) {
        int type = LargeEssentiaEnergyData.getAspectTypeIndex(aspect);
        if (type != -1 && (mState & (1 << type)) == 0) return false;
        return (mLocked == null || mLocked.equals(aspect)) && getEssentiaAmount(null) <= 1000;
    }

    @Override
    public int addToContainer(Aspect aspect, int i) {
        int type = LargeEssentiaEnergyData.getAspectTypeIndex(aspect);
        if (type != -1 && (mState & (1 << type)) == 0) return i;
        int ready = Math.min(1000 - getEssentiaAmount(null), i);
        if ((mLocked == null || mLocked.equals(aspect)) && ready > 0) {
            current.add(aspect, ready);
            this.markDirty();
            return i - ready;
        }
        this.markDirty();
        return i;
    }

    @Override
    public boolean takeFromContainer(Aspect aspect, int i) {
        return false;
    }

    @Override
    public boolean takeFromContainer(AspectList aspectList) {
        return false;
    }

    @Override
    public boolean doesContainerContainAmount(Aspect aspect, int i) {
        return current.aspects.containsKey(aspect) && i <= current.getAmount(aspect);
    }

    @Override
    public boolean doesContainerContain(AspectList aspectList) {
        ArrayList<Boolean> ret = new ArrayList<Boolean>();
        for (Aspect a : aspectList.aspects.keySet()) ret.add(current.aspects.containsKey(a));
        return !ret.contains(false);
    }

    @Override
    public int containerContains(Aspect aspect) {
        return current.aspects.containsKey(aspect) ? current.getAmount(aspect) : 0;
    }

    @Override
    public boolean isConnectable(EnumFacing forgeDirection) {
        return true;
    }

    @Override
    public boolean canInputFrom(EnumFacing forgeDirection) {
        return true;
    }

    @Override
    public boolean canOutputTo(EnumFacing forgeDirection) {
        return false;
    }

    @Override
    public void setSuction(Aspect aspect, int i) {}

    @Override
    public Aspect getSuctionType(EnumFacing forgeDirection) {
        return this.mLocked;
    }

    @Override
    public int getSuctionAmount(EnumFacing forgeDirection) {
        return 256;
    }

    @Override
    public int takeEssentia(Aspect aspect, int i, EnumFacing forgeDirection) {
        return 0;
    }

    @Override
    public int addEssentia(Aspect aspect, int i, EnumFacing forgeDirection) {
        return i - addToContainer(aspect, i);
    }

    @Override
    public Aspect getEssentiaType(EnumFacing forgeDirection) {
        if (current == null || current.size() < 1) return null;
        return current.getAspects()[0];
    }

    @Override
    public int getEssentiaAmount(EnumFacing forgeDirection) {
        int ret = 0;
        for (final Aspect A : current.aspects.keySet()) {
            ret += current.getAmount(A);
        }
        return ret;
    }

    @Override
    public int getMinimumSuction() {
        return Integer.MAX_VALUE;
    }
}