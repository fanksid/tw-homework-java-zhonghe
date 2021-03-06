package com.tw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MIAddStudent extends MenuItem{

    public MIAddStudent() {
        super("添加学生");
    }

    public void performAction(GradeList gradeList, Scanner scanner) {
        System.out.print("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n");
        while (true) {
            String line = scanner.nextLine();
            int courseSize = Course.SIZE;

            String[] elems = line.split(",");

            try {
                // 检查输入的项数是否合法
                if (elems.length != 2 + courseSize) {
                    throw new Exception("格式不正确");
                }
                String name = elems[0].trim();
                int stuNo = Integer.parseInt(elems[1].trim());
                List<Double> grades = new ArrayList<>();
                fillGrade(courseSize, elems, grades);

                gradeList.addStudent(new Student(name, stuNo, grades));
                System.out.print(String.format("学生%s的成绩被添加\n", name));
                break;
            } catch (Exception e) {
                System.out.print("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：\n");
            }
        }
    }

    private void fillGrade(int courseSize, String[] elems, List<Double> grades) throws Exception {
        // 初始化为一个非法值，用于后面检查是否所有课程都有成绩
        for (int i = 0; i < courseSize; i++) {
            grades.add(-1.0);
        }

        // 复杂度O(n^2)
        for (int i = 0; i < courseSize; i++) {
            String[] courseNameAndGrade = elems[2 + i].split(":");
            String courseName = courseNameAndGrade[0].trim();
            for (int j = 0; j < courseSize; j++) {
                if (Course.getString(j).equals(courseName)) {
                    grades.set(j, Double.parseDouble(courseNameAndGrade[1]));
                }
            }
        }

        for (int i = 0; i < courseSize; i++) {
            if (grades.get(i) < 0) {
                throw new Exception("格式不正确");
            }
        }
    }
}
