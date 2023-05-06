package me.oganesson.gregica.api.item;

import java.util.Optional;

//我真的很不想承认这是FunctionalInterface
public interface ICatalyst {
    
    Optional<String> getName();
    
    default void consumeCatalyst(int amount){
    
    }
}
