package com.tw;

import org.junit.Assert;
import org.junit.Test;

public class UtilTest {

    @Test
    public void testFloatIsInt() {
        Assert.assertFalse(Util.floatIsInt(5.05));
        Assert.assertTrue(Util.floatIsInt(5));
        Assert.assertTrue(Util.floatIsInt(5.000001));
        Assert.assertTrue(Util.floatIsInt(4.999999));
    }

    @Test
    public void testDoubleEqual() {
        Assert.assertTrue(Util.doubleEqual(0.99999999, 1));
        Assert.assertFalse(Util.doubleEqual(1.00001, 0.99998));
    }
}