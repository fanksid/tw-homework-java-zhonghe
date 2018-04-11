package com.tw;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Any;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.mockito.Mockito.*;

public class MenuTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setUp(){
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testMenu() {
        Menu menu = new Menu();
        MenuItem menuItem1 = mock(MenuItem.class);
        MenuItem menuItem2 = mock(MenuItem.class);

        GradeList gradeList = mock(GradeList.class);

        when(menuItem1.getName()).thenReturn("菜单项1");
        when(menuItem2.getName()).thenReturn("菜单项2");


        menu.addMenuItem(menuItem1);
        menu.addMenuItem(menuItem2);

        String inputStr = "1\n2\n2\n3\n";
        ByteArrayInputStream in = new ByteArrayInputStream(inputStr.getBytes());
        System.setIn(in);
        menu.performAction(gradeList);
        String result = "1. 菜单项1\n" +
                "2. 菜单项2\n" +
                "3. 退出\n" +
                "请输入你的选择（1～3）：";
        Assert.assertEquals(systemOut(), result + result + result + result);

        verify(menuItem1, times(1)).performAction(any(), any());
        verify(menuItem2, times(2)).performAction(any(), any());
    }

    private String systemOut() {
        return outContent.toString();
    }
}
