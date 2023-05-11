package me.oganesson.gregica.api.item;

import java.util.Optional;

public interface IBall {

    Optional<String> getName();

    default void consumeBall(int amount){

    }
}
