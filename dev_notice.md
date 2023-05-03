# 此处存放开发时的注意事项
## 1.关于联动模组
现在该模组明确联动的模组有tc和gcym  
需要注意的是 联动模组在runtime缺失时,本模组应该正常运行  
然而一些不正确的写法会导致缺失联动模组时本模组不会正常运行
(这等于就不是联动了 成依赖了)  
(节选自GCValues.java)

    public static final boolean IS_TOP_LOADED = Loader.isModLoaded(GTValues.MODID_TOP);

    public static final boolean IS_TC_LOADED = Loader.isModLoaded("thaumcraft");

首先,联动内容可以正常使用联动模组的类 但是在这之外 比如联动内容的注册等必须首先判断联动模组是否加载  
正确的判断方式不是随地使用Loader.isModLoaded(),这个方法涉及一个查表的过程.但是需要注意的是,某个模组是否加载在游戏开启后是不会变化的  
所以正确方法是建一个常量表示某个模组是否加载 并且在其他地方统一使用这个常量

举例如下  
首先,CommonBlocks会在方块注册等地方被用到
来自一份过时的CommonBlocks.java

    public class CommonBlocks {

        public static final TEBlock ESSENTIA_HATCH = new TEBlock("essentia_hatch", 1);
        public static  GCMetaGlasses TRANSPARENT_CASING;
        public static GCMetaGlasses1 TRANSPARENT_CASING1;

        @SideOnly(Side.CLIENT)
        public static void registerItemModels() {

            TRANSPARENT_CASING.onModelRegister();
            TRANSPARENT_CASING1.onModelRegister();
            //registerItemModel(TRANSPARENT_CASING);

            if(GCValues.IS_TC_LOADED) registerItemModel(ESSENTIA_HATCH);
        }

        @SideOnly(Side.CLIENT)
        private static void registerItemModel(@Nonnull Block block) {
            for (IBlockState state : block.getBlockState().getValidStates()) {
                //noinspection ConstantConditions
                ModelLoader.setCustomModelResourceLocation(
                    Item.getItemFromBlock(block),
                    block.getMetaFromState(state),
                    new ModelResourceLocation(block.getRegistryName(), "inventory"));
            }
        }
    }


如上 我们主要关心 ESSENTIA_HATCH 这个常量 这个方块是TC联动的一部分 所以在注册(等环节)必须先检测模组是否加载  
但是仅仅这样是不够的,这个类还有两个静态变量(当然它们都是MetaBlocks,不应该在CommonBlocks里面 但是显然以后可能还是会有其他CommonBlock)  
当外部因使用这两个TRANSPARENT_CASING,会导致这个类被加载, ESSENTIA_HATCH 也会被初始化,显然在无TC的环境下这将导致NoClassDefFoundError  
所以真正的写法是

    public class CommonBlocks {

        @SideOnly(Side.CLIENT)
        public static void registerItemModels() {
            //registerItemModel(TRANSPARENT_CASING);
            if(GCValues.IS_TC_LOADED) registerItemModel(getEssentiaHatch());
        }

        @SideOnly(Side.CLIENT)
        private static void registerItemModel(@Nonnull Block block) {
            for (IBlockState state : block.getBlockState().getValidStates()) {
                //noinspection ConstantConditions
                ModelLoader.setCustomModelResourceLocation(
                        Item.getItemFromBlock(block),
                        block.getMetaFromState(state),
                        new ModelResourceLocation(block.getRegistryName(), "inventory"));
            }
        }
    
        @Optional.Method(modid = "thaumcraft")
        public static TEBlock getEssentiaHatch(){
            return Holder.ESSENTIA_HATCH;
        }
    
        private static class Holder{
            public static final TEBlock ESSENTIA_HATCH = new TEBlock("essentia_hatch", 1);
        }

    }

两个不应该出现的MetaBlock已经被移除 但是我们假设依旧有其他静态成员变量在这个类
那么获得 ESSENTIA_HATCH 的一个正确方案是套一个内部静态类并用一个getter方法代替直接引用  ESSENTIA_HATCH  
只要调用getEssentiaHatch()前判断了TC已经被加载 那么ESSENTIA_HATCH就不会因为
CommonBlocks类的加载而被意外加载  
值得一提的是 这个@Optional.Method(modid = "thaumcraft")注解其实并没有什么用
如果在没有TC环境下调用getEssentiaHatch(),这个注解只不过是把一个NoClassDefFoundError 
变成了NoSuchMethodError

