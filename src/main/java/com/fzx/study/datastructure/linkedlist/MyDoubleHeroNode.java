package com.fzx.study.datastructure.linkedlist;

public class MyDoubleHeroNode {
    public int no;
    public String name;
    public String nickName;
    public MyDoubleHeroNode next;
    public MyDoubleHeroNode pre;

    public MyDoubleHeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "MyHeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
