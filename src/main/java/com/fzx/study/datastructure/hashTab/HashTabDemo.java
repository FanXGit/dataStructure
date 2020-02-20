package com.fzx.study.datastructure.hashTab;

import java.util.Scanner;

/**
 * <p>Title: HashTabDemo</p>
 * <p>Description: </p>
 * <p>Company: moxin</p>
 *
 * @author Fzx
 * @version 1.0
 * @date 2020/2/20 0020 涓??? 2:41
 */
public class HashTabDemo {
    public static void main(String[] args) {

        HashTab hashTab = new HashTab(10);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add:  添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");

            key = scanner.next();

            if (key.equals("add")) {
                System.out.println("输入id");
                int id = scanner.nextInt();
                System.out.println("输入名字");
                String name = scanner.next();
                Emp emp = new Emp(id, 18, name);
                hashTab.add(emp);
                System.out.println("添加成功");
            } else if (key.equals("list")) {
                hashTab.list();
            } else if (key.equals("find")) {
                System.out.println("请输入要查找的id");
                int id = scanner.nextInt();
                hashTab.findById(id);
            } else if (key.equals("exit")) {
                scanner.close();
                System.exit(0);
            } else {
                System.out.println("没有找到该条命令，请重新输入");
            }

        }


    }
}
