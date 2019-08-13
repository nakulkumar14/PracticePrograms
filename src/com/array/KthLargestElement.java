package com.array;

public class KthLargestElement {

    public static void main(String[] args) {
        int a[] = {3, 2, 1, 5, 6, 4};
        int k = 2;
        KthLargestElement e = new KthLargestElement();
        e.findKthLargest(a, k);
        System.out.println();

        int b[] = {1, 23, 12, 9, 30, 2, 50};
        k = 3;
        e.findKthLargest(b, k);
        System.out.println();

        int c[] = {12, 5, 787, 1, 23};
        k = 2;
        e.findKthLargest(c, k);
        System.out.println();
    }

    public void findKthLargest(int[] nums, int k) {

        for (int i = k / 2 - 1; i >= 0; i--) {
            heapify(i, k, nums);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > nums[0]) {
                nums[0] = nums[i];
                heapify(0, k, nums);
            }
        }

        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    void heapify(int i, int k, int a[]) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        int smallest = i;
        if (l < k && a[l] < a[smallest]) {
            smallest = l;
        }
        if (r < k && a[r] < a[smallest]) {
            smallest = r;
        }

        if (smallest != i) {
            int temp = a[i];
            a[i] = a[smallest];
            a[smallest] = temp;
            heapify(smallest, k, a);
        }
    }
}