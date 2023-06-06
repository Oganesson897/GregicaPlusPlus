package me.oganesson.gregica.common.data;

import me.oganesson.gregica.api.data.CrossWorldData;

import java.util.HashMap;
import java.util.Map;

public enum CWDataType {
    
    ;
    private final String name;
    private final Class<? extends CrossWorldData> aClass;
    
    private static final Map<String, CWDataType> tableMap = new HashMap<>();
    
    CWDataType(String name, Class<? extends CrossWorldData> aClass) {
        this.name = name;
        this.aClass = aClass;
        
    }
    
    public static CrossWorldData byName(String s){
        if(tableMap.isEmpty()){
            for(CWDataType table : CWDataType.values()){
                tableMap.put(table.name,table);
            }
        }
        if(tableMap.containsKey(s)){
            return tableMap.get(s).newInstance();
        }
       return null;
    }
    
    public String getName() {
        return name;
    }
    
    public Class<?> getaClass() {
        return aClass;
    }
    
    public CrossWorldData newInstance() {
        try {
            return (CrossWorldData) this.getaClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            return null;
        }
    }
    
}
