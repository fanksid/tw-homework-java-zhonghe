package com.tw;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {
    // TODO: 这里用的都是同一个学生，因此可以考虑把这个学生统一进行初始化
    @Test
    public void testToString() {
        Student student = new Student("superxc", 1, new double[]{60, 70, 100, 90});
        Assert.assertEquals("姓名: superxc, id: 1, 数学: 60, 语文: 70, 英语: 100, 编程: 90", student.toString());
    }

    @Test
    public void testGetGrade() {
        Student student = new Student("superxc", 1, new double[]{60, 70, 100, 90});
        Assert.assertEquals(60, student.getGrade(0), Util.EPS);
        Assert.assertEquals(70, student.getGrade(1), Util.EPS);
    }

    @Test
    public void testGetAvgGrade() {
        Student student = new Student("superxc", 1, new double[]{60, 70, 100, 90});
        Assert.assertEquals(80, student.getAvgGrade(), Util.EPS);
    }

    @Test
    public void testGetTotalGrade() {
        Student student = new Student("superxc", 1, new double[]{60, 70, 100, 90});
        Assert.assertEquals(320, student.getTotalGrade(), Util.EPS);
    }

    @Test
    public void tmpTest() {

    }
}
