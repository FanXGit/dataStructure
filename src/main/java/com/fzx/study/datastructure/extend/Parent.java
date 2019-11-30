package com.fzx.study.datastructure.extend;

public class Parent {
    private int num;

    public String name;


    public void  sayName(){
        System.out.println(" My Name is "+ name);
    }

    private void  sayNum(){
        System.out.println(" My Num is " +num);
    }

    public Parent(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
