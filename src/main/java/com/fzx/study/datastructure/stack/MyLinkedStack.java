package com.fzx.study.datastructure.stack;


import java.util.Stack;

public class MyLinkedStack {
    public int no;
    public Object value;
    public MyLinkedStack next;


    public MyLinkedStack(int no, Object key) {
        this.no = no;
        this.value = key;
    }

    public void setNext(MyLinkedStack next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "MyLinkedStack{" +
                "no=" + no +
                ", value=" + value +
                '}';
    }
}

class MyLinkedStackList {
    private MyLinkedStack firstNode = new MyLinkedStack(0, "");

    public void push(MyLinkedStack myLinkedStack) {
        MyLinkedStack linkedStack = firstNode;
        while (linkedStack.next != null) {
            linkedStack = linkedStack.next;
        }
        linkedStack.next = myLinkedStack;
    }

    public void pushByOder(MyLinkedStack myLinkedStack) {
        MyLinkedStack linkedStack = firstNode;

        while (linkedStack.next != null) {
            if (linkedStack.no > myLinkedStack.no) {
                myLinkedStack.next = linkedStack.next;
                linkedStack.next = myLinkedStack;
                return;
            }
            linkedStack = linkedStack.next;
        }
        linkedStack.next = myLinkedStack;
    }

    public boolean isEmpty() {
        return firstNode.next != null;
    }

    public Object pop() {
        if (isEmpty()) {
            System.out.println("元素为空,无法获取元素----------");
        }
        MyLinkedStack linkedStack = firstNode;

        while (linkedStack.next != null) {
            linkedStack = linkedStack.next;
        }
        MyLinkedStack returnValue = new MyLinkedStack(linkedStack.no, linkedStack.value);
        linkedStack = null;
        return returnValue;
    }

    public void list() {
        MyLinkedStack linkedStack = firstNode.next;

//        while (linkedStack != null){
//            System.out.println(linkedStack);
//            linkedStack=linkedStack.next;
//        }
        Stack stack = new Stack();
        while (linkedStack != null) {
            stack.push(linkedStack);
            linkedStack = linkedStack.next;
        }

        for (int i = stack.size()-1; i >= 0; i--) {
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args) {
        MyLinkedStack one1 = new MyLinkedStack(1, 100);
        MyLinkedStack two = new MyLinkedStack(2, 200);
        MyLinkedStack three = new MyLinkedStack(3, 300);
        MyLinkedStack four = new MyLinkedStack(4, 400);
        MyLinkedStack five = new MyLinkedStack(5, 500);

        MyLinkedStackList myLinkedStackList = new MyLinkedStackList();
        myLinkedStackList.push(one1);
        myLinkedStackList.push(five);
        myLinkedStackList.push(three);
        myLinkedStackList.push(two);
        myLinkedStackList.push(four);

        myLinkedStackList.list();


        Stack stack =new Stack();
        stack.peek();
    }
}
