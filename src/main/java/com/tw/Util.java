package com.tw;

public class Util {
    public static final double EPS = 1e-5;

    public static boolean floatIsInt(double f) {
        return Math.abs(f - Math.round(f)) < EPS;
    }

    public static boolean doubleEqual(double d1, double d2) {
        return Math.abs(d1 - d2) < EPS;
    }

    public static String removeDecimalPointIfNecessary(double x) {
        if (floatIsInt(x)) {
            return Math.round(x) + "";
        } else {
            return x + "";
        }
    }
}
