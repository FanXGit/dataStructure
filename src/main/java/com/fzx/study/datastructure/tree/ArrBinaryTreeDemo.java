package com.fzx.study.datastructure.tree;

/**
 * <p>Title: ArrBinaryTreeDemo</p>
 * <p>Description: </p>
 * <p>Company: moxin</p>
 *
 * @author Fzx
 * @version 1.0
 * @date 2020/2/21 0021 下午 4:15
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};

        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();
    }
}


class ArrBinaryTree {
    private int[] arr = null;

    public ArrBinaryTree(int arr[]) {
        this.arr = arr;
    }

    public void preOrder() {
        preOrder(0);
    }

    public void preOrder(int n) {
        if (n < arr.length) {
            System.out.println("当前节点是：" + arr[n]);

            if ((2 * n + 1) < arr.length) {
                this.preOrder(2 * n + 1);
            }

            if ((2*n+2)<arr.length){
                this.preOrder(2 * n + 2);
            }

        }


    }
}
