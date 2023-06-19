package gregica.common.data;

import gregica.api.data.CrossWorldData;
import gregica.api.data.impl.CWElectricityData;

import java.util.HashMap;
import java.util.Map;

public enum CWDataType {
    ELECTRICITY("cross_world_electricity_data", CWElectricityData.class);
    
    private final String name;
    private final Class<? extends CrossWorldData> aClass;
    private static final Map<String, CWDataType> tableMap = new HashMap<>();
    
    private CWDataType(String name, Class<? extends CrossWorldData> aClass) {
        this.name = name;
        this.aClass = aClass;
    }
    
    public static CrossWorldData byName(String s) {
        if (tableMap.isEmpty()) {
            
    
            for (CWDataType table : CWDataType.values()) {
                tableMap.put(table.name, table);
            }
        }
        
        return tableMap.containsKey(s) ? tableMap.get(s).newInstance() : null;
    }
    
    public String getName() {
        return this.name;
    }
    
    public Class<? extends CrossWorldData> getaClass() {
        return this.aClass;
    }
    
    public <T extends CrossWorldData> T newInstance() {
        try {
            return (T) this.getaClass().newInstance();
        } catch (IllegalAccessException | InstantiationException var2) {
            return null;
        }
    }
}
