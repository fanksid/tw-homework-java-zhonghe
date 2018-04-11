package com.tw;

import java.util.Scanner;

public abstract class MenuItem {
    private String name;

    public MenuItem(String name) {
        this.name = name;
    }

    public abstract void performAction(GradeList gradeList, Scanner scanner);

    public String getName() {
        return name;
    }
}
