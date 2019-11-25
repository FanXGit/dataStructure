package com.fzx.study.datastructure.linkedlist;

import com.fzx.study.datastructure.mytest.HeroNode;

public class MyLinkedListTest {
    public static void main(String[] args) {
        //进行测试
        // 先创建节点
        MyHeroNode hero1 = new MyHeroNode(1, "宋江", "及时雨");
        MyHeroNode hero2 = new MyHeroNode(2, "卢俊义", "玉麒麟");
        MyHeroNode hero3 = new MyHeroNode(3, "吴用", "智多星");
        MyHeroNode hero4 = new MyHeroNode(4, "林冲", "豹子头");
        MyHeroNode updateHero = new MyHeroNode(3, "李逵", "黑旋风");
//        MySingleLinkedList linkedList=new MySingleLinkedList();
//        linkedList.add(hero1);
//        linkedList.add(hero2);
//        linkedList.add(hero3);
//        linkedList.add(hero4);
//        linkedList.list();


        MySingleLinkedList linkedList1order = new MySingleLinkedList();
        linkedList1order.addByOrder(hero1);
        linkedList1order.addByOrder(hero4);
        linkedList1order.addByOrder(hero3);
        linkedList1order.addByOrder(hero2);
        linkedList1order.update(updateHero);

        linkedList1order.remove(hero1);
        linkedList1order.list();

        System.out.println(LinkedListInterviewQuestions.getLength(linkedList1order.getHead()));

        System.out.println(LinkedListInterviewQuestions.findLastIndexNode(linkedList1order.getHead(), 3));
        System.out.println("-----------------------------------------");
        LinkedListInterviewQuestions.reversalLinkedList(linkedList1order.getHead());
        linkedList1order.list();

        System.out.println("-----------------------------------------");
        LinkedListInterviewQuestions.endToHeadPrint(linkedList1order.getHead());
        System.out.println("-----------------------------------------");
        MyHeroNode hero11 = new MyHeroNode(11, "宋江", "及时雨");
        MyHeroNode hero12 = new MyHeroNode(12, "卢俊义", "玉麒麟");
        MyHeroNode hero13 = new MyHeroNode(13, "吴用", "智多星");
        MyHeroNode hero14 = new MyHeroNode(14, "林冲", "豹子头");
        MySingleLinkedList mySingleLinkedList = new MySingleLinkedList();
        mySingleLinkedList.add(hero11);
        mySingleLinkedList.add(hero12);
        mySingleLinkedList.add(hero13);
        mySingleLinkedList.add(hero14);

        MyHeroNode mergeNode=  LinkedListInterviewQuestions.mergeHeroNode(mySingleLinkedList.getHead(),linkedList1order.getHead());
        mySingleLinkedList.getHead().next=mergeNode.next;

        mySingleLinkedList.list();

    }
}
