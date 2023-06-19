package gregica.common.data;

import codechicken.lib.util.DirectoryWalker;
import gregica.Gregica;
import gregica.api.data.CrossWorldData;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.server.MinecraftServer;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public enum CrossWorldDataHandler {
    INSTANCE;
    
    private static File dataFold;
    
    private final Map<String, CrossWorldData> data = new Object2ObjectOpenHashMap<>();
    private int loadStack = 0;
    
    public <T extends CrossWorldData> T getOrCreate(CWDataType type) {
        if (this.data.containsKey(type.getName())) {
            //noinspection unchecked
            return (T) this.data.get(type.getName());
        } else {
            T result = type.newInstance();
            if (result != null) {
                result.init();
                this.data.put(result.getName(), result);
            }
            
            return result;
        }
    }
    
    public CrossWorldData getData(String key) {
        return this.data.get(key);
    }
    
    public void loadWorld() throws IOException {
        checkDataFold();
        if (this.loadStack == 0) {
            DirectoryWalker walker = new DirectoryWalker(DirectoryWalker.FALSE, DirectoryWalker.TRUE);
    
            for (File file : walker.walk(dataFold)) {
                CrossWorldData crossWorldData = CWDataType.byName(file.getName());
                if (crossWorldData != null) {
                    crossWorldData.load(CompressedStreamTools.read(file));
                } else {
                    //noinspection ResultOfMethodCallIgnored
                    file.delete();
                }
            }
        }
        
        ++this.loadStack;
    }
    
    public void unloadWorld() throws IOException {
        checkDataFold();
        --this.loadStack;
        if (this.loadStack <= 0) {
    
            for (CrossWorldData crossWorldData : this.data.values()) {
                File file = new File(dataFold, crossWorldData.getName());
                if (!file.exists()) {
                    //noinspection ResultOfMethodCallIgnored
                    file.createNewFile();
                    CompressedStreamTools.safeWrite(crossWorldData.save(), file);
                }
            }
            
            this.data.clear();
            ((Object2ObjectOpenHashMap<?, ?>)this.data).trim();
        }
        
    }
    
    public void save() throws IOException {
        checkDataFold();
    
        for (CrossWorldData crossWorldData : this.data.values()) {
            if (crossWorldData.isDirty()) {
                File file = new File(dataFold, crossWorldData.getName());
                if (!file.exists()) {
                    //noinspection ResultOfMethodCallIgnored
                    file.createNewFile();
                    CompressedStreamTools.safeWrite(crossWorldData.save(), file);
                }
            }
        }
        
    }
    
    public int getLoadStack() {
        return this.loadStack;
    }
    
    public void setLoadStack(int loadStack) {
        this.loadStack = loadStack;
    }
    
    private static void getDataFold() {
        if (Gregica.currentServer != null) {
            MinecraftServer server = Gregica.currentServer;
            dataFold = server.getActiveAnvilConverter().getFile(server.getName(), "gregica_data");
        }
        
        if (dataFold != null) {
            dataFold = new File(dataFold, "gregica_data");
            if (!dataFold.exists()) {
                //noinspection ResultOfMethodCallIgnored
                dataFold.mkdirs();
            }
            else if(!dataFold.isDirectory()){
                //noinspection ResultOfMethodCallIgnored
                dataFold.delete();
                //noinspection ResultOfMethodCallIgnored
                dataFold.mkdirs();
            }
        }
        
    }
    
    private static void checkDataFold() {
        if (dataFold == null) {
            getDataFold();
            if (dataFold == null) {
                throw new RuntimeException("Gregica cannot get data directory.");
            }
        }
        
    }
    
    static {
        getDataFold();
    }
    
}
