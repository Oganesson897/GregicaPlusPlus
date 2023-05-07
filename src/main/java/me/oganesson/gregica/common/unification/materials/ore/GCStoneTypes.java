package me.oganesson.gregica.common.unification.materials.ore;

import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.StoneType;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.blocks.StoneVariantBlock;
import net.minecraft.block.BlockRedSandstone;
import net.minecraft.block.BlockSandStone;
import net.minecraft.block.BlockStone;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

import java.util.ArrayList;

public class GCStoneTypes {
    public static ArrayList<StoneType> LIST = new ArrayList<>();

    public static StoneType STONE_POOR;
    public static StoneType NETHERRACK_POOR;
    public static StoneType ENDSTONE_POOR;
    public static StoneType SANDSTONE_POOR;
    public static StoneType RED_SANDSTONE_POOR;
    public static StoneType GRANITE_POOR;
    public static StoneType DIORITE_POOR;
    public static StoneType ANDESITE_POOR;
    public static StoneType BLACK_GRANITE_POOR;
    public static StoneType RED_GRANITE_POOR;
    public static StoneType MARBLE_POOR;
    public static StoneType BASALT_POOR;

    public static StoneType STONE_RICH;
    public static StoneType NETHERRACK_RICH;
    public static StoneType ENDSTONE_RICH;
    public static StoneType SANDSTONE_RICH;
    public static StoneType RED_SANDSTONE_RICH;
    public static StoneType GRANITE_RICH;
    public static StoneType DIORITE_RICH;
    public static StoneType ANDESITE_RICH;
    public static StoneType BLACK_GRANITE_RICH;
    public static StoneType RED_GRANITE_RICH;
    public static StoneType MARBLE_RICH;
    public static StoneType BASALT_RICH;

    public GCStoneTypes() {}

    private static IBlockState gtStoneState(StoneVariantBlock.StoneType stoneType) {
        return ((StoneVariantBlock) MetaBlocks.STONE_BLOCKS.get(StoneVariantBlock.StoneVariant.SMOOTH)).getState(stoneType);
    }

    private static boolean gtStonePredicate(IBlockState state, StoneVariantBlock.StoneType stoneType) {
        StoneVariantBlock block = (StoneVariantBlock)MetaBlocks.STONE_BLOCKS.get(StoneVariantBlock.StoneVariant.SMOOTH);
        return state.getBlock() == block && block.getState(state) == stoneType;
    }

    static {
        STONE_POOR = new StoneType(60, "stone", SoundType.STONE, GCOrePrefixs.orePoor, Materials.Stone, () -> {
            return Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.STONE);
        }, (state) -> {
            return state.getBlock() instanceof BlockStone && state.getValue(BlockStone.VARIANT) == BlockStone.EnumType.STONE;
        }, true);
        NETHERRACK_POOR = new StoneType(61, "netherrack", SoundType.STONE, GCOrePrefixs.orePoorNetherrack, Materials.Netherrack, Blocks.NETHERRACK::getDefaultState, (state) -> {
            return state.getBlock() == Blocks.NETHERRACK;
        }, true);
        ENDSTONE_POOR = new StoneType(62, "endstone", SoundType.STONE, GCOrePrefixs.orePoorEndstone, Materials.Endstone, Blocks.END_STONE::getDefaultState, (state) -> {
            return state.getBlock() == Blocks.END_STONE;
        }, true);
        SANDSTONE_POOR = new StoneType(63, "sandstone", SoundType.STONE, GCOrePrefixs.orePoorSand, Materials.SiliconDioxide, () -> {
            return Blocks.SANDSTONE.getDefaultState().withProperty(BlockSandStone.TYPE, net.minecraft.block.BlockSandStone.EnumType.DEFAULT);
        }, (state) -> {
            return state.getBlock() instanceof BlockSandStone && state.getValue(BlockSandStone.TYPE) == net.minecraft.block.BlockSandStone.EnumType.DEFAULT;
        }, false);
        RED_SANDSTONE_POOR = new StoneType(64, "red_sandstone", SoundType.STONE, GCOrePrefixs.orePoorRedSand, Materials.SiliconDioxide, () -> {
            return Blocks.RED_SANDSTONE.getDefaultState().withProperty(BlockRedSandstone.TYPE, net.minecraft.block.BlockRedSandstone.EnumType.DEFAULT);
        }, (state) -> {
            return state.getBlock() instanceof BlockRedSandstone && state.getValue(BlockRedSandstone.TYPE) == net.minecraft.block.BlockRedSandstone.EnumType.DEFAULT;
        }, false);
        GRANITE_POOR = new StoneType(65, "granite", SoundType.STONE, GCOrePrefixs.orePoorGranite, Materials.Granite, () -> {
            return Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE);
        }, (state) -> {
            return state.getBlock() instanceof BlockStone && state.getValue(BlockStone.VARIANT) == BlockStone.EnumType.GRANITE;
        }, false);
        DIORITE_POOR = new StoneType(66, "diorite", SoundType.STONE, GCOrePrefixs.orePoorDiorite, Materials.Diorite, () -> {
            return Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE);
        }, (state) -> {
            return state.getBlock() instanceof BlockStone && state.getValue(BlockStone.VARIANT) == BlockStone.EnumType.DIORITE;
        }, false);
        ANDESITE_POOR = new StoneType(67, "andesite", SoundType.STONE, GCOrePrefixs.orePoorAndesite, Materials.Andesite, () -> {
            return Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE);
        }, (state) -> {
            return state.getBlock() instanceof BlockStone && state.getValue(BlockStone.VARIANT) == BlockStone.EnumType.ANDESITE;
        }, false);
        BLACK_GRANITE_POOR = new StoneType(68, "black_granite", SoundType.STONE, GCOrePrefixs.orePoorBlackgranite, Materials.GraniteBlack, () -> {
            return gtStoneState(gregtech.common.blocks.StoneVariantBlock.StoneType.BLACK_GRANITE);
        }, (state) -> {
            return gtStonePredicate(state, gregtech.common.blocks.StoneVariantBlock.StoneType.BLACK_GRANITE);
        }, false);
        RED_GRANITE_POOR = new StoneType(69, "red_granite", SoundType.STONE, GCOrePrefixs.orePoorRedgranite, Materials.GraniteRed, () -> {
            return gtStoneState(gregtech.common.blocks.StoneVariantBlock.StoneType.RED_GRANITE);
        }, (state) -> {
            return gtStonePredicate(state, gregtech.common.blocks.StoneVariantBlock.StoneType.RED_GRANITE);
        }, false);
        MARBLE_POOR = new StoneType(70, "marble", SoundType.STONE, GCOrePrefixs.orePoorMarble, Materials.Marble, () -> {
            return gtStoneState(gregtech.common.blocks.StoneVariantBlock.StoneType.MARBLE);
        }, (state) -> {
            return gtStonePredicate(state, gregtech.common.blocks.StoneVariantBlock.StoneType.MARBLE);
        }, false);
        BASALT_POOR = new StoneType(71, "basalt", SoundType.STONE, GCOrePrefixs.orePoorBasalt, Materials.Basalt, () -> {
            return gtStoneState(gregtech.common.blocks.StoneVariantBlock.StoneType.BASALT);
        }, (state) -> {
            return gtStonePredicate(state, gregtech.common.blocks.StoneVariantBlock.StoneType.BASALT);
        }, false);

        STONE_RICH = new StoneType(80, "stone", SoundType.STONE, GCOrePrefixs.oreRich, Materials.Stone, () -> {
            return Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.STONE);
        }, (state) -> {
            return state.getBlock() instanceof BlockStone && state.getValue(BlockStone.VARIANT) == BlockStone.EnumType.STONE;
        }, true);
        NETHERRACK_RICH = new StoneType(81, "netherrack", SoundType.STONE, GCOrePrefixs.oreRichNetherrack, Materials.Netherrack, Blocks.NETHERRACK::getDefaultState, (state) -> {
            return state.getBlock() == Blocks.NETHERRACK;
        }, true);
        ENDSTONE_RICH = new StoneType(82, "endstone", SoundType.STONE, GCOrePrefixs.oreRichEndstone, Materials.Endstone, Blocks.END_STONE::getDefaultState, (state) -> {
            return state.getBlock() == Blocks.END_STONE;
        }, true);
        SANDSTONE_RICH = new StoneType(83, "sandstone", SoundType.STONE, GCOrePrefixs.oreRichSand, Materials.SiliconDioxide, () -> {
            return Blocks.SANDSTONE.getDefaultState().withProperty(BlockSandStone.TYPE, net.minecraft.block.BlockSandStone.EnumType.DEFAULT);
        }, (state) -> {
            return state.getBlock() instanceof BlockSandStone && state.getValue(BlockSandStone.TYPE) == net.minecraft.block.BlockSandStone.EnumType.DEFAULT;
        }, false);
        RED_SANDSTONE_RICH = new StoneType(84, "red_sandstone", SoundType.STONE, GCOrePrefixs.oreRichRedSand, Materials.SiliconDioxide, () -> {
            return Blocks.RED_SANDSTONE.getDefaultState().withProperty(BlockRedSandstone.TYPE, net.minecraft.block.BlockRedSandstone.EnumType.DEFAULT);
        }, (state) -> {
            return state.getBlock() instanceof BlockRedSandstone && state.getValue(BlockRedSandstone.TYPE) == net.minecraft.block.BlockRedSandstone.EnumType.DEFAULT;
        }, false);
        GRANITE_RICH = new StoneType(85, "granite", SoundType.STONE, GCOrePrefixs.oreRichGranite, Materials.Granite, () -> {
            return Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE);
        }, (state) -> {
            return state.getBlock() instanceof BlockStone && state.getValue(BlockStone.VARIANT) == BlockStone.EnumType.GRANITE;
        }, false);
        DIORITE_RICH = new StoneType(86, "diorite", SoundType.STONE, GCOrePrefixs.oreRichDiorite, Materials.Diorite, () -> {
            return Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE);
        }, (state) -> {
            return state.getBlock() instanceof BlockStone && state.getValue(BlockStone.VARIANT) == BlockStone.EnumType.DIORITE;
        }, false);
        ANDESITE_RICH = new StoneType(87, "andesite", SoundType.STONE, GCOrePrefixs.oreRichAndesite, Materials.Andesite, () -> {
            return Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE);
        }, (state) -> {
            return state.getBlock() instanceof BlockStone && state.getValue(BlockStone.VARIANT) == BlockStone.EnumType.ANDESITE;
        }, false);
        BLACK_GRANITE_RICH = new StoneType(88, "black_granite", SoundType.STONE, GCOrePrefixs.oreRichBlackgranite, Materials.GraniteBlack, () -> {
            return gtStoneState(gregtech.common.blocks.StoneVariantBlock.StoneType.BLACK_GRANITE);
        }, (state) -> {
            return gtStonePredicate(state, gregtech.common.blocks.StoneVariantBlock.StoneType.BLACK_GRANITE);
        }, false);
        RED_GRANITE_RICH = new StoneType(89, "red_granite", SoundType.STONE, GCOrePrefixs.oreRichRedgranite, Materials.GraniteRed, () -> {
            return gtStoneState(gregtech.common.blocks.StoneVariantBlock.StoneType.RED_GRANITE);
        }, (state) -> {
            return gtStonePredicate(state, gregtech.common.blocks.StoneVariantBlock.StoneType.RED_GRANITE);
        }, false);
        MARBLE_RICH = new StoneType(90, "marble", SoundType.STONE, GCOrePrefixs.oreRichMarble, Materials.Marble, () -> {
            return gtStoneState(gregtech.common.blocks.StoneVariantBlock.StoneType.MARBLE);
        }, (state) -> {
            return gtStonePredicate(state, gregtech.common.blocks.StoneVariantBlock.StoneType.MARBLE);
        }, false);
        BASALT_RICH = new StoneType(91, "basalt", SoundType.STONE, GCOrePrefixs.oreRichBasalt, Materials.Basalt, () -> {
            return gtStoneState(gregtech.common.blocks.StoneVariantBlock.StoneType.BASALT);
        }, (state) -> {
            return gtStonePredicate(state, gregtech.common.blocks.StoneVariantBlock.StoneType.BASALT);
        }, false);

        LIST.add(STONE_POOR);
        LIST.add(NETHERRACK_POOR);
        LIST.add(ENDSTONE_POOR);
        LIST.add(SANDSTONE_POOR);
        LIST.add(RED_SANDSTONE_POOR);
        LIST.add(GRANITE_POOR);
        LIST.add(DIORITE_POOR);
        LIST.add(ANDESITE_POOR);
        LIST.add(BLACK_GRANITE_POOR);
        LIST.add(RED_GRANITE_POOR);
        LIST.add(MARBLE_POOR);
        LIST.add(BASALT_POOR);
        LIST.add(STONE_RICH);
        LIST.add(NETHERRACK_RICH);
        LIST.add(ENDSTONE_RICH);
        LIST.add(SANDSTONE_RICH);
        LIST.add(RED_SANDSTONE_RICH);
        LIST.add(GRANITE_RICH);
        LIST.add(DIORITE_RICH);
        LIST.add(ANDESITE_RICH);
        LIST.add(BLACK_GRANITE_RICH);
        LIST.add(RED_GRANITE_RICH);
        LIST.add(MARBLE_RICH);
        LIST.add(BASALT_RICH);
    }
}
