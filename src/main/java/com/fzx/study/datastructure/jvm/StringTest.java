package com.fzx.study.datastructure.jvm;

public class StringTest {
    public static void main(String[] args) {
        String a = "abc";
        String b = new String("abc");
        String c = new String("");

        String d = b.intern();
        System.out.println(a + c == d + c);
        System.out.println(a.equals(b + c));
        System.out.println(a == d);
    }
}
