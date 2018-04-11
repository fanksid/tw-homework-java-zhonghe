package com.tw;

import java.util.*;

public class GradeList {
    private Map<Integer, Student> students = new HashMap<>();

    public void addStudent(Student student) {
        students.putIfAbsent(student.getId(), student);
    }

    public void display(List<Integer> stuNo) {
        StringBuilder sOutput = new StringBuilder();
        sOutput.append("成绩单\n");
        sOutput.append("姓名|数学|语文|英语|编程|平均分|总分\n");
        sOutput.append("========================\n");
        List<Double> listTotal = new ArrayList<>();
        int numberOfStudent = stuNo.size();
        for (Integer elem : stuNo) {
            Student student = students.get(elem);
            if (student == null) {
                numberOfStudent--;
                continue;
            }
            processStudentInfo(sOutput, student, listTotal, elem);
        }
        sOutput.append("========================\n");
        // TODO: 使用Java8 Stream API 进行优化代码
        double totalAvg;
        double sum = 0;
        for (Double elemD : listTotal) {
            sum += elemD;
        }
        totalAvg = sum / numberOfStudent;
        String sTotalAvg = Util.removeDecimalPointIfNecessary(totalAvg);
        sOutput.append("全班总分平均数：" + sTotalAvg + "\n");
        String sTotalMedian = Util.removeDecimalPointIfNecessary(totalMedian(listTotal));
        sOutput.append("全班总分中位数：" + sTotalMedian + "\n");
        System.out.print(sOutput.toString());
    }

    private void processStudentInfo(StringBuilder stringBuilder, Student student, List<Double> listTotal, Integer elem) {
        stringBuilder.append(student.getName() + "|");
        for (int i = 0; i < Course.SIZE; i++) {
            double grade = student.getGrade(i);
            if (Util.floatIsInt(grade)) {
                stringBuilder.append(Math.round(grade));
            } else {
                stringBuilder.append(grade);
            }
            stringBuilder.append("|");
        }
        double totalGrade = student.getTotalGrade();
        String sTotalGrade = Util.removeDecimalPointIfNecessary(totalGrade);
        String sAvgGrade = Util.removeDecimalPointIfNecessary(student.getAvgGrade());
        listTotal.add(totalGrade);
        stringBuilder.append(sAvgGrade + "|" + sTotalGrade + "\n");
    }

    private double totalMedian(List<Double> listTotal) {
        listTotal.sort(null);
        int lastIndex = listTotal.size() - 1;
        if (lastIndex % 2 == 0) {
            return listTotal.get(lastIndex / 2);
        } else {
            return (listTotal.get(lastIndex / 2) + listTotal.get(lastIndex / 2 + 1)) / 2;
        }
    }

}
