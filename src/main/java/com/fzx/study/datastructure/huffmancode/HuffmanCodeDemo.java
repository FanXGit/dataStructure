package com.fzx.study.datastructure.huffmancode;

import java.io.*;
import java.util.*;

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

    public static Map<Byte, String> huffmanCode = new HashMap<>();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String fileOut = "E:\\百度网盘下载资源\\尚硅谷 Java 数据结构和算法视频教程全集\\ASCII码对照表.bmp";
        String fileAddress = "E:\\百度网盘下载资源\\尚硅谷 Java 数据结构和算法视频教程全集\\src.bmp";
        FileInputStream fileInputStream = new FileInputStream(fileAddress);
        byte fileByte[] = new byte[fileInputStream.available()];
        fileInputStream.read(fileByte);

        byte[] zipByte = huffmanZip(fileByte);

        FileOutputStream fileOutputStream = new FileOutputStream(fileOut);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(zipByte);
        objectOutputStream.writeObject(huffmanCode);

        objectOutputStream.close();
        fileInputStream.close();
        fileInputStream.close();
        System.out.println("压缩成功");




        String fileAddressDecode = "E:\\\\百度网盘下载资源\\\\尚硅谷 Java 数据结构和算法视频教程全集\\ASCII码对照表.bmp";
        String fileOutZipDecode = "E:\\百度网盘下载资源\\尚硅谷 Java 数据结构和算法视频教程全集\\TestDecode.bmp";

        FileInputStream fileInputStreamDecode =new FileInputStream(fileAddressDecode);
        ObjectInputStream objectInputStream =new ObjectInputStream(fileInputStreamDecode);
        //读取byte数组  huffmanBytes
        byte[] huffmanBytes = (byte[])objectInputStream.readObject();
        //读取赫夫曼编码表
        Map<Byte,String> huffmanCodes = (Map<Byte,String>)objectInputStream.readObject();

        byte decodes[] =huffmanDecode(huffmanBytes,huffmanCodes);


        FileOutputStream fileOutputStreamDecode=new FileOutputStream(fileOutZipDecode);

        fileOutputStreamDecode.write(decodes);
        System.out.println("解压成功");


        fileOutputStreamDecode.close();
        fileInputStreamDecode.close();;

//
//        String value = "i like like like java do you like a java ?--|-- 中国加油";
//
//
//        byte zipBytes[] = huffmanZip(value.getBytes());
//
//        huffmanDecode(zipBytes, huffmanCode);
//
//        byte decoBytes[] = huffmanDecode(zipBytes, huffmanCode);
//        System.out.println(new String(decoBytes));

    }

    /**
     * hefuman解压缩
     *
     * @param zipBytes
     * @param huffmanCodes
     * @return
     */

    public static byte[] huffmanDecode(byte zipBytes[], Map<Byte, String> huffmanCodes) {

        StringBuffer stringBuilder = new StringBuffer();
        for (int i = 0; i < zipBytes.length; i++) {
            String str = bytesToStr(!(i + 1 == zipBytes.length), zipBytes[i]);
            stringBuilder.append(str);
        }

        Map<String, Byte> huffmanDecode = new HashMap<>();
        for (Map.Entry<Byte, String> map : huffmanCodes.entrySet()) {
            huffmanDecode.put(map.getValue(), map.getKey());
        }

        List<Byte> byteList = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length(); ) {
            int count = 1;
            boolean flag = true;
            while (flag) {
                String key = stringBuilder.substring(i, i + count);

                if (huffmanDecode.get(key) != null) {
                    byteList.add(huffmanDecode.get(key));
                    i += count;
                    flag = false;
                } else {
                    count++;
                }
            }
        }

        byte huffmanDecodeBytes[] = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            huffmanDecodeBytes[i] = byteList.get(i);
        }
        return huffmanDecodeBytes;

    }

    public static String bytesToStr(boolean flag, byte b) {
        int temp = b;
        if (flag) {
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }

    }


    public static byte[] huffmanZip(byte b[]) {
        List<Node> codeList = getCodeList(b);
        Node root = getHuffManCode(codeList);
        root.preOrder();

        Map huffmanCode = getCodes(root);
        byte huffmanCodeBytes[] = zip(b, huffmanCode);
        return huffmanCodeBytes;
    }


    public static byte[] zip(byte b[], Map<Byte, String> huffmanCode) {
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < b.length; i++) {
            stringBuffer.append(huffmanCode.get(b[i]));
        }


        int length;
        /**
         * 这个判断可以写成 length =(stringBuffer.length()+7)/8
         */
        if (stringBuffer.length() % 8 == 0) {
            length = stringBuffer.length() / 8;
        } else {
            length = stringBuffer.length() / 8 + 1;
        }
        //创建 存储压缩后的 byte数组
        byte[] huffmanCodeBytes = new byte[length];
        String temp = new String();
        int index = 0;
        for (int i = 0; i < stringBuffer.length(); i += 8) {

            if ((i + 8) < stringBuffer.length()) {
                temp = stringBuffer.substring(i, i + 8);
            } else {
                temp = stringBuffer.substring(i);
            }
            huffmanCodeBytes[index] = (byte) Integer.parseInt(temp, 2);
            index++;
        }
        return huffmanCodeBytes;
    }

    /**
     * 根据赫夫曼树 生成每一个元素的代码
     */
    public static Map<Byte, String> getCodes(Node root) {

        if (root == null) {
            return null;
        } else {
            getCodes(new StringBuffer(), root.getLeft(), "0");
            getCodes(new StringBuffer(), root.getRight(), "1");
        }
        return huffmanCode;
    }

    public static void getCodes(StringBuffer stringBuffer, Node node, String str) {
        StringBuffer stringBuffer2 = new StringBuffer(stringBuffer);
        stringBuffer2.append(str);

        if (node != null) {
            if (node.data != null) {
                huffmanCode.put(node.data, stringBuffer2.toString());
            } else {
                getCodes(stringBuffer2, node.getLeft(), "0");
                getCodes(stringBuffer2, node.getRight(), "1");
            }
        }


    }

    /**
     * 根据每个字符主线的次数 组建一个赫夫曼树
     *
     * @param nodeList
     * @return
     */
    public static Node getHuffManCode(List<Node> nodeList) {
        while (nodeList.size() > 1) {
            Collections.sort(nodeList);

            Node left = nodeList.get(0);
            Node right = nodeList.get(1);

            Node parent = new Node(null, left.weight + right.weight);
            parent.setLeft(left);
            parent.setRight(right);

            nodeList.remove(left);
            nodeList.remove(right);
            nodeList.add(parent);

        }

        return nodeList.get(0);
    }

    /**
     * 获取每个字符出现的次数
     *
     * @param b
     * @return
     */
    public static List<Node> getCodeList(byte b[]) {
        Map<Byte, Integer> byteIntegerMap = new HashMap<>();
        for (int i = 0; i < b.length; i++) {
            Integer counts = byteIntegerMap.get(b[i]);
            if (counts != null) {
                byteIntegerMap.put(b[i], counts + 1);
            } else {
                byteIntegerMap.put(b[i], 1);
            }
        }

        List<Node> codeList = new ArrayList<>();


//        for (Map.Entry<Byte, Integer> map : byteIntegerMap.entrySet()) {
//            codeList.add(new Node(map.getKey(), map.getValue()));
//        }

//        Iterator<Map.Entry<Byte, Integer>> iterator = byteIntegerMap.entrySet().iterator();
//
//        while (iterator.hasNext()) {
//            Map.Entry<Byte, Integer> map = iterator.next();
//            codeList.add(new Node(map.getKey(), map.getValue()));
//        }

        for (Byte key : byteIntegerMap.keySet()) {

            codeList.add(new Node(key, byteIntegerMap.get(key)));
        }

        return codeList;
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
