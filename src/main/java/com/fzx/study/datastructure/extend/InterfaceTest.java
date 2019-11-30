package com.fzx.study.datastructure.extend;

public interface InterfaceTest extends Appendable ,AutoCloseable {
    default void say(){
        System.out.println("i am say()");
    }
    void hear();
}
