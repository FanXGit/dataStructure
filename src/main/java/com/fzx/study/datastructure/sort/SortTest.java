package com.fzx.study.datastructure.sort;

import java.util.Arrays;

/**
 * <p>Title: SortTest</p>
 * <p>Description: </p>
 * <p>Company: moxin</p>
 *
 * @author Fzx
 * @version 1.0
 * @date 2020/2/7 0007 下午 2:45
 */
public class SortTest {

    public static void main(String[] args) {
        int arr[] = {3, 11, 8, -2, 2, -99};


        //int arr[] = {-9, 1, 8, 12, 22, 999};
        /*
            冒泡排序 第一次排序
             3 11 8 -2 2 -99
            3 8 11 -2 2 -99
            3 8 -2 11 2 -99
             3 8 -2 2 11 -99
             3 8 -2 2 -99 11
         */
        //bubbleSort(arr); //冒泡排序
        //bubbleSortPlus(arr); //改进冒泡排序
        //selectSort(arr);//选择排序
        //insertSort(arr); //插入排序
        //shellSort(arr);  //希尔排序 互换法
        shellSort2(arr);   //希尔排序 插值法
        System.out.println(Arrays.toString(arr));


    }

    public static void bubbleSort(int arr[]) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 改进冒泡排序
     *
     * @param arr
     */
    public static void bubbleSortPlus(int arr[]) {
        boolean flag = true;
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }

            }
            if (flag) {
                break;
            } else {
                flag = true;
            }
        }
    }

    public static void selectSort(int arr[]) {
        int minIndex = 0;
        int minValue = 0;

        for (int i = 0; i < arr.length - 1; i++) {

            minIndex = i;
            minValue = arr[i];
            for (int j = i; j < arr.length; j++) {

                if (minValue > arr[j]) {
                    minIndex = j;
                    minValue = arr[j];
                }
            }

            if (i != minIndex) {
                arr[minIndex] = arr[i];
                arr[i] = minValue;
            }
        }


    }

    /**
     * 插入排序 ，需要练习
     *
     * @param arr
     */
    public static void insertSort(int arr[]) {
        int insertIndex = 0;
        int insertValue = 0;

        for (int i = 1; i < arr.length; i++) {
            insertIndex = i - 1;
            insertValue = arr[i];
            while (insertIndex >= 0 && arr[insertIndex] > insertValue) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertValue;
            }

        }
    }


    public static void shellSort(int arr[]) {
        int temp = 0;

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }

            }
        }

    }

    public static void shellSort2(int arr[]) {

        int insertIndex = 0;

        int insertValue = 0;

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                insertIndex = i - gap;
                insertValue = arr[i];
                while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                    arr[insertIndex + gap] = arr[insertIndex];
                    insertIndex -= gap;
                }

                if (insertIndex + gap != i) {
                    arr[insertIndex + gap] = insertValue;
                }
            }
        }

    }

    public static void quickSort(int arr[], int left, int right) {

    }

}





