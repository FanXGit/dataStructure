package com.fzx.study.datastructure.hashTab;

import java.util.Scanner;

/**
 * <p>Title: HashTabDemo</p>
 * <p>Description: </p>
 * <p>Company: moxin</p>
 *
 * @author Fzx
 * @version 1.0
 * @date 2020/2/20 0020 �??? 2:41
 */
public class HashTabDemo {
    public static void main(String[] args) {

        HashTab hashTab = new HashTab(10);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add:  ��ӹ�Ա");
            System.out.println("list: ��ʾ��Ա");
            System.out.println("find: ���ҹ�Ա");
            System.out.println("exit: �˳�ϵͳ");

            key = scanner.next();

            if (key.equals("add")) {
                System.out.println("����id");
                int id = scanner.nextInt();
                System.out.println("��������");
                String name = scanner.next();
                Emp emp = new Emp(id, 18, name);
                hashTab.add(emp);
                System.out.println("��ӳɹ�");
            } else if (key.equals("list")) {
                hashTab.list();
            } else if (key.equals("find")) {
                System.out.println("������Ҫ���ҵ�id");
                int id = scanner.nextInt();
                hashTab.findById(id);
            } else if (key.equals("exit")) {
                scanner.close();
                System.exit(0);
            } else {
                System.out.println("û���ҵ������������������");
            }

        }


    }
}
