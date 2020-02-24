package com.fzx.study.datastructure.huffmancode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: HuffmanCodeDemo</p>
 * <p>Description: </p>
 * <p>Company: moxin</p>
 *
 * @author Fzx
 * @version 1.0
 * @date 2020/2/23 0023 下午 9:21
 */
public class HuffmanCodeDemo {
    static Map<Byte, Integer> byteIntegerMap = new HashMap<>();

    public static void main(String[] args) {
        String value = "i like like like java do you like a java";
        byte b[] = value.getBytes();
//        System.out.println(value.length() == b.length);
//        System.out.println(Arrays.toString(b));
        getByteMap(b);
        System.out.println(byteIntegerMap);
    }

    public static Map<Byte, Integer> getByteMap(byte b[]) {

        for (int i = 0; i < b.length; i++) {
            Integer counts = byteIntegerMap.get(b[i]);
            if (counts != null) {
                byteIntegerMap.put(b[i], counts + 1);
            } else {
                byteIntegerMap.put(b[i], 1);
            }
        }
        return byteIntegerMap;
    }
}

class Node implements Comparable<Node> {
    Byte data;
    int weight;
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    public void preOrder() {
        System.out.println(this);
        if (this.getLeft() != null) {
            this.getLeft().preOrder();
        }

        if (this.right != null) {
            this.getRight().preOrder();
        }
    }
}
