package project.gregica.api.nerf;

import java.util.List;

public interface INerfed {
    
    boolean isNerfed();
    
    default void details(List<String> tooltip){
    
    }
}
