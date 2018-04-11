package com.tw;

import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        Menu menu = new Menu();
        GradeList gradeList = new GradeList();

        menu.addMenuItem(new MIAddStudent());
        menu.addMenuItem(new MIGenerate());

        menu.performAction(gradeList);
    }
}
