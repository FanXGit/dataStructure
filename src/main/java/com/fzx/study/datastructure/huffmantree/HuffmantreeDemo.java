package com.fzx.study.datastructure.huffmantree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>Title: HuffmantreeDemo</p>
 * <p>Description: </p>
 * <p>Company: moxin</p>
 *
 * @author Fzx
 * @version 1.0
 * @date 2020/2/23 0023 下午 8:33
 */
public class HuffmantreeDemo {


    public static void main(String[] args) {
        int arr[] = {13, 7, 8, 3, 29, 6, 1};
        Node root = Node.createHuffManTree(arr);
        HuffmanTree huffmanTree =new HuffmanTree();
        huffmanTree.setRoot(root);
        huffmanTree.preOrder();
    }
}

class HuffmanTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void preOrder() {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("赫夫曼树为空,无法遍历");
        }
    }
}

class Node implements Comparable<Node> {
    int value;
    Node left;
    Node right;

    private Node(int value) {
        this.value = value;
    }

    public void preOrder() {
        System.out.println(this);

        if (this.getLeft() != null) {
            this.getLeft().preOrder();
        }

        if (this.getRight() != null) {
            this.getRight().preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public static Node createHuffManTree(int arr[]) {

        List<Node> nodes = new ArrayList<Node>();
        for (int i = 0; i < arr.length; i++) {
            nodes.add(new Node(arr[i]));
        }



        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node left = nodes.get(0);
            Node right = nodes.get(1);

            Node parent = new Node(left.value + right.value);
            parent.setLeft(left);
            parent.setRight(right);
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }

        return nodes.get(0);
    }


    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }


    @Override
    public int compareTo(Node node) {
        return this.value - node.value;
    }
}
