package com.fzx.study.datastructure.queue;

import java.util.Scanner;

public class CircularArrayQueueTest {
    public static void main(String[] args) {


        CircularArrayQueue arrayQueue = new CircularArrayQueue(5);
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
                    loop=false;
                    break;
                case 'a':
                    System.out.println("请输入元素：");
                    Object object=scanner.next();
                    arrayQueue.addQueue(object);
                    break;
                case 'g':
                    try {
                        Object o= arrayQueue.getQueue();
                        if (o instanceof String){
                            System.out.println((String) o);
                        }
                        if (o instanceof Character){
                            System.out.println((char) o);
                        }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'z':
                    System.out.println("队列大小:"+arrayQueue.size());
                    break;
                default :
                    System.out.println("字符无效，请重新输入");
                    break;
            }

        }
        System.out.println("程序退出~~");
    }
}
