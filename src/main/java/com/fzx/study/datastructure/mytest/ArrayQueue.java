package com.fzx.study.datastructure.mytest;

/**
 * 手写环形队列
 */
public class ArrayQueue {
    public int maxsize;  //元素最大个数
    public int rear;    //队列后移位置，初始值为0
    public int front;   // 队列前置位置，初始值为0
    public Object arr[]; //存放元素

    public ArrayQueue(int maxsize) {
        this.maxsize = maxsize;
        arr = new Object[maxsize];
    }

    public boolean isEmpty() {
        return this.rear == this.front;
    }

    public boolean isFull() {
        return (this.rear + 1) % maxsize == this.front;
    }

    public void add(Object object) {
        if (isFull()) {
            System.out.println("队列已满，无法添加元素");
            return;
        }
        arr[rear] = object;
        rear = (rear + 1) % maxsize;
    }

    public Object get() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法获取到元素");
        }
        Object temp = arr[front];
        front = (front + 1) % maxsize;
        return temp;
    }

    public int size() {
        return (rear + maxsize - front) % maxsize;
    }

    public void showQueue() {
        if (isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.println("arr[" + i % maxsize + "] :" + arr[i % maxsize]);
        }
    }

    public void showHeadQueue(){
        System.out.println(arr[front]);
    }
}
