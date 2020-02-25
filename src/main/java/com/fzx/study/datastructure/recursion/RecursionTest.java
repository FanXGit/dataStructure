package com.fzx.study.datastructure.recursion;

public class RecursionTest {

    public static void main(String[] args) {
        test(10);
        System.out.println("阶乘："+factorial(3));
    }

    public static void test(int n){
        System.out.println("n =" +n);
        if (n> 2){
            test(n-1);
        }
        System.out.println("n =" +n);
    }

    public static int factorial(int n){
        if (n>1){
         return factorial(n-1)*n;
        }else {
            return 1;
        }

    }

}
