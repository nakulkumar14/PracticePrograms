package com.array;

// https://www.geeksforgeeks.org/find-element-bitonic-array/
public class BitonicArray {

    // find max/bitonic element
    static int findBitonicElement(int[] arr, int l, int r) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    static int searchElement(int a[], int index, int key) {
        if (key > a[index]) {
            return -1;
        } else if (key == a[index]) {
            return index;
        } else {
            int e = ascSearchElement(a, 0, index - 1, key);
            if (e != -1) {
                return e;
            }
            return descSearchElement(a, index + 1, a.length - 1, key);
        }
    }

    static int descSearchElement(int[] a, int l, int r, int key) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (a[mid] == key) {
                return mid;
            }
            if (a[mid] > key) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    static int ascSearchElement(int[] a, int l, int r, int key) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (a[mid] == key) {
                return mid;
            }
            if (a[mid] > key) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {-8, 1, 2, 3, 4, 5, -2, -3};
        int key = 1;
        int element = findBitonicElement(arr, 0, arr.length - 1);
        System.out.println(element);
        System.out.println(searchElement(arr, element, key));

        int a[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        key = 30;
        element = findBitonicElement(a, 0, a.length - 1);
        System.out.println(element);
        System.out.println(searchElement(a, element, key));
    }
}
