package com.fzx.study.datastructure.thread;

public class DeadLockDemo {
    private static Object resource1 = new Object(); //resource1
    private static Object resource2 = new Object(); //resource2

    private static Person p1 = new Person();


    public static void main(String[] args) {

//        new Thread(() -> {
//            synchronized (resource1){
//                System.out.println(Thread.currentThread() + "get resource1");
//
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread() + "waiting get resource2");
//                synchronized (resource2){
//                    System.out.println(Thread.currentThread() + "get resource2");
//                }
//            }
//        }, "线程1").start();
//
//        new Thread(() ->{
//            synchronized (resource2){
//                System.out.println(Thread.currentThread() + "get resource2");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread() + "waiting get resource1");
//                synchronized (resource1){
//                    System.out.println(Thread.currentThread() + "get resource1");
//                }
//            }
//        },"线程2").start();


        new Thread(() -> {
            System.out.println(Thread.currentThread() + " thread 1 start");
            p1.say();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " thread 1 end");
        }, "线程1").start();


        new Thread(() -> {
            System.out.println(Thread.currentThread() + " thread 2 start");
            p1.see();

            System.out.println(Thread.currentThread() + " thread 2 end");
        }, "线程2").start();
    }
}
