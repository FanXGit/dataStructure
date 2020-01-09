package com.fzx.study.datastructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InfixToSuffix {


    public static void main(String[] args) {
        String expression = "1+((2+3)*4)-5";//注意表达式1 2 3 + 4 * + 5 -
        List<String> infixExpressionList = toSuffixListString(expression);
        System.out.println("中缀表达式对应的 List=" + infixExpressionList);//ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
        List<String> suffixExpressionList = parseSuffixExpreesionList(infixExpressionList);
        System.out.println("逆波兰（后缀）表达式对应的 List=" + suffixExpressionList);//ArrayList[1, 2, 3, +, 4, *, +, 5, -]
        System.out.println("运算结果："+PolandNotation.calculate(suffixExpressionList));
    }

    public static List<String> toSuffixListString(String s) {
        int i = 0;
        List<String> stringList = new ArrayList<>();
        String str = "";
        do {
            if (s.charAt(i) < 48 || s.charAt(i) > 47) {
                stringList.add(s.charAt(i) + "");
                i++;
            } else {
                str = "";
                while (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                    //处理多位数
                    str += s.charAt(i);
                    i++;
                }
                stringList.add(str);
            }

        } while (i < s.length());

        return stringList;
    }

    public static List<String> parseSuffixExpreesionList(List<String> stringList) {
        List<String> numStack = new ArrayList<>();
        Stack<String> charStack = new Stack<>();
        for (String s : stringList) {
            if (isNum(s)) {
                numStack.add(s);
            } else if (s.equals("(")) {
                charStack.push(s);
            } else if (s.equals(")")) {
                while (!charStack.peek().equals("(")) {
                    numStack.add(charStack.pop());
                }
                charStack.pop();

            } else {
                if (charStack.isEmpty() || charStack.peek().equals("(")) {
                    charStack.push(s);
                } else {
                    while (!charStack.isEmpty() && Operation.getValue(s) >= Operation.getValue(charStack.peek())) {
                        numStack.add(charStack.pop());
                    }
                    charStack.push(s);
                }
            }
        }

        while (!charStack.isEmpty()) {
            numStack.add(charStack.pop());
        }

        return numStack;
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

class Operation {

    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String string) {
        if (string.equals("+")) {
            return ADD;
        } else if (string.equals("-")) {
            return SUB;
        } else if (string.equals("*")) {
            return MUL;
        } else if (string.equals("/")) {
            return DIV;
        } else {
            return 0;
        }
    }
}