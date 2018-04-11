package com.tw;

import org.junit.Assert;
import org.junit.Test;

public class CourseTest {
    @Test
    public void constTest() {
        Assert.assertEquals(Course.MATH, 0);
        Assert.assertEquals(Course.CHINESE, 1);
        Assert.assertEquals(Course.ENGLISH, 2);
        Assert.assertEquals(Course.PROGRAMMING, 3);

        Assert.assertEquals(Course.SIZE, 4);
    }

    @Test
    public void testGetString() {
        Assert.assertEquals("数学", Course.getString(0));
        Assert.assertEquals("语文", Course.getString(1));
        Assert.assertEquals("编程", Course.getString(3));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetStringException1() {
        Course.getString(-1);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetStringException2() {
        Course.getString(Course.SIZE);
    }
}
