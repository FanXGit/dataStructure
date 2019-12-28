package com.fzx.study.datastructure.hash;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ArraySizeTest {
    static int MAXIMUM_CAPACITY = Integer.MAX_VALUE - 8;

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        int n=15;
        n|= 15 >>> 2;
        System.out.println(n);


        Map map =new HashMap();
        map.put("d2","g");
        map.put("e1","d");
        map.put("b4","l");
        map.put("c3","s");
        map.put("a5","b");


        System.out.println(map.toString());

        String a="abc";
        String b=new String("abc");

    }


    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
