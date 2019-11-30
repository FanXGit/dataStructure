package com.fzx.study.datastructure.extend;

public class ExtendTest {
    public static void main(String[] args) {
        Parent parent = new Children(0, "张三");

        parent.getNum();

        Children children = new Children(1, "张三的儿子");
        children.getNum();

        System.out.println(parent.equals(children));

        System.out.println(10920 | 1);
    }
}


