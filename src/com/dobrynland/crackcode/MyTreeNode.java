package com.dobrynland.crackcode;

/**
 * Created by Alexandra on 04.02.2017.
 */
public class MyTreeNode {
    int data;
    MyTreeNode left;
    MyTreeNode right;
    int count;

    public MyTreeNode(int a) {
        left = null;
        right = null;
        this.data = a;
        count = 1;
    }
}