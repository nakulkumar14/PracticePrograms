package com.tree;

import java.util.*;

public class DepthList {

    static List<List<Integer>> getDepthList(TNode root){
        if (root == null)
            return null;

        List<List<Integer>> result = new ArrayList<>();

        Queue<TNode> queue = new ArrayDeque<>();
        queue.add(root);
        queue.add(new TNode(-1));

        List<Integer> list = new ArrayList<>();

        while(!queue.isEmpty()){
            TNode node = queue.remove();
            if (node.data!=-1){
                list.add(node.data);
                if (node.left!=null)
                    queue.add(node.left);
                if (node.right!=null)
                    queue.add(node.right);
            }else {
                result.add(list);
                list = new ArrayList<>();
                if (!queue.isEmpty())
                    queue.add(new TNode(-1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TNode root = TNode.insertToBST(null, 5);
        root = TNode.insertToBST(root, 2);
        root = TNode.insertToBST(root, 1);
        root = TNode.insertToBST(root, 3);
        root = TNode.insertToBST(root, 7);
        root = TNode.insertToBST(root, 6);
        root = TNode.insertToBST(root, 8);

        TNode.inorder(root);
        System.out.println();

        List<List<Integer>> depthList = getDepthList(root);
        List<List<Integer>> tempList = depthList;

        int i =0;
        while (i<tempList.size()){
            List<Integer> list = tempList.get(i);
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()){
                System.out.print(iterator.next());
            }

            System.out.println();


            i++;
        }

    }
}
