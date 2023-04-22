package me.oganesson.gregica.common.block.laserpipe;

import gregtech.api.pipenet.block.IPipeType;
import gregtech.api.pipenet.block.simple.EmptyNodeData;

public enum LaserPipeType implements IPipeType<EmptyNodeData> {
    NORMAL("normal", 0.5f);

    public final String name;
    public final float thickness;

    LaserPipeType(String name, float thickness) {
        this.name = name;
        this.thickness = thickness;
    }

    @Override
    public float getThickness() {
        return thickness;
    }

    @Override
    public EmptyNodeData modifyProperties(EmptyNodeData emptyNodeData) {
        return emptyNodeData;
    }

    @Override
    public boolean isPaintable() {
        return true;
    }

    @Override
    public String getName() {
        return name;
    }
}
