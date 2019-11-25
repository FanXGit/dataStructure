package com.fzx.study.datastructure.linkedlist;

import com.fzx.study.datastructure.mytest.HeroNode;

import java.util.Stack;

public class LinkedListInterviewQuestions {

    /**
     * 4.3.1)、求单链表中有效节点的个数
     * 4.4.4)、从尾到头打印单链表（百度）
     * 4.4.5) 合并两个有序的单链表，合并之后的链表依然有序(课后练习）
     */


    public static int getLength(MyHeroNode myHeroNode) {
        int size = 0;
        MyHeroNode temp = myHeroNode;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
            size++;
        }

        return size;
    }

    // 4.3.2)、查找单链表中倒数第K个节点（新浪面试题）
    public static MyHeroNode findLastIndexNode(MyHeroNode myHeroNode, int index) {
        if (myHeroNode == null || myHeroNode.next == null) {
            return null;
        }

        int length = getLength(myHeroNode);

        if (length == 0 || length < index) {
            return null;
        }

        index = length - index;

        MyHeroNode indexHeroNode = myHeroNode;
        for (int i = 0; i <= index; i++) {
            indexHeroNode = indexHeroNode.next;
        }


        return indexHeroNode;
    }

    public static void reversalLinkedList(MyHeroNode myHeroNode) {

        if (myHeroNode.next == null || myHeroNode.next.next == null) {
            return;
        }
        MyHeroNode reverseHead = new MyHeroNode(0, "", "");
        MyHeroNode cur = myHeroNode.next;
        MyHeroNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }

        myHeroNode.next = reverseHead.next;
    }

    public static void endToHeadPrint(MyHeroNode myHeroNode) {
        Stack stack = new Stack();

        MyHeroNode temp = myHeroNode;
        while (temp.next != null) {
            stack.add(temp.next);
            temp = temp.next;
        }

        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    public static MyHeroNode mergeHeroNode(MyHeroNode nodeOne, MyHeroNode nodeTwo) {
        MyHeroNode mergerNode = new MyHeroNode(0, "", "");
        MyHeroNode big;
        MyHeroNode small;

        if (nodeOne.next.no > nodeTwo.next.no) {
            small = nodeTwo;
            big = nodeOne;
        } else {
            big = nodeTwo;
            small = nodeOne;
        }
        mergerNode.next = small.next;
        MyHeroNode temp = mergerNode.next;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = big.next;

        return mergerNode;
    }
}
