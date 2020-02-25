package com.fzx.study.datastructure.recursion;

/**
 * 迷宫问题
 */
public class migong {


    public static void main(String[] args) {

        int map[][] = new int[8][7];

        //先把上下设置成墙
        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //把左右设置成墙
        for (int i = 0; i < map.length; i++) {
            map[i][0] = 1;
            map[i][map[0].length - 1] = 1;
        }

        map[4][1] = 1;
        map[4][2] = 1;
        map[4][3] = 1;
        map[2][5] = 1;
        map[2][4] = 1;

        System.out.println("游戏前 迷宫布置");
        print(map);

        play(map, 1, 5);
        System.out.println("运行走路算法后：");
        print(map);
    }

    public static boolean play(int map[][], int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (play(map, i + 1, j)) {
                    return true;
                } else if (play(map, i, j + 1)) {
                    return true;
                } else if (play(map, i - 1, j)) {
                    return true;
                } else if (play(map, i , j-1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }


    }

    public static void print(int map[][]) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
