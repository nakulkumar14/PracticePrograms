package com.practice;

/**
 * Created by nakulkumar on 17/7/16.
 * A sorted array has been rotated r times to the left. Find r in least possible time.
 */
public class RotationCount {

    static int rotationCount(int a[], int l, int h) {
        if (a[l] <= a[h])
            return 0;
        int m = (l + h) / 2;
        if (l > 0 && m - 1 >= l && a[m - 1] > a[m])
            return m;
        if (a[m] < a[h])
            return rotationCount(a, l, m);
        else
            return rotationCount(a, m, h);
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5};
        Util.showArray(a);
        System.out.println(rotationCount(a, 0, a.length - 1));

        a = new int[]{3, 4, 5, 1, 2};
        Util.showArray(a);
        System.out.println(rotationCount(a, 0, a.length - 1));
    }
}
