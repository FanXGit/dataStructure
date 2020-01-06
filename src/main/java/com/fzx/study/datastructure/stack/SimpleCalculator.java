package com.fzx.study.datastructure.stack;

import java.util.Scanner;
import java.util.Stack;

public class SimpleCalculator {
    //7*2*2-5+1-5+3-4 = ？
    public static void main(String[] args) {
        // System.out.println(calculation("7*2*2-5+1-5+3-4")); ;
        String expression = "7*2*2-5+1-5+3-4";
        Stack stack = new Stack();
        ArrayStack numStack = new ArrayStack<Integer>(10);
        ArrayStack charStack = new ArrayStack<Integer>(10);
        int num1 = 0;
        int num2 = 0;
        int res = 0;
        for (int i = 0; i < expression.length(); i++) {
            int c = expression.charAt(i);

            if (numStack.isNum(c)) {
                //是数字入数字栈
                numStack.push(c - 48);
            } else {
                //入符号栈
                if (charStack.isOper(c)) {
                    if (charStack.isEmpty()) {
                        charStack.push(c);
                    } else {
                        if (charStack.isPriority(c) > charStack.isPriority((int) charStack.peek())) {
                            charStack.push(c);
                        } else {
                            num2 = (int) numStack.pop();
                            num1 = (int) numStack.pop();
                            res = numStack.cal(num1, num2, (int) charStack.pop());
                            charStack.push(c);
                            numStack.push(res);
                        }
                    }

                } else {
                    throw new RuntimeException("无法识别字符" + c);
                }
            }

        }

        while (true) {
            if (charStack.isEmpty()) {
                break;
            }
            num2 = (int) numStack.pop();
            num1 = (int) numStack.pop();
            res =numStack.cal(num1, num2, (int) charStack.pop());
            numStack.push(res);
        }


        System.out.println("运算结果为："+numStack.pop());
    }


//    public static int calculation(String expression) {
//        if (expression == null) {
//            throw new RuntimeException("表达式有误！");
//        }
//
//
//        return cal(num1,num2,(int)charStack.pop());
//    }


}

class ArrayStack<T> {
    protected Object stack[];

    private int maxSize;
    private int top = -1;

    ArrayStack(int size) {
        stack = new Object[size];
        maxSize = size;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return maxSize == top + 1;
    }

    public void push(T object) {
        if (isFull()) {
            System.out.println("元素以满，无法添加------");
            return;
        }

        top++;
        stack[top] = object;
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("元素为空,无法pop出元素------");
            throw new RuntimeException("元素为空,无法pop出元素------");
        }
        T object = (T) stack[top];
        top--;
        return object;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("元素为空,无法pop出元素------");
            throw new RuntimeException("元素为空,无法pop出元素------");
        }
        return (T) stack[top];
    }


    public void list() {
        for (int i = top; i >= 0; i--) {
            System.out.print("\t" + stack[i]);
        }
        System.out.println();
    }


    public int cal(int num1, int num2, int oper) {
        int res = 0;
        if (oper == '*') {
            res = num1 * num2;
        } else if (oper == '/') {
            res = num1 / num2;
        } else if (oper == '+') {
            res = num1 + num2;
        } else if (oper == '-') {
            res = num1 - num2;
        } else {
            throw new RuntimeException("无法识别操作符");
        }
        return res;
    }

    public static void doWithManyOper(char c) {

    }

    public static boolean isNum(int c) {
//        System.out.println(c >= '0');
//        System.out.println(c <= '9');
//        System.out.println(c >= '0' && c <= '9');
        if (c >= '0' && c <= '9') {
            //是数字
            return true;
        } else {
            return false;
        }


    }

    public static int isPriority(int c) {
        if (c == '*' || c == '/') {
            return 1;
        } else if (c == '+' || c == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    public static boolean isOper(int c) {
        if (c == '+' || c == '-' || c == '*' || c == '/') {
            return true;
        }
        return false;
    }

}