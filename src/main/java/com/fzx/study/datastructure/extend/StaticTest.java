package com.fzx.study.datastructure.extend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StaticTest {
    public static void main(String[] args) {
        System.out.println("--------------------I am main");

        StaticTest test=new StaticTest();

        System.out.println(test.toString());
        System.out.println(StaticTest.otherInt);


        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);
        System.out.println("原始数组:");
        System.out.println(arrayList);
        // void reverse(List list)：反转
        Collections.reverse(arrayList);
        System.out.println("Collections.reverse(arrayList):");
        System.out.println(arrayList);


        Collections.rotate(arrayList, 4);
        System.out.println("Collections.rotate(arrayList, 4):");
        System.out.println(arrayList);

        String[] myArray = { "Apple", "Banana", "Orange" ,"213","213"};
        List<String> myList = Arrays.asList(myArray);
//        //上面两个语句等价于下面一条语句
//        List<String> myList = Arrays.asList("Apple","Banana", "Orange");

        System.out.println(myList.toString());
  //      myArray[1]="GaoDong";
        myList.get(0);
        System.out.println(myList.toString());

        System.out.println(15>>1);

        int[] a = new int[10];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        a[3] = 3;
        System.arraycopy(a, 1, a, 5, 3);
        //a[2]=99;
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+"\t");
        }


        int[] a1 = new int[3];
        a1[0] = 0;
        a1[1] = 1;
        a1[2] = 2;
        int[] b = Arrays.copyOf(a1, 100);
        System.out.println("b.length"+b.length);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]+"\t");
        }
    }
  private static int anInt;
  static {
      anInt=3;
      System.out.println(anInt);
   //   System.out.println(otherInt);  在之后的静态代码块无法被使用
  }

   static int otherInt;



}
