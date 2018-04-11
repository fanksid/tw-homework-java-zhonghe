package com.tw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MIGenerate extends MenuItem{
    public MIGenerate() {
        super("生成成绩单");
    }

    @Override
    public void performAction(GradeList gradeList) {
        System.out.print("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            try {
                List<Integer> listStuNo = new ArrayList<>();
                String[] stuNos = line.split(",");
                for (String stuNo : stuNos) {
                    listStuNo.add(Integer.parseInt(stuNo.trim()));
                }
                gradeList.display(listStuNo);
                break;
            } catch (Exception e) {
                System.out.print("请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n");
            }
        }
    }
}
