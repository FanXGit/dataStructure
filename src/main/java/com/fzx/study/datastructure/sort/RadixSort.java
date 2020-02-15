package com.fzx.study.datastructure.sort;

import java.util.Arrays;

/**
 * <p>Title: RadixSort</p>
 * <p>Description: </p>
 * <p>Company: moxin</p>
 *
 * @author Fzx
 * @version 1.0
 * @date 2020/2/6 0006 下午 6:02
 */
public class RadixSort {

    public static void main(String[] args) {
        int arr[] = {53, 3, 542, 748, 14, 214};

        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 基数排序
     */

    public static void radixSort(int arr[]) {
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }

        int maxLength = (maxValue + "").length();

        int bucket[][] = new int[10][arr.length];
        int bucketElementCounts[] = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {

            for (int j = 0; j < arr.length; j++) {
                int k = arr[j] / n % 10;
                bucket[k][bucketElementCounts[k]] = arr[j];
                bucketElementCounts[k]++;
            }

            int index = 0;
            for (int e = 0; e < bucketElementCounts.length; e++) {
                if (bucketElementCounts[e] > 0) {
                    for (int l = 0; l < bucketElementCounts[e]; l++) {
                        arr[index] = bucket[e][l];
                        index += 1;
                    }
                }
                bucketElementCounts[e] = 0;
            }

        }
    }
}


