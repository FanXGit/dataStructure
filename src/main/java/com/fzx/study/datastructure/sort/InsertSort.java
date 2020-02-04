package com.fzx.study.datastructure.sort;

import java.util.Arrays;

/**
 * <p>Title: InsertSort</p>
 * <p>Description:插入排序 </p>
 * <p>Company: moxin</p>
 *
 * @author Fzx
 * @version 1.0
 * @date 2020/2/4 0004 下午 1:24
 */
public class InsertSort {

    public static void main(String[] args) {
        int arr[] = {1, 5, 9, 6, 4, 3, 2, 7, 8};
        insertSort(arr);

        System.out.println(Arrays.toString(arr));
    }


    public static void insertSort(int arr[]) {
        int insertValue = 0;
        int insertIndex = -1;
        for (int i = 1; i < arr.length; i++) {
            insertValue = arr[i];
            insertIndex = i - 1;

            while (arr[insertIndex] > insertValue && insertIndex >= 0) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertValue;
            }
        }
    }
}
