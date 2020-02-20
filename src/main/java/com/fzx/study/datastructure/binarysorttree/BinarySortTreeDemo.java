package com.fzx.study.datastructure.binarysorttree;

/**
 * <p>Title: BinarySortTreeDemo</p>
 * <p>Description: </p>
 * <p>Company: moxin</p>
 *
 * @author Fzx
 * @version 1.0
 * @date 2020/2/20 0020 下午 5:38
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        //先需要创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();

        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node4);
        node3.setRight(node5);

        binaryTree.setRoot(root);
        binaryTree.preOrder();

        // binaryTree.infixOrder();
       // binaryTree.postOrder();

        System.out.println(binaryTree.infixOrderSearch(3).toString());
        System.out.println("------------------------------");
        binaryTree.delNode(5);
        binaryTree.preOrder();
        System.out.println("------------------------------");
        binaryTree.delNode(3);
        binaryTree.preOrder();
    }

}

class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {

        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }

    }

    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public HeroNode preOrderSearch(int no) {
        if (this.root != null) {
            return this.root.preOrderSearch(no);
        } else {
            System.out.println("二叉树为空，无法遍历");
            return null;
        }
    }


    public HeroNode infixOrderSearch(int no) {
        if (this.root != null) {
            return this.root.infixOrderSearch(no);
        } else {
            System.out.println("二叉树为空，无法遍历");
            return null;
        }
    }

    public void  delNode(int no){
        if (this.root!=null){
            if (this.root.getNo() == no){
                this.root = null;
                return;
            }else {
                this.root.delHeroNode(no);
            }
        }else {
            System.out.println("二叉树为空，无法删除");
        }
    }
}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

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

    public void preOrder() {
        System.out.println(this.getNo());

        if (this.left != null) {
            this.left.preOrder();
        }

        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public HeroNode preOrderSearch(int no) {
        if (this.no == no) {
            return this;
        }

        HeroNode heroNode = null;
        if (this.left != null) {
            heroNode = this.left.preOrderSearch(no);
        }
        if (heroNode != null) {
            return heroNode;
        }


        if (this.right != null) {
            heroNode = this.right.preOrderSearch(no);
        }

        return heroNode;
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }

        System.out.println(this.getNo());

        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    public HeroNode infixOrderSearch(int no) {
        HeroNode heroNode = null;

        if (this.left != null) {
            heroNode = this.left.infixOrderSearch(no);
        }


        if (heroNode != null) {
            return heroNode;
        }

        if (this.no == no) {
            return this;
        }


        if (this.right != null) {
            heroNode = this.right.preOrderSearch(no);
        }

        return heroNode;
    }


    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }

        if (this.right != null) {
            this.right.postOrder();
        }

        System.out.println(this.getNo());
    }


    public HeroNode postOrderSearch(int no) {

        HeroNode heroNode = null;
        if (this.left != null) {
            heroNode = this.left.postOrderSearch(no);
        }

        if (heroNode != null) {
            return heroNode;
        }

        if (this.right != null) {
            heroNode = postOrderSearch(no);
        }

        if (this.no == no) {
            return this;
        }
        return heroNode;
    }


    public void delHeroNode(int no) {
       if (this.left != null && this.left.no == no){
           this.left = null;
           return;
       }

        if (this.right != null && this.right.no == no){
            this.right = null;
            return;
        }

        if (this.left != null){
            this.left.delHeroNode(no);
        }

        if (this.right != null){
            this.right.delHeroNode(no);
        }

    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}