package com.fzx.study.datastructure.linkedlist;

public class Test {
    public static void main(String[] args) {
        MyHeroNode oldHero=new MyHeroNode(1,"张君宝","张三丰");
        MyHeroNode newHero=new MyHeroNode(2,"李逵","黑旋风");

        MyHeroNode temp=oldHero;
        oldHero.name="被改了";
        oldHero=newHero;
        oldHero.name="李逵";

        System.out.println(temp);
        System.out.println(oldHero);
        System.out.println(newHero);

    }
}
