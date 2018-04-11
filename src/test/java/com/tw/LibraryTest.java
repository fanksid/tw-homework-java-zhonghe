package com.tw;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
    }

    private String systemOut() {
        return outContent.toString();
    }
}
