package com.tw;

public class Student {
    private String name;
    private int id;
    private double[] grade;
    private double avgGrade;
    private double totalGrade;

    public Student(String name, int id, double[] grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;

        totalGrade = calcTotalGrade();
        avgGrade = totalGrade / Course.SIZE;
    }

    // TODO: 使用Stream API改进求和计算
    private double calcTotalGrade() {
        double sum = 0;
        for (int i = 0; i < Course.SIZE; i++) {
            sum += grade[i];
        }
        return sum;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("姓名: %s, id: %d", getName(), id));
        for (int i = 0; i < Course.SIZE; i++) {
            String courseName = Course.getString(i);
            stringBuilder.append(", " + courseName + ": ");

            // 确保当成绩为整数时，不输出小数点
            double courseGrade = grade[i];
            if (Util.floatIsInt(courseGrade)) {
                stringBuilder.append(Math.round(courseGrade));
            } else {
                stringBuilder.append(courseGrade);
            }
        }
        return stringBuilder.toString();
    }

    public double getGrade(int courseId) {
        return grade[courseId];
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public double getTotalGrade() {
        return totalGrade;
    }
}
