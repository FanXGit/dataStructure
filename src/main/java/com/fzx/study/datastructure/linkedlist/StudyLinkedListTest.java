package com.fzx.study.datastructure.linkedlist;

public class StudyLinkedListTest {
    public static void main(String[] args) {
        //进行测试
        // 先创建节点
        SyudyHeroNode hero1 = new SyudyHeroNode(1, "宋江", "及时雨");
        SyudyHeroNode hero2 = new SyudyHeroNode(2, "卢俊义", "玉麒麟");
        SyudyHeroNode hero3 = new SyudyHeroNode(3, "吴用", "智多星");
        SyudyHeroNode hero4 = new SyudyHeroNode(4, "林冲", "豹子头");

        //创建要给链表
        StudySingleLinkedList studySingleLinkedList = new StudySingleLinkedList();
        //加入
        studySingleLinkedList.add(hero1);
        studySingleLinkedList.add(hero4);
        studySingleLinkedList.add(hero2);
        studySingleLinkedList.add(hero3);

        //显示一把
        studySingleLinkedList.list();
    }
}
