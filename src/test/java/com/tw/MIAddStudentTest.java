package com.tw;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class MIAddStudentTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setUp(){
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testMIAddStudent() {
        MIAddStudent miAddStudent = new MIAddStudent();
        Assert.assertEquals("添加学生", miAddStudent.getName());
        GradeList gradeList = mock(GradeList.class);

        String input = "张三, 1, 数学: 75, 语文: 95, 英语: 80\n" +
                "张三, 1, 数学: 75, 语文: 95, 英语: 80, 编程: \n" +
                "张三, a, 数学: 75, 语文: 95, 英语: 80, 编程: 80\n" +
                "张三, 1, 数学: 75, 语文: 95, 英语: 80, 编程: 80\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String result = "请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n" +
                "请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：\n" +
                "请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：\n" +
                "请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：\n" +
                "学生张三的成绩被添加\n";

        miAddStudent.performAction(gradeList);

        Assert.assertEquals(systemOut(), result);
        verify(gradeList, times(1)).addStudent(any());
    }

    private String systemOut() {
        return outContent.toString();
    }
}
