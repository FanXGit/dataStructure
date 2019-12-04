package com.fzx.study.datastructure.Thread;

import java.util.concurrent.locks.ReentrantLock;

public class Person {

    public  synchronized void say(){
        System.out.println(Thread.currentThread()+" i am say");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        see();
       // ReentrantLock
        ReentrantLock rs=new ReentrantLock(true);
    }


    public  synchronized void see(){
        System.out.println(Thread.currentThread()+" i am see");
    }
}
