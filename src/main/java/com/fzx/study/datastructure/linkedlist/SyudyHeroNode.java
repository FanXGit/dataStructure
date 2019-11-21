package com.fzx.study.datastructure.linkedlist;

public class SyudyHeroNode {
    public int no;
    public String name;
    public String nickname;
    public SyudyHeroNode next; //指向下一个节点

    public SyudyHeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }


    @Override
    public String toString() {
        return "SingleLinkListed{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", next=" + next +
                '}';
    }
}
