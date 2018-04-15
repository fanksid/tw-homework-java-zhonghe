package com.tw;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LibraryTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setUp(){
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testMain() {

        String input = "1\n" +
                "张三, a, 数学: 75, 语文: 95, 英语: 80, 编程: 80\n" +
                "张三, 1, 数学: 75, 语文: 95, 英语: 80, 编程: 80\n" +
                "1\n" +
                "李四, 2, 数学: 85, 语文: 80, 英语: 70, 编程: 90\n" +
                "2\n" +
                "1, 2, 3\n" +
                "3\n";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Library.main(null);

        String result = "1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出\n" +
                "请输入你的选择（1～3）：" +
                "请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n" +
                "请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：\n" +
                "学生张三的成绩被添加\n" +
                "1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出\n" +
                "请输入你的选择（1～3）：" +
                "请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n" +
                "学生李四的成绩被添加\n" +
                "1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出\n" +
                "请输入你的选择（1～3）：" +
                "请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n" +
                "成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分\n" +
                "========================\n" +
                "张三|75|95|80|80|82.5|330\n" +
                "李四|85|80|70|90|81.25|325\n" +
                "========================\n" +
                "全班总分平均数：327.5\n" +
                "全班总分中位数：327.5\n" +
                "1. 添加学生\n" +
                "2. 生成成绩单\n" +
                "3. 退出\n" +
                "请输入你的选择（1～3）：";

        Assert.assertEquals(systemOut(), result);
    }

    private String systemOut() {
        return outContent.toString();
    }
}
