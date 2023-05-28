package me.oganesson.gregica.utils;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.text.TextFormatting;
import org.jetbrains.annotations.NotNull;

public class GCColorUtil {
    
    public static final Int2ObjectMap<StandardColor> colors = new Int2ObjectOpenHashMap<>();
    
    public enum StandardColor implements IStringSerializable{
        NONE("none",TextFormatting.WHITE,EnumDyeColor.WHITE){
            @Override
            public int getColor() {
                return 0;
            }
        },
        WHITE("white",  TextFormatting.WHITE,EnumDyeColor.WHITE),
        ORANGE( "orange",  TextFormatting.GOLD,EnumDyeColor.ORANGE),
        MAGENTA("magenta", TextFormatting.DARK_PURPLE,EnumDyeColor.MAGENTA),
        LIGHT_BLUE( "light_blue",  TextFormatting.BLUE,EnumDyeColor.LIGHT_BLUE),
        YELLOW( "yellow",  TextFormatting.YELLOW,EnumDyeColor.YELLOW),
        LIME("lime",  TextFormatting.GREEN,EnumDyeColor.LIME),
        PINK("pink",  TextFormatting.LIGHT_PURPLE,EnumDyeColor.PINK),
        GRAY( "gray",  TextFormatting.DARK_GRAY,EnumDyeColor.GRAY),
        SILVER( "silver",   TextFormatting.GRAY,EnumDyeColor.SILVER),
        CYAN( "cyan",   TextFormatting.DARK_AQUA,EnumDyeColor.CYAN),
        PURPLE( "purple",   TextFormatting.DARK_PURPLE,EnumDyeColor.PURPLE),
        BLUE("blue",   TextFormatting.DARK_BLUE,EnumDyeColor.BLUE),
        BROWN( "brown",   TextFormatting.GOLD,EnumDyeColor.BROWN),
        GREEN( "green",   TextFormatting.DARK_GREEN,EnumDyeColor.GREEN),
        RED("red",   TextFormatting.DARK_RED,EnumDyeColor.RED),
        BLACK("black", TextFormatting.DARK_GRAY,EnumDyeColor.BLACK);
        
    
        private final String name;
        private final TextFormatting chatColor;
        private final EnumDyeColor dyeColor;
    
        StandardColor(String name, TextFormatting chatColor, EnumDyeColor dyeColor) {
            this.name = name;
            this.chatColor = chatColor;
            this.dyeColor = dyeColor;
            colors.put(dyeColor.getColorValue(),this);
        }
    
        public EnumDyeColor getAsDyeColor(){
            return dyeColor;
        }

        public TextFormatting getChatColor() {
            return chatColor;
        }
        
        public int getColor(){
            return this.getAsDyeColor().getColorValue();
        }
        
        @Override
        @NotNull
        public String getName() {
            return name;
        }
        
        public String getI18NKey(){
           return  "gregica.color."+this.name;
        }
        
        public static StandardColor getFromInt(int index){
            if(index < values().length && index >= 0){
                return values()[index];
            }
            return NONE;
        }
        
    }
    
    public static String colorName(GCColorUtil.StandardColor color){
       return color.getChatColor()+ I18n.format("gregica.color."+color.getName());
    }
    
//    public enum StandardColor implements IStringSerializable {
//        NONE("none",0,0,TextFormatting.WHITE),
//        BLACK("black",0x000000,15,TextFormatting.BLACK),
//        DARK_BLUE("dark_blue",0x0000AA,12,TextFormatting.DARK_BLUE),
//        DARK_GREEN("dark_green",0x00AA00,5,TextFormatting.DARK_GREEN),
//        DARK_AQUA("dark_aqua",0x00AAAA,9,TextFormatting.DARK_AQUA),
//        DARK_RED("dark_red",0xAA0000,10,TextFormatting.DARK_RED),
//        DARK_PURPLE("dark_purple",0xAA00AA,2,TextFormatting.DARK_PURPLE),
//        GOLD("gold",0xFFAA00,1,TextFormatting.GOLD),
//        GRAY("gray",0xAAAAAA,8,TextFormatting.GRAY),
//        DARK_GRAY("dark_gray",0x555555,7,TextFormatting.DARK_GRAY),
//        BLUE("blue",0x5555FF,11,TextFormatting.BLUE),
//        GREEN("green",0x55FF55,13,TextFormatting.GREEN),
//        AQUA("aqua",0x55FFFF,3,TextFormatting.AQUA),
//        RED("red",0xFF5555,14,TextFormatting.RED),
//        LIGHT_PURPLE("light_purple",0xFF55FF,6,TextFormatting.LIGHT_PURPLE),
//        YELLOW("yellow",0xFFFF55,4,TextFormatting.YELLOW),
//        WHITE("white",0xFFFFFF,0,TextFormatting.WHITE);
//
//
//        private final int color;
//        private final String name;
//
//        private final int dyeColorIndex;
//
//        private final TextFormatting chatColor;
//
//        StandardColor(String name,int color,int dyeColorIndex,TextFormatting chatColor) {
//            this.color = color;
//            this.name = name;
//            this.dyeColorIndex = dyeColorIndex;
//            this.chatColor = chatColor;
//            colors.put(color,this);
//        }
//
//        public int getColor() {
//            return color;
//        }
//
//        @Override
//        @NotNull
//        public String getName() {
//            return name;
//        }
//
//        public EnumDyeColor getAsDyeColor(){
//            return EnumDyeColor.byMetadata(this.dyeColorIndex);
//        }
//
//        public TextFormatting getChatColor() {
//            return chatColor;
//        }
//    }
    
}
