package me.oganesson.gregica.utils;

public class GCMathUtils {
    public static int clamp(int value, int min, int max) {
        if (value < min)
            return min;
        return Math.min(value, max);
    }
    
    public static long min(long i1,long i2,long i3){
        return i1<i2 ? Math.min(i2, i3) : i1;
    }
}
