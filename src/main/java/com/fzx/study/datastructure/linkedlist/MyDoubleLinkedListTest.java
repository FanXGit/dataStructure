package com.fzx.study.datastructure.linkedlist;

public class MyDoubleLinkedListTest {
    public static void main(String[] args) {
        //进行测试
        // 先创建节点
        MyDoubleHeroNode hero1 = new MyDoubleHeroNode(1, "宋江", "及时雨");
        MyDoubleHeroNode hero2 = new MyDoubleHeroNode(2, "卢俊义", "玉麒麟");
        MyDoubleHeroNode hero3 = new MyDoubleHeroNode(3, "吴用", "智多星");
        MyDoubleHeroNode hero4 = new MyDoubleHeroNode(4, "林冲", "豹子头");
        MyDoubleLinkedList linkedList = new MyDoubleLinkedList();
        linkedList.add(hero1);
        linkedList.add(hero2);
        linkedList.add(hero3);
        linkedList.add(hero4);
        linkedList.list();

        linkedList.del(hero1);
        System.out.println("-------------------------------------------------");
        linkedList.list();
    }
}
