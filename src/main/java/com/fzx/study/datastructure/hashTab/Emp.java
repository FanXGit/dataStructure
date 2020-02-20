package com.fzx.study.datastructure.hashTab;

/**
 * <p>Title: Emp</p>
 * <p>Description: </p>
 * <p>Company: moxin</p>
 *
 * @author Fzx
 * @version 1.0
 * @date 2020/2/20 0020 下午 1:44
 */
public class Emp {
    int id;
    int age;
    String name;
    public Emp next;


    public Emp(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
