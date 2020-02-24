package com.fzx.study.datastructure.sparsearray;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 原始数组与稀疏数组 之间相互转换demo
 */
public class SpareseArray {
    public static void main(String[] args) {

        // 创建一个原始的二维数组 11 * 11,并初始化数据
        // 0: 表示没有棋子， 1 表示 黑子 2 表蓝子
        int dataArray[][] = new int[11][11];
        dataArray[1][2] = 1;
        dataArray[2][3] = 2;
        out(dataArray);
        //将二维数组 转化成稀疏数组
        //转换成稀疏数组
        int[][] spareseArray = dataArrayToSpareseArray(dataArray);
        out(spareseArray);
        //将 稀疏数组 存入map.data中
        Map<Integer, String> map = inMap(spareseArray);
        //有map还原 稀疏数组
        int[][] spareseArrayFromData = mapToSpareseArray(map);
        out(spareseArrayFromData);
        //由稀疏数组还原到 正常数组
        int[][] dataArrayFromSparese = spareseArrayToDataArray(spareseArrayFromData);
        out(dataArrayFromSparese);
    }

    public static void out(int[][] arrays) {
        for (int[] ints : arrays) {
            for (int anInt : ints) {
                System.out.print("\t" + anInt);
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------------");
    }

    /**
     * 将原始数组 转换成稀疏数组
     *
     * @param dataArray
     * @return
     */
    private static int[][] dataArrayToSpareseArray(int[][] dataArray) {
        int sum = 0;
        for (int[] ints : dataArray) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    sum++;
                }
            }
        }
        int spareseArray[][] = new int[sum + 1][3];
        spareseArray[0][0] = dataArray.length;
        spareseArray[0][1] = dataArray[0].length;
        spareseArray[0][2] = sum;
        //定义稀疏数组变量  控制稀疏数组的行
        int count = 1;
        for (int i = 0; i < dataArray.length; i++) {
            for (int j = 0; j < dataArray[i].length; j++) {
                if (dataArray[i][j] != 0) {
                    spareseArray[count][0] = i;
                    spareseArray[count][1] = j;
                    spareseArray[count][2] = dataArray[i][j];
                    count++;
                }
            }
        }
        return spareseArray;
    }

    /**
     * 将稀疏数组存储到map中
     */

    public static Map<Integer, String> inMap(int spareseArray[][]) {
        Map<Integer, String> map = new HashMap();
        for (int i = 0; i < spareseArray.length; i++) {
            String value = spareseArray[i][0] + ":" + spareseArray[i][1] + ":" + spareseArray[i][2];
            map.put(i, value);
        }
        return map;
    }

    public static int[][] mapToSpareseArray(Map<Integer, String> map) {
        int spareseArrayFromData[][] = new int[map.size()][3];
        //将 稀疏数组在map.tada中取出来
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();

            String data[] = entry.getValue().split(":");
            spareseArrayFromData[entry.getKey()][0] = Integer.parseInt(data[0]);
            spareseArrayFromData[entry.getKey()][1] = Integer.parseInt(data[1]);
            spareseArrayFromData[entry.getKey()][2] = Integer.parseInt(data[2]);
        }
        return spareseArrayFromData;
    }

    public static int[][] spareseArrayToDataArray(int[][] spareseArray) {
        int dataArrayFromSparese[][] = new int[spareseArray[0][0]][spareseArray[0][1]];
        for (int i = 1; i < spareseArray.length; i++) {
            dataArrayFromSparese[spareseArray[i][0]][spareseArray[i][1]] = spareseArray[0][2];
        }
        return dataArrayFromSparese;
    }
}
