package com.fzx.study.datastructure.mytest;

public class LinkedList {
    private HeroNode headNode = new HeroNode(0, "", "");

    public void add(HeroNode heroNode) {
        HeroNode temp = headNode;
        while (true) {
            if (temp.next == null) {
                break;
            }

            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void addByOder(HeroNode heroNode) {
        HeroNode temp = headNode;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }

            if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            } else if (temp.next.no > heroNode.no) {
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("元素已存在，无法添加");
        }
        heroNode.next = temp.next;
        temp.next = heroNode;
    }


    public void list() {
        if (headNode.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = headNode.next;
        while (true) {

            if (temp != null) {
                System.out.println(temp.toString());
            } else {
                break;
            }
            temp = temp.next;
        }
    }
}
