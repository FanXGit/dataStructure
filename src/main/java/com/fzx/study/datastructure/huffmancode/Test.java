package com.fzx.study.datastructure.huffmancode;

public class Test {
    public static void main(String[] args) {

        String str = "10101001";
        System.out.println(Integer.parseInt(str, 2));
        System.out.println((byte) Integer.parseInt(str, 2));


        haNoTower(5, 'A', 'B', 'C');

        System.out.println( Runtime.getRuntime().maxMemory()/1024/1024);
    }


    public static void haNoTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第" + num + "个盘从" + a + "  到  " + c);
        } else {
            haNoTower(num - 1, a, c, b);
            System.out.println("第" + num + "个盘 从 " + a + " 到 " + c);
            haNoTower(num - 1, b, a, c);
        }


    }
}

interface Boncinterfacefnt {
    int count = 20;
}

class B implements Boncinterfacefnt {
    private static int counter;

    public static void main(String[] args) {
        System.out.println(++counter);
    }
}

class Bonc {
    protected int getA(int a, int b) {
        return 0;
    }
}

class C extends Bonc {
    protected int getA(int a, int b) {
        return 0;
    }
}

class BONCstatic {
    private static int y = 350;

    public static void main(String args[]) {
        BONCstatic bonCstatic1 = new BONCstatic();
        bonCstatic1.y++;

        BONCstatic bonCstatic2 = new BONCstatic();
        bonCstatic2.y++;

        bonCstatic1 = new BONCstatic();
        bonCstatic1.y++;
        BONCstatic.y--;

        System.out.println("y="+y);

        int a [] =new int[15];
        //float b =new int[1];
        //char [] c ="asdasdasd";
       // int d[][] ={1,2,3,4}{3,45,6,7}
        int d[][] ={{12,5,3,4},{4,2,3,4,56,1}};

        try {
            return;
        }finally {
            System.out.println("--------------------");
        }
    }

}

class  D extends Object{
    static {
        System.out.println("Load D");
    }

    public D(){
        System.out.println("Create D");
    }
}

class F extends D{
    static {
        System.out.println("Load f");
    }

    public F(){
        System.out.println("Create F");
    }
}

class  Test1{
    public static void main(String[] args) {
        new F();
    }
        }