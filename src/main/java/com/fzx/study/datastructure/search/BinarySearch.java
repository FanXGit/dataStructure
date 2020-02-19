package com.fzx.study.datastructure.search;

/**
 * <p>Title: BunarySearch</p>
 * <p>Description: </p>
 * <p>Company: moxin</p>
 *
 * @author Fzx
 * @version 1.0
 * @date 2020/2/18 0018 下午 6:06
 */
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        //  int index = binarySearch(arr, 0, arr.length, 11);
        int resIndex = binarySearch(arr, 0, arr.length - 1, 10);
        System.out.println("resIndex=" + resIndex);

    }


    public static int binarySearch(int arr[], int left, int right, int value) {
        int mid = (left + right) / 2;
        if (left > right) {
            return -1;
        }
        if (arr[mid] > value) {
            return binarySearch(arr, left, mid - 1, value);
        } else if (arr[mid] < value) {
            return binarySearch(arr, mid + 1, right, value);
        } else {
            return mid;
        }

    }

}
