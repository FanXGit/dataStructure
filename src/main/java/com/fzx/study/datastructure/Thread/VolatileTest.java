package com.fzx.study.datastructure.Thread;

public class VolatileTest {
    public static void main(String[] args) {
        MyNum myNum = new MyNum();
        new Thread(() -> {
            System.out.println("A线程------------------------开始");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myNum.addNumber();


            System.out.println("A线程---------------------------结束");
        }, "A线程").start();


        new Thread(() -> {
            System.out.println("B线程---------------------开始");
            while (myNum.number == 10){
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                System.out.println( Thread.currentThread().getName()+"number : " +myNum.number);
            }
            System.out.println("B线程-----------------------结束");
        }, "线程B").start();

        while (myNum.number == 10){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println( Thread.currentThread().getName()+"   number : " +myNum.number);
        }
    }



}

class MyNum {
    public   volatile  int number = 10;

    public void addNumber() {
        System.out.println("值修改完成！！");
        number = 100;
    }
}
