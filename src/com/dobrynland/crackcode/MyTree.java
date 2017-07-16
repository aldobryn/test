package com.dobrynland.crackcode;

/**
 * Created by Alexandra on 04.02.2017.
 */
public class MyTree {

    MyTreeNode head;

    MyTree(){
        head = null;
    }

    public void findPlace(MyTreeNode curr, int data){
        if(curr.data == data){
            curr.count++;
            return;
        }
        if(data < curr.data){
            if(curr.left == null){
                curr.left = new MyTreeNode(data);
                return;
            }
            findPlace(curr.left, data);
        }
        if(data > curr.data){
            if(curr.right == null) {
                curr.right = new MyTreeNode(data);
                return;
            }
            findPlace(curr.right, data);
        }
    }

    public void addNode(int data){
        if(head == null){
            head = new MyTreeNode(data);
            return;
        }

        findPlace(head, data);
    }


    public void buildTree(int[] arr){
        for(int n:arr){
            addNode(n);
        }
    }

    public void printTree(MyTreeNode curr){
        if(curr.left != null){
            printTree(curr.left);
        }
        for(int i = 0; i < curr.count; i++)
            System.out.print(curr.data + ", ");

        if(curr.right != null)
            printTree(curr.right);
    }

    public static void main(String[] args){
        MyTree tree = new MyTree();
        int arr[] = {10, 7, 9, 12, 6, 14, 11, 3, 4, 7};
        tree.buildTree(arr);
        tree.printTree(tree.head);
    }
}
