package me.oganesson.gregica.api.item;

public interface IBall {

    boolean hasBall();

    default void consumeBall(int amount){

    }
}
