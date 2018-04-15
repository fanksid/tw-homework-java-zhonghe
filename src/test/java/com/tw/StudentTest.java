package com.tw;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class StudentTest {
    private Student student;

    @Before
    public void setUp() throws Exception {

        List<Double> grade = Arrays.asList(60.0, 70.0, 100.0, 90.0);
        student = new Student("superxc", 1, grade);
    }

    @Test
    public void testToString() {
        Assert.assertEquals("姓名: superxc, id: 1, 数学: 60, 语文: 70, 英语: 100, 编程: 90", student.toString());
    }

    @Test
    public void testGetGrade() {
        Assert.assertEquals(60, student.getGrade(0), Util.EPS);
        Assert.assertEquals(70, student.getGrade(1), Util.EPS);
    }

    @Test
    public void testGetAvgGrade() {
        Assert.assertEquals(80, student.getAvgGrade(), Util.EPS);
    }

    @Test
    public void testGetTotalGrade() {
        Assert.assertEquals(320, student.getTotalGrade(), Util.EPS);
    }

    @Test
    public void tmpTest() {

    }
}
