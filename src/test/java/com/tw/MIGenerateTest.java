package com.tw;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class MIGenerateTest{
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setUp(){
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testMIGenerateTest() {
        MIGenerate miGenerate = new MIGenerate();
        Assert.assertEquals("生成成绩单", miGenerate.getName());

        String input = "1, a, 3\n" +
                "1, 2, 3, 4\n";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String result = "请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n" +
                "请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n" +
                "[成绩单]\n";

        GradeList gradeList = mock(GradeList.class);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        miGenerate.performAction(gradeList);
        verify(gradeList, times(1)).display(list);
        verify(gradeList, times(1)).display(any());
    }

    private String systemOut() {
        return outContent.toString();
    }
}
