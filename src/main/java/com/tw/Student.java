package com.tw;

import java.util.List;

public class Student {
    private String name;
    private int id;
    // 虽然题目中成绩是整数，但根据自然定义，成绩应该是一个double
    private List<Double> grade;
    private double avgGrade;
    private double totalGrade;

    public Student(String name, int id, List<Double> grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;

        totalGrade = grade.stream().mapToDouble(x -> x).summaryStatistics().getSum();
        avgGrade = totalGrade / Course.SIZE;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("姓名: %s, id: %d", getName(), getId()));
        for (int i = 0; i < Course.SIZE; i++) {
            String courseName = Course.getString(i);
            stringBuilder.append(", " + courseName + ": ");

            stringBuilder.append(Util.removeDecimalPointIfNecessary(grade.get(i)));
        }
        return stringBuilder.toString();
    }

    public double getGrade(int courseId) {
        return grade.get(courseId);
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public double getTotalGrade() {
        return totalGrade;
    }
}
