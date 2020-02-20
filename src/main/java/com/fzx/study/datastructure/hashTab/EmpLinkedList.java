package com.fzx.study.datastructure.hashTab;

/**
 * <p>Title: EmpLinkedList</p>
 * <p>Description: </p>
 * <p>Company: moxin</p>
 *
 * @author Fzx
 * @version 1.0
 * @date 2020/2/20 0020 �??? 1:46
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
    //��������Ĺ�Ա��Ϣ
    public void list(int no) {
        if(head == null) { //˵������Ϊ��
            System.out.println("�� "+(no+1)+" ����Ϊ��");
            return;
        }
        System.out.print("�� "+(no+1)+" �������ϢΪ");
        Emp curEmp = head; //����ָ��
        while(true) {
            System.out.printf(" => id=%d name=%s\t", curEmp.id, curEmp.name);
            if(curEmp.next == null) {//˵��curEmp�Ѿ��������
                break;
            }
            curEmp = curEmp.next; //���ƣ�����
        }
        System.out.println();
    }


    public Emp findById(int no) {
        if (head == null) {
            System.out.println("?�表为空");
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
