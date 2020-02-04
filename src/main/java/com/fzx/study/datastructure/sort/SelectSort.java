package com.fzx.study.datastructure.sort;

import java.util.Arrays;

/**
 * <p>Title: SelectSort</p>
 * <p>Description:选择排序  </p>
 * <p>Company: moxin</p>
 *
 * @author Fzx
 * @version 1.0
 * @date 2020/2/4 0004 上午 10:22
 */
public class SelectSort {
    public static void main(String[] args) {

        int arr[] = {1, 5, 9, 6, 4, 3, 2, 7, 8};
        selectSort(arr);

        System.out.println(Arrays.toString(arr));
    }


    public static void selectSort(int arr[]) {
        int minIndex = 0;
        for (int i = 0; i < arr.length - 1; i++) {

            minIndex = i;
            for (int j = i + 1; j < arr.length ; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
