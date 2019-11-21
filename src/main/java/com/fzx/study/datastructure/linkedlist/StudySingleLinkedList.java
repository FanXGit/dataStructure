package com.fzx.study.datastructure.linkedlist;

public class StudySingleLinkedList {

    //先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private SyudyHeroNode head = new SyudyHeroNode(0, "", "");

    //添加节点到单向链表
    // 思路，当不考虑编号顺序时
    // 1. 找到当前链表的最后节点
    // 2. 将最后这个节点的 next 指向 新的节点
    public void add(SyudyHeroNode syudyHeroNode) {
        //因为 head 节点不能动，因此我们需要一个辅助遍历temp
        SyudyHeroNode temp = head;
        // 遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后, 将将 temp 后移
            temp = temp.next;
        }
        //当退出 while 循环时，temp 就指向了链表的最后
        // 将最后这个节点的 next 指向 新的节点
        temp.next = syudyHeroNode;
    }

    //显示链表[遍历]
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        SyudyHeroNode temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将 temp 后移， 一定小心
            temp = temp.next;

        }
    }


}
