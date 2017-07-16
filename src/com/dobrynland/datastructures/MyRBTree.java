package com.dobrynland.datastructures;

/**
 * Created by adobryn on 06.02.2017.
 */
public class MyRBTree {
    MyRBNode root;

    public void addNode(int a){
        if(root == null){
            root = new MyRBNode(a);
            root.color = Color.BLACK;
            return;
        }

        searchForAdding(a, root);
    }

    public void searchForAdding(int a, MyRBNode node){
        if(node == null)
            return;

        if(a < node.data){
            if(node.left == null){
                node.left = new MyRBNode(a);
                node.left.parent = node;
                if(node.color == Color.RED)
                    balanceTree(node);
                return;
            }
            else{
                searchForAdding(a, node.left);
            }
        }
        if(a > node.data){
            if(node.right == null){
                node.right = new MyRBNode(a);
                node.right.parent = node;
                if(node.color == Color.RED)
                    balanceTree(node);
                return;
            }
            else{
                searchForAdding(a, node.right);
            }
        }
    }

    public void printTree(MyRBNode node){
        if(node == null)
            return;
        printTree(node.left);
        System.out.print(node.data + ",  ");
        printTree(node.right);
    }

    public void balanceTree(MyRBNode node){

    }

    public void rotateRight(MyRBNode node){
       MyRBNode newParent = node.left;
       newParent.parent = node.parent;
       if(node.parent != null){
           if(node.parent.left == node){
               node.parent.left = newParent;
           }
           else{
               node.parent.right = newParent;
           }
       }
       node.left = newParent.right;
       if(node.right != null){
           newParent.right.parent = node;
       }
       node.parent = newParent;
       newParent.right = node;
    }

    public void rotateLeft(MyRBNode node){
        MyRBNode newParent = node.right;
        newParent.parent = node.parent;
        if(node.parent != null){
            if(node.parent.left == node){
                node.parent.left = newParent;
            }
            else{
                node.parent.right = newParent;
            }
        }
        node.right = newParent.left;
        if(node.left != null){
            newParent.left.parent = node;
        }
        node.parent = newParent;
        newParent.left = node;
    }

    public static void main(String[] args){
        MyRBTree tree = new MyRBTree();

        tree.addNode(5);
        tree.addNode(2);
        tree.addNode(9);
        tree.addNode(15);
        tree.addNode(3);

        tree.printTree(tree.root);
    }
}
