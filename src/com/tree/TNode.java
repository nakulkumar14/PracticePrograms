package com.tree;

/**
 * Created by nakul on 26-Nov-16.
 */
public class TNode {
    int data;
    TNode left,right;

    public TNode() {
    }

    public TNode(int data) {
        this.data = data;
    }

    public static TNode createNode(int data){
        return new TNode(data);
    }
}
