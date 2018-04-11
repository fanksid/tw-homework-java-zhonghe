package com.tw;

public abstract class MenuItem {
    private String name;

    public MenuItem(String name) {
        this.name = name;
    }

    public abstract void performAction(GradeList gradeList);

    public String getName() {
        return name;
    }
}
