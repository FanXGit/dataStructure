package com.fzx.study.datastructure.Thread;

public class Person {

    public  synchronized void say(){
        System.out.println(Thread.currentThread()+" i am say");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        see();
    }


    public  synchronized void see(){
        System.out.println(Thread.currentThread()+" i am see");
    }
}
