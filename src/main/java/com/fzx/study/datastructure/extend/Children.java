package com.fzx.study.datastructure.extend;

public class Children extends Parent {
    public  int num;
    public Children(int num, String name) {
        super(num, name);
    }
    public void say(){
        System.out.println(num);
    }
}
