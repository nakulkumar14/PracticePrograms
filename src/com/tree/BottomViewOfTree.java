package com.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// https://www.geeksforgeeks.org/bottom-view-binary-tree/
public class BottomViewOfTree extends TNode {

    static void bottomView(TNode node) {
        Map<Integer, Integer[]> map = new HashMap<>();
        bottomViewUtil(node, 0, 0, map);

        Set<Map.Entry<Integer, Integer[]>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer[]> entry : entries) {
            Integer[] value = entry.getValue();
            System.out.print(value[0] + " ");
        }

    }

    private static void bottomViewUtil(TNode node, int currHeight, int hD, Map<Integer, Integer[]> map) {
        if (node == null)
            return;
        if (map.get(hD) == null) {
            Integer[] arr = new Integer[2];
            arr[0] = node.data;
            arr[1] = currHeight;
            map.put(hD, arr);
        } else {
            Integer[] values = map.get(hD);
            if (values[1] <= currHeight) {
                values[1] = currHeight;
                values[0] = node.data;
            }
        }

        bottomViewUtil(node.left, currHeight + 1, hD - 1, map);
        bottomViewUtil(node.right, currHeight + 1, hD + 1, map);
    }

    public static void main(String[] args) {
        TNode root = new TNode(20);
        root.left = new TNode(8);
        root.right = new TNode(22);
        root.right.left = new TNode(4);
        root.right.right = new TNode(25);
        root.left.left = new TNode(5);
        root.left.right = new TNode(3);
        root.left.right.left = new TNode(10);
        root.left.right.right = new TNode(14);
        bottomView(root);
    }
}
