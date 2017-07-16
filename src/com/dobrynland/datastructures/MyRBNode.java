package com.dobrynland.datastructures;

/**
 * Created by adobryn on 06.02.2017.
 */
public class MyRBNode {

    int data;

    MyRBNode left;
    MyRBNode right;
    MyRBNode parent;

    Color color;

    MyRBNode(int a){
        color = Color.BLACK;
        left = null;
        right = null;
        parent = null;
        data = a;
    }
}
