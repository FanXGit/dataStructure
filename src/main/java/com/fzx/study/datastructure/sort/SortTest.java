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
        //improvedBubbleSort(arr); //改进冒泡排序
        // selectSort(arr);//选择排序
        //insertSort(arr);
        shellSort2(arr);
        System.out.println(Arrays.toString(arr));


    }

    public static void bubbleSort(int arr[]) {

        int c = 0;
        int temp = 0;
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length - 1 - j; i++) {
                System.out.println("比较次数" + c++);
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }

    /**
     * 改进冒泡排序
     *
     * @param arr
     */
    public static void improvedBubbleSort(int arr[]) {
        int c = 0;
        boolean flag = true;
        int temp = 0;
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length - 1 - j; i++) {
                System.out.println("比较次数" + c++);
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    public static void selectSort(int arr[]) {

        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 插入排序 ，需要练习
     *
     * @param arr
     */
    public static void insertSort(int arr[]) {
        int insertIndex = -1;
        int insertValue = 0;

        for (int i = 1; i < arr.length; i++) {
            insertIndex = i - 1;
            insertValue = arr[i];
            while (insertIndex >= 0 && arr[insertIndex] > insertValue) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            if (insertIndex != i) {
                arr[insertIndex + 1] = insertValue;
            }
        }
    }


    public static void shellSort(int arr[]) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        int temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }

    public static void shellSort2(int arr[]) {

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出while后，就给temp找到插入的位置
                    arr[j] = temp;
                }

            }

        }
    }

    public static void quickSort(int arr[],int left,int right){

    }

}





