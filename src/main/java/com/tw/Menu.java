package com.tw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<MenuItem> menuItems = new ArrayList<>();

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public void performAction(GradeList gradeList) {

        StringBuilder sbPrompts = new StringBuilder();
        int menuItemSize = menuItems.size();
        for (int i = 0; i < menuItemSize; i++) {
            sbPrompts.append((i + 1) + ". " + menuItems.get(i).getName() + "\n");
        }
        sbPrompts.append((menuItemSize + 1) + ". 退出\n");
        sbPrompts.append(String.format("请输入你的选择（1～%d）：", menuItemSize + 1));

        Scanner scanner = new Scanner(System.in);
        String prompts = sbPrompts.toString();

        while (true) {
            System.out.print(prompts);
            int decision = Integer.parseInt(scanner.nextLine().trim());

            if (decision == menuItemSize + 1) {
                break;
            }

            menuItems.get(decision - 1).performAction(gradeList, scanner);
        }
    }
}
