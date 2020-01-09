package com.fzx.study.datastructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 1、逆波兰表达式计算器
 * 2、中缀表达式转 后缀表达式
 */
public class PolandNotation {
    public static void main(String[] args) {
        System.out.println((int)'0' +" "+(int)'9');

        //先定义给逆波兰表达式 //(30+4)×5-6 =>304+5 × 6-=>164 //4*5-8+60+8/2=>45*8-60+82/+ //测试 //说明为了方便，逆波兰表达式 的数字和符号使用空格隔开
        // StringsuffixExpression="304+5*6-";
        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";//76 //思路 //1. 先将 "34+5 × 6-"=> 放到 ArrayList 中 //2. 将 ArrayList 传递给一个方法，遍历 ArrayList 配合栈 完成计算
        List<String> list = getListString(suffixExpression);
        System.out.println("rpnList=" + list);
        int res = calculate(list);
        System.out.println("计算的结果是=" + res);
    }

    private static Stack<String> numStack =new Stack<>();



    public static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String s : split) {
            list.add(s);
        }
        return list;
    }

    public static int calculate(List<String> stringList) {
        for (String str : stringList) {
            if (isNum(str)) {
                numStack.push(str);
            } else {
                int secondNum = Integer.parseInt(numStack.pop());
                int firstNum = Integer.parseInt(numStack.pop());
                int num = calculateByIdentifier(firstNum, secondNum, str.charAt(0));
                numStack.push(num + "");
            }
        }


        return Integer.parseInt(numStack.peek());
    }

    public static int calculateByIdentifier(int firstNum, int secondNum, char identifier) {

        int num;
        switch (identifier) {
            case '+':
                num = firstNum + secondNum;
                break;
            case '-':
                num = firstNum - secondNum;
                break;
            case '*':
                num = firstNum * secondNum;
                break;
            case '/':
                num = firstNum / secondNum;
                break;
            default:
                throw new RuntimeException("无法识别运算符");
//                num =0;
//                break;
        }

        return num;
    }

    /**
     * 判断符号是否是数字
     *
     * @param string
     * @return
     */
    public static boolean isNum(String string) {
        return string.matches("\\d+");
    }




}
