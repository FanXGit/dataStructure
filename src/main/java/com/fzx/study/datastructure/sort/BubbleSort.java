package com.fzx.study.datastructure.sort;

/**
 * <p>Title: BubbleSort </p>
 * <p>Description: 冒泡排序   与优化后的冒泡排序</p>
 *
 * @author Fzx
 * @version 1.0
 * @date 2020/2/2 0002 下午 9:48
 */
public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = {3, 11, 8, -2, 2, -99};
        basicBubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }


    public static void basicBubbleSort(int[] arr) {
        boolean flag = false;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            if (!flag) {
                break;
            } else {
                flag = false;
            }

        }
    }


}
