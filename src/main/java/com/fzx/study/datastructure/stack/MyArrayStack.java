package com.fzx.study.datastructure.stack;

import java.util.Scanner;
import java.util.Stack;

public class MyArrayStack {
    private Object stack[];

    private int maxSize;
    private int top = -1;

    MyArrayStack(int size) {
        stack = new Object[size];
        maxSize = size;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return maxSize == top + 1;
    }

    public void push(Object object) {
        if (isFull()) {
            System.out.println("元素以满，无法添加------");
            return;
        }

        top++;
        stack[top] = object;
    }

    public Object pop() {
        if (isEmpty()) {
            System.out.println("元素为空,无法pop出元素------");
            throw new RuntimeException("元素为空,无法pop出元素------");
        }
        Object object = stack[top];
        top--;
        return object;
    }

    public void list() {
        for (int i = top; i >= 0; i--) {
            System.out.print("\t" + stack[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyArrayStack myArrayStack = new MyArrayStack(100);
        boolean loop = true;
        String key = "";
        Scanner scanner = new Scanner(System.in);


        while (loop) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");
            System.out.println("请输入你的选择");

            key = scanner.next();


            switch (key) {
                case "show":
                    myArrayStack.list();
                    break;
                case "exit":
                    loop = false;
                    break;
                case "push":
                    System.out.print("请输入要入栈的元素：");
                    key = scanner.next();
                    myArrayStack.push(key);
                    System.out.println("插入成功");
                    break;
                case "pop":
                    try {
                        System.out.println("栈顶元素为："+myArrayStack.pop());
                    }catch (RuntimeException e){
                        System.out.println("发生异常:"+e.getMessage());
                    }
                    break;
                default:
                    System.out.println("无法识别字符串，请重新输入！");
                    break;
            }


        }

        scanner.close();
        System.out.println("程序退出~~~");
    }


}
