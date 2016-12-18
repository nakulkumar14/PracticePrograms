package com.practice;

/**
 * Created by nakul on 18-Dec-16.
 * Print all elements in sorted order from row and column wise sorted matrix
 Given an n x n matrix, where every row and column is sorted in non-decreasing order. Print all elements of matrix in sorted order.

 Example:

 Input: mat[][]  =  { {10, 20, 30, 40},
 {15, 25, 35, 45},
 {27, 29, 37, 48},
 {32, 33, 39, 50},
 };

 Output:
 Elements of matrix in sorted order
 10 15 20 25 27 29 30 32 33 35 37 39 40 45 48 50
 */
public class SortedOrderMatrix {

    static class MinHeapNode{
        int data;
        int i;
        int j;
    }

    static class MinHeap{
        MinHeapNode node[];
        int size;

        MinHeap(MinHeapNode node[],int size){
            this.size = size;
            this.node = node;
            int i = size/2;
            while (i>=0){
                heapify(i);
                i--;
            }
        }

        void swap(MinHeapNode swapnode[],int x,int y){
            MinHeapNode temp;
            temp = swapnode[x];
            swapnode[x]=swapnode[y];
            swapnode[y]=temp;
        }

        void heapify(int i){
            int l = left(i);
            int r = right(i);

            int smallest = i;
            if (l<size && node[l].data <=node[smallest].data)
                smallest = l;
            if (r<size && node[r].data <=node[smallest].data)
                smallest=r;
            if (smallest!=i){
                swap(node,i,smallest);
                heapify(smallest);
            }
        }

        int left(int i){
            return 2*i+1;
        }

        int right(int i){
            return 2*i+2;
        }

        MinHeapNode getMin(){
            return node[0];
        }

        void replace(MinHeapNode root){
            node[0]=root;
            heapify(0);
        }
    }

    private static void printSorted(int[][] mat) {
        MinHeapNode arr[] = new MinHeapNode[mat.length];
        for (int i = 0; i < mat.length; i++) {
            arr[i] = new MinHeapNode();
            arr[i].data = mat[i][0];
            arr[i].i = i;
            arr[i].j = 1;
        }

        MinHeap heap = new MinHeap(arr,mat.length);

        for (int i = 0; i < mat.length * mat.length; i++) {
            MinHeapNode temp = heap.getMin();
            System.out.print(temp.data+" ");
            if (temp.j<mat.length){
                temp.data = mat[temp.i][temp.j];
                temp.j++;
            }
            else
                temp.data = Integer.MAX_VALUE;

            heap.replace(temp);
        }
    }

    public static void main(String[] args) {
        int mat[][] = { {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50},
        };
        printSorted(mat);
    }
}
