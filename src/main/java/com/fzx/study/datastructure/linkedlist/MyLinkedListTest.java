package com.fzx.study.datastructure.linkedlist;

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


        MySingleLinkedList linkedList1order=new MySingleLinkedList();
        linkedList1order.addByOrder(hero1);
        linkedList1order.addByOrder(hero4);
        linkedList1order.addByOrder(hero3);
        linkedList1order.addByOrder(hero2);
        linkedList1order.update(updateHero);

        linkedList1order.remove(hero1);
        linkedList1order.list();





    }
}
