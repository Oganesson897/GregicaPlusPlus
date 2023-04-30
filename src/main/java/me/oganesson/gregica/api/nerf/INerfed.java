package me.oganesson.gregica.api.nerf;

import java.util.List;

public interface INerfed {
    
    boolean isNerfed();
    
    void details(List<String> tooltip);
}
