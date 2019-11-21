package com.fzx.study.datastructure.linkedlist;

public class MySingleLinkedList {
    private MyHeroNode head = new MyHeroNode(0, "", "");


    public void add(MyHeroNode myHeroNode) {
        MyHeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }

        temp.next = myHeroNode;
    }

    public void addByOrder(MyHeroNode myHeroNode) {
        MyHeroNode temp = head;
        Boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > myHeroNode.no) {
                break;
            } else if (temp.next.no == myHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            System.out.println("元素已存在，无法添加！！");
            return;
        }

        myHeroNode.next = temp.next;
        temp.next = myHeroNode;
    }

    public boolean update(MyHeroNode myHeroNode) {
        boolean flag = false;
        MyHeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                System.out.println("元素不存在，无法修改");
                break;
            }
            if (myHeroNode.no == temp.next.no) {
                flag = true;
                myHeroNode.next = temp.next.next;
                temp.next = myHeroNode;
                break;
            }
            temp = temp.next;
        }
        return flag;
    }

    public boolean remove(MyHeroNode myHeroNode) {
        boolean flag = false;
        MyHeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                System.out.println("元素不存在，无法删除");
                break;
            }

            if (temp.next.no == myHeroNode.no) {
                flag = true;
                temp.next = temp.next.next;
                System.out.println("删除成功");
                break;
            }
            temp = temp.next;
        }
        return flag;
    }

    public void list() {
        MyHeroNode myHeroNode = head;
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
