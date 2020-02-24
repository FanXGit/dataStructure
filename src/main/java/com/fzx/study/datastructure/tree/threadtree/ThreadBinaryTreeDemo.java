package com.fzx.study.datastructure.tree.threadtree;

/**
 * <p>Title: ThreadBinaryTree</p>
 * <p>Description: </p>
 * <p>Company: moxin</p>
 *
 * @author Fzx
 * @version 1.0
 * @date 2020/2/22 0022 ���� 2:45
 */
public class ThreadBinaryTreeDemo {

    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        ThreadBinaryTree threadBinaryTree = new ThreadBinaryTree();
        threadBinaryTree.setRoot(root);
        threadBinaryTree.infixOrder();
        threadBinaryTree.threadedNodes();

        //����: ��10�Žڵ����
        HeroNode leftNode = node5.getLeft();
        HeroNode rightNode = node5.getRight();
        System.out.println("10�Ž���ǰ������� =" + leftNode); //3
        System.out.println("10�Ž��ĺ�̽����=" + rightNode); //1


    }
}

class ThreadBinaryTree {
    private HeroNode root;
    private HeroNode pre;

    public void setRoot(HeroNode heroNode) {
        this.root = heroNode;
    }

    public void threadedNodes() {
        threadedNodes(root);
    }

    //��д�Զ��������������������ķ���

    /**
     * @param node ���ǵ�ǰ��Ҫ�������Ľ��
     */
    public void threadedNodes(HeroNode node) {

        //���node==null, ����������
        if (node == null) {
            return;
        }

        //(һ)��������������
        threadedNodes(node.getLeft());
        //(��)��������ǰ���[���Ѷ�]

        //����ǰ����ǰ�����
        //��8��������
        //8����.left = null , 8����.leftType = 1
        if (node.getLeft() == null) {
            //�õ�ǰ������ָ��ָ��ǰ�����
            node.setLeft(pre);
            //�޸ĵ�ǰ������ָ�������,ָ��ǰ�����
            node.setLeftType(1);
        }

        //�����̽��
        if (pre != null && pre.getRight() == null) {
            //��ǰ��������ָ��ָ��ǰ���
            pre.setRight(node);
            //�޸�ǰ��������ָ������
            pre.setRightType(1);
        }
        //!!! ÿ����һ�������õ�ǰ�������һ������ǰ�����
        pre = node;

        //(��)��������������
        threadedNodes(node.getRight());

    }

    public void preOrder() {
        if (root != null) {
            this.root.preOrder();
        } else {
            System.out.println("������Ϊ�գ��޷�����");
        }

    }

    public void infixOrder() {
        if (root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("������Ϊ�գ��޷�����");
        }
    }

}

class HeroNode {
    private int no;
    private String name;

    private HeroNode left;
    private HeroNode right;

    private int leftType;
    private int rightType;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    /**
     * ǰ�����
     */

    public void preOrder() {
        System.out.println("��ǰ�ڵ�Ϊ:" + this);

        if (this.left != null) {
            this.left.preOrder();
        }

        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * �������
     */

    public void infixOrder() {

        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println("��ǰ�ڵ�Ϊ:" + this.getNo());

        if (this.right != null) {
            this.right.infixOrder();
        }
    }
}
