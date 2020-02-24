package com.fzx.study.datastructure.hashtab;

/**
 * <p>Title: HashTab</p>
 * <p>Description: </p>
 * <p>Company: moxin</p>
 *
 * @author Fzx
 * @version 1.0
 * @date 2020/2/20 0020 �??? 2:34
 */
public class HashTab {

    private EmpLinkedList empLinkedLists[];
    private int size;

    public HashTab(int size) {
        this.size = size;
        empLinkedLists = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp) {
        int empLinkedListNO = hashFun(emp.id);
        empLinkedLists[empLinkedListNO].add(emp);
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedLists[i].list(i);
        }

    }


    public void findById(int id) {
        int empLinkedListNO = hashFun(id);
        Emp emp = empLinkedLists[empLinkedListNO].findById(id);
        if(emp != null) {//�ҵ�
            System.out.printf("�ڵ�%d���������ҵ� ��Ա id = %d\n", (empLinkedListNO + 1), id);
        }else{
            System.out.println("�ڹ�ϣ���У�û���ҵ��ù�Ա~");
        }

    }

    //�????��???��??, 使�?��?�?�?????模�?
    public int hashFun(int id) {
        return id % size;
    }
}

