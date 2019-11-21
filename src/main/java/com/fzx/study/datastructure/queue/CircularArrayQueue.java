package com.fzx.study.datastructure.queue;

/**
 * 环形队列
 */
public class CircularArrayQueue {
    private int maxSize; //表示队列最大容量
    private int rear; //队列尾
    private int front; //队列头
    private Object arr[];// 该数据用于存放数据, 模拟队列

    // 创建队列的构造器
    public CircularArrayQueue(int maxSize) {
        this.maxSize = maxSize ;
        this.rear = 0; //  指向队列尾，指向队列尾的数据(即就是队列最后一个数据)
        this.front = 0;// 指向队列头部，分析出 front 是指向队列头的前一个位置.
        arr = new Object[maxSize];
    }

    //判断队列是否是空的
    public boolean isempty() {
        return this.rear == this.front;
    }

    //判断队列是否是满的
    public boolean isfull() {
        return (this.rear+1) % maxSize == front;
    }

    //向队列里面添加元素
    public void addQueue(Object object) {
        if (isfull()) {
            System.out.println("队列已满，无法添加元素");
            return;
        }
        arr[rear] = object;
        rear = (rear + 1) % maxSize;
    }

    //获取队列中的元素
    public Object getQueue() {
        if (isempty()) {
            throw new RuntimeException("队列已空，无法获取元素");
        }
        Object temp = arr[this.front];
        front = (front + 1) % maxSize;
        return temp;
    }

    public void showQueue() {
        if (isempty()) {
            System.out.println("队列为空，无法遍历队列");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            if (arr[i % maxSize] != null) {
                System.out.println("arr[" + i % maxSize + "] = " + arr[i % maxSize].toString());
            } else {
                System.out.println("arr[" + i % maxSize + "] = " + null);
            }

        }
    }

    public Object headQueue() {
        if (isempty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[front];
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }
}
