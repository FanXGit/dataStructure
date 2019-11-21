package com.fzx.study.datastructure.mytest;

import org.junit.Test;

import java.util.Scanner;

public class MyTest {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        Scanner scanner = new Scanner(System.in);
        char key; //接受用户输入
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("z(size): 显示元素个数");

            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入元素：");
                    Object object = scanner.next();
                    arrayQueue.add(object);
                    break;
                case 'g':
                    try {
                        Object o = arrayQueue.get();
                        if (o instanceof String) {
                            System.out.println((String) o);
                        }
                        if (o instanceof Character) {
                            System.out.println((char) o);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'z':
                    System.out.println("队列大小:" + arrayQueue.size());
                    break;
                default:
                    System.out.println("字符无效，请重新输入");
                    break;
            }

        }
        System.out.println("程序退出~~");
    }

    @Test
    public void TestMyLinkedList() {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        //创建要给链表
        LinkedList singleLinkedList = new LinkedList();
        //加入
        //         singleLinkedList.add(hero1);
        //         singleLinkedList.add(hero4);
        //         singleLinkedList.add(hero2);
        //         singleLinkedList.add(hero3);

        singleLinkedList.addByOder(hero1);
        singleLinkedList.addByOder(hero4);
        singleLinkedList.addByOder(hero2);
        singleLinkedList.addByOder(hero3);
        singleLinkedList.list();
    }
}
