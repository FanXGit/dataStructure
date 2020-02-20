package com.fzx.study.datastructure.hashTab;

/**
 * <p>Title: EmpLinkedList</p>
 * <p>Description: </p>
 * <p>Company: moxin</p>
 *
 * @author Fzx
 * @version 1.0
 * @date 2020/2/20 0020 涓??? 1:46
 */
public class EmpLinkedList {
    private Emp head = null;


    public void add(Emp emp) {
        Emp temp = head;

        if (temp == null) {
            head = emp;
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = emp;
        }
    }
    //遍历链表的雇员信息
    public void list(int no) {
        if(head == null) { //说明链表为空
            System.out.println("第 "+(no+1)+" 链表为空");
            return;
        }
        System.out.print("第 "+(no+1)+" 链表的信息为");
        Emp curEmp = head; //辅助指针
        while(true) {
            System.out.printf(" => id=%d name=%s\t", curEmp.id, curEmp.name);
            if(curEmp.next == null) {//说明curEmp已经是最后结点
                break;
            }
            curEmp = curEmp.next; //后移，遍历
        }
        System.out.println();
    }


    public Emp findById(int no) {
        if (head == null) {
            System.out.println("?捐〃涓虹┖");
            return null;
        }

        Emp temp = head;

        while (true) {

            if (temp == null) {
                temp = null;
                break;
            } else if (head.id == no) {
                break;
            }

            temp = temp.next;


        }

        return temp;
    }
}
