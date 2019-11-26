package com.fzx.study.datastructure.linkedlist;

public class CircleSingleLinkedList {

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();

        circleSingleLinkedList.countBoy(1, 2, 5);

        DoubleCircleSingleLinkedList doubleCircleSingleLinkedList = new DoubleCircleSingleLinkedList();
        doubleCircleSingleLinkedList.addDoubleBoy(5);
        doubleCircleSingleLinkedList.showBoy();
        doubleCircleSingleLinkedList.countBoy(1, 2, 5);
    }

    // 创建一个 first 节点,当前没有编号
    private Boy first = null;

    public void addBoy(int nums) {
        // nums 做一个数据校验
        if (nums < 1) {
            System.out.println("nums 的值不正确");
            return;
        }
        // 辅助指针，帮助构建环形链表
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            // 根据编号，创建小孩节点
            Boy boy = new Boy(i);
            // 如果是第一个小孩
            if (i == 1) {
                first = boy;
                first.setNext(boy); // 构成环
                curBoy = boy;       // 让 curBoy 指向第一个小孩
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    public void showBoy() {
        if (first == null) {
            System.out.println("没有任何小孩");
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号 %d \n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                // 说明已经遍历完毕
                break;
            }
            curBoy = curBoy.getNext(); // curBoy 后移
        }
    }


    // 根据用户的输入，计算出小孩出圈的顺序

    /***
     *  @param startNo 表示从第几个小孩开始数数
     * @param countNum  表示数几下
     * @param nums  表示最初有多少小孩在圈中
     */

    public void countBoy(int startNo, int countNum, int nums) {

        // 先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误， 请重新输入");
            return;
        }
        Boy helper = first;
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        while (true) {
            if (helper == first) {
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println(first.getNo() + "号出局");
            first = first.getNext();
            helper.setNext(first);
            ;
        }
        System.out.println("圈里最后剩" + first.getNo() + "");

    }
}

class Boy {
    private int no;// 编号
    private Boy next; // 指向下一个节点,默认 null

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}

class DoubleBoy {
    private int no;// 编号
    private DoubleBoy next; // 指向下一个节点,默认 null
    private DoubleBoy pre;

    public DoubleBoy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public DoubleBoy getNext() {
        return next;
    }

    public void setNext(DoubleBoy next) {
        this.next = next;
    }

    public DoubleBoy getPre() {
        return pre;
    }

    public void setPre(DoubleBoy pre) {
        this.pre = pre;
    }


}

class DoubleCircleSingleLinkedList {
    private DoubleBoy first = null;

    public void addDoubleBoy(int nums) {
        DoubleBoy cuiDouBoy = null;
        for (int i = 1; i <= nums; i++) {
            DoubleBoy doubleBoy = new DoubleBoy(i);

            if (1 == i) {
                first = doubleBoy;
                first.setNext(doubleBoy);
                first.setPre(doubleBoy);
                cuiDouBoy = doubleBoy;
            } else {
                doubleBoy.setNext(first);
                doubleBoy.setPre(cuiDouBoy);
                cuiDouBoy.setNext(doubleBoy);
                first.setPre(doubleBoy);
                cuiDouBoy=doubleBoy;
            }
        }
    }


    public void showBoy() {
        if (first == null) {
            System.out.println("没有任何小孩");
            return;
        }
        DoubleBoy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号 %d \n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                // 说明已经遍历完毕
                break;
            }
            curBoy = curBoy.getNext(); // curBoy 后移
        }
    }


    // 根据用户的输入，计算出小孩出圈的顺序

    /***
     *  @param startNo 表示从第几个小孩开始数数
     * @param countNum  表示数几下
     * @param nums  表示最初有多少小孩在圈中
     */

    public void countBoy(int startNo, int countNum, int nums) {


        // 先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误， 请重新输入");
            return;
        }


        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
        }

        while (true) {
            if (first== first.getNext()) {
                System.out.println(first.getNo() + "完毕");
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
            }
            System.out.println(first.getNo() + "号出局");
            first.getPre().setNext(first.getNext());
            first.getNext().setPre(first.getPre());

            first = first.getNext();
            showBoy();
        }
        System.out.println("圈里最后剩" + first.getNo() + "");

    }
}