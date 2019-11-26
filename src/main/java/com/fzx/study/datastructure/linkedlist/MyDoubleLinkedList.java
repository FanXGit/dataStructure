package com.fzx.study.datastructure.linkedlist;

/**
 * 双向链表Demo
 */
public class MyDoubleLinkedList {
    MyDoubleHeroNode head = new MyDoubleHeroNode(0, "", "");

    public void add(MyDoubleHeroNode myDoubleHeroNode) {
        MyDoubleHeroNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = myDoubleHeroNode;
        myDoubleHeroNode.pre = temp;
    }

    public void update(MyDoubleHeroNode myDoubleHeroNode) {
        boolean flag = false;
        MyDoubleHeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            } else if (temp.no == myDoubleHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;

        }

        if (flag) {
            temp.name = myDoubleHeroNode.name;
            temp.nickName = myDoubleHeroNode.name;
        } else {
            System.out.println("没有找到该" + myDoubleHeroNode.no + " 节点，无法修改");
        }
    }

    public void del(MyDoubleHeroNode myDoubleHeroNode) {
        boolean flag = false;
        MyDoubleHeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            } else if (temp.next.no == myDoubleHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        temp = temp.next;
        if (flag) {
            temp.pre.next = temp.next;
            temp.next.pre = temp.pre;
        }else {
            System.out.println("没有找到该" + myDoubleHeroNode.no + " 节点，无法删除");
        }
    }

    public void list() {
        MyDoubleHeroNode myHeroNode = head;
        if (myHeroNode.next == null) {
            System.out.println("链表为空");
        }
        myHeroNode = head.next;
        while (true) {
            //判断链表是最后一个元素
            if (myHeroNode == null) {
                break;
            }
            System.out.println(myHeroNode.toString());
            myHeroNode = myHeroNode.next;

        }
    }

}
