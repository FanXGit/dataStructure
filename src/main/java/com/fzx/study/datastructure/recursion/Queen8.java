package com.fzx.study.datastructure.recursion;

public class Queen8 {
    int max = 8;
    int arrays[] = new int[max];
    int count = 0;

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);

    }

    public void check(int n) {
        if (n == max) {
            count++;
            print();
            System.out.println("count :" + count);
            return;
        }
        for (int i = 0; i < max; i++) {
            arrays[n] = i;
            if (queenRule(n)) {
                System.out.println("check:" + n);
                check(n + 1);
            }
        }

    }

    public boolean queenRule(int n) {
        for (int i = 0; i < n; i++) {
            if (arrays[i] == arrays[n] || Math.abs(n - i) == Math.abs(arrays[i] - arrays[n])) {
                return false;
            }
        }
        return true;
    }

    public void print() {
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i] + "\t");
        }
        System.out.println();
    }
}
