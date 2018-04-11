package com.tw;

public class Course {
    public static final int MATH = 0;
    public static final int CHINESE = 1;
    public static final int ENGLISH = 2;
    public static final int PROGRAMMING = 3;

    public static final int SIZE = 4;

    private static String[] courseName = {"数学", "语文", "英语", "编程"};

    /**
     * Return course name of given course id. Caller must promise 0 <= courseId < SIZE
     * @param courseId which course
     * @return course name
     */
    public static String getString(int courseId) {
        return courseName[courseId];
    }
}
