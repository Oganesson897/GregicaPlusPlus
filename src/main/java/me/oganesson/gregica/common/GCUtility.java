package me.oganesson.gregica.common;

public class GCUtility {
    public static int setBetweenInclusive(int value, int start, int end) {
        if (value < start)
            return start;
        return Math.min(value, end);
    }
}
