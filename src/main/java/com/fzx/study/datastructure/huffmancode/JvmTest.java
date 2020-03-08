package com.fzx.study.datastructure.huffmancode;

public class JvmTest {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(new JvmTest().getClass().getClassLoader().getParent().getParent());
        System.out.println(new JvmTest().getClass().getClassLoader().getParent());
        System.out.println(new JvmTest().getClass().getClassLoader());

        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024);
    }

    public static  void test(){
       // test();
    }
}
