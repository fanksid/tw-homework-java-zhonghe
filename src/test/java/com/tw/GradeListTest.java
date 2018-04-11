package com.tw;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GradeListTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp(){
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testGradeList() {
        GradeList gradeList = new GradeList();
        Student[] students = new Student[3];
        for (int i = 0; i < students.length; i++) {
            students[i] = mock(Student.class);
        }
        simulateStudent(students);

        for (Student student : students) {
            gradeList.addStudent(student);
        }

        gradeList.display(new ArrayList<>(Arrays.asList(1, 2, 4, 3)));
        String result = "成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分\n" +
                "========================\n" +
                "张三|60|70|100|90|80|320\n" +
                "李四|75|95|80|80|82.5|330\n" +
                "王五|85|80|70|90|81.25|325\n" +
                "========================\n" +
                "全班总分平均数：325\n" +
                "全班总分中位数：325\n";
        Assert.assertEquals(systemOut(), result);
    }

    private void simulateStudent(Student[] students) {
        when(students[0].getName()).thenReturn("张三");
        when(students[0].getId()).thenReturn(1);
        when(students[0].getGrade(0)).thenReturn(60.0);
        when(students[0].getGrade(1)).thenReturn(70.0);
        when(students[0].getGrade(2)).thenReturn(100.0);
        when(students[0].getGrade(3)).thenReturn(90.0);
        when(students[0].getAvgGrade()).thenReturn(80.0);
        when(students[0].getTotalGrade()).thenReturn(320.0);

        when(students[1].getName()).thenReturn("李四");
        when(students[1].getId()).thenReturn(2);
        when(students[1].getGrade(0)).thenReturn(75.0);
        when(students[1].getGrade(1)).thenReturn(95.0);
        when(students[1].getGrade(2)).thenReturn(80.0);
        when(students[1].getGrade(3)).thenReturn(80.0);
        when(students[1].getAvgGrade()).thenReturn(82.5);
        when(students[1].getTotalGrade()).thenReturn(330.0);

        when(students[2].getName()).thenReturn("王五");
        when(students[2].getId()).thenReturn(3);
        when(students[2].getGrade(0)).thenReturn(85.0);
        when(students[2].getGrade(1)).thenReturn(80.0);
        when(students[2].getGrade(2)).thenReturn(70.0);
        when(students[2].getGrade(3)).thenReturn(90.0);
        when(students[2].getAvgGrade()).thenReturn(81.25);
        when(students[2].getTotalGrade()).thenReturn(325.0);
    }

    private String systemOut() {
        return outContent.toString();
    }
}
