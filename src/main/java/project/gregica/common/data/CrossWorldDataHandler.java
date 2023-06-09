package project.gregica.common.data;

import codechicken.lib.util.DirectoryWalker;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import project.gregica.api.data.CrossWorldData;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraftforge.common.DimensionManager;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public enum CrossWorldDataHandler {
    INSTANCE;
    
    private static File dataFold;
    
    private final Map<String,CrossWorldData> data = new Object2ObjectOpenHashMap<>();
    private int loadStack = 0;
    
    public CrossWorldData getOrCreate(CWDataType type){
        if(data.containsKey(type.getName())){
            return data.get(type.getName());
        }
        CrossWorldData result = type.newInstance();
        if (result != null) {
            result.init();
        }
        return result;
    }
    
    public CrossWorldData getData(String key){
        return data.get(key);
    }
    
    public void loadWorld(int dimension) throws IOException {
        if(this.loadStack == 0){
            DirectoryWalker walker = new DirectoryWalker(DirectoryWalker.FALSE,DirectoryWalker.TRUE);
            for(File file : walker.walk(dataFold)){
                CrossWorldData crossWorldData = CWDataType.byName(file.getName());
                if(crossWorldData != null){
                    crossWorldData.load(CompressedStreamTools.read(file));
                }
                else {
                    //noinspection ResultOfMethodCallIgnored
                    file.delete();
                }
            }
        }
        this.loadStack++;
    }
    
    public void unloadWorld(int dimension) throws IOException {
        this.loadStack--;
        if(this.loadStack <= 0){
            for(CrossWorldData crossWorldData : data.values()){
                File file = new File(dataFold,crossWorldData.getName());
                if(!file.exists()){
                    //noinspection ResultOfMethodCallIgnored
                    file.createNewFile();
                    CompressedStreamTools.safeWrite(crossWorldData.save(),file);
                }
            }
            this.data.clear();
            ((Object2ObjectOpenHashMap<?, ?>)this.data).trim();
        }
    }
    
    public void save(int dimension) throws IOException {
        for(CrossWorldData crossWorldData : data.values()){
            if(crossWorldData.isDirty()){
                File file = new File(dataFold,crossWorldData.getName());
                if(!file.exists()){
                    //noinspection ResultOfMethodCallIgnored
                    file.createNewFile();
                    CompressedStreamTools.safeWrite(crossWorldData.save(),file);
                }
            }
        }
    }
    
    public int getLoadStack() {
        return loadStack;
    }
    
    public void setLoadStack(int loadStack) {
        this.loadStack = loadStack;
    }
    
    
    static {
         dataFold = DimensionManager.getCurrentSaveRootDirectory();
         if(dataFold != null){
             dataFold = new File(dataFold,"gregica_data");
             if(!dataFold.exists()){
                 //noinspection ResultOfMethodCallIgnored
                 dataFold.mkdirs();
             }
         }
         else {
             throw new RuntimeException("Gregica cannot get data directory.");
         }
    }
    
}
