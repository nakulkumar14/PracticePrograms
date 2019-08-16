package com.carousell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// find kth entry among two logging stores.
public class LogAnalysis {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(180);
        list.add(40);
        list.add(120);
        list.add(10);
        ArrayList<Integer> list1 = IDsOfPackages(250, list);
        System.out.println(list1);

        String input1 = br.readLine();
        String input2 = br.readLine();
        String[] klist = br.readLine().split(",");
        int k[] = new int[klist.length];
        for (int i = 0; i < klist.length; i++) {
            k[i] = Integer.parseInt(klist[i]);
        }

        String[] split1 = input1.split(",");
        String[] split2 = input2.split(",");

        int[] arr1 = fetchIntArr(split1);
        int[] arr2 = fetchIntArr(split2);

        for (int l = 0; l < k.length; l++) {
            printKth(arr1, arr2, k[l], split1, split2);
            if (l != k.length - 1) {
                System.out.print(",");
            }
        }


    }

    private static void printKth(int[] arr1, int[] arr2, int l, String[] split1, String[] split2) {
        int i = 0, j = 0;
        int m = 0;
        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] <= arr2[j]) {

                if (m == l) {
                    System.out.print(split1[i]);
                    return;
                }

                i++;
            } else {

                if (m == l) {
                    System.out.print(split2[j]);
                    return;
                }

                j++;
            }
            m++;
        }

        if (i >= arr1.length) {
            while (j < arr2.length) {
                if (m == l) {
                    System.out.print(split2[j]);
                    return;
                }
                j++;
                m++;
            }
        }

        if (j >= arr2.length) {
            while (i < arr1.length) {
                if (m == l) {
                    System.out.print(split1[i]);
                    return;
                }
                i++;
                m++;
            }
        }
    }

    private static int[] fetchIntArr(String[] splitArr) {
        int arr1[] = new int[splitArr.length];
        for (int i = 0; i < splitArr.length; i++) {
            arr1[i] = Integer.parseInt(splitArr[i].split(":")[0]);
        }
        return arr1;
    }

    static ArrayList<Integer> IDsOfPackages(int truckSpace,
                                            ArrayList<Integer> packagesSpace) {
        // WRITE YOUR CODE HERE
        if (truckSpace == 0 || packagesSpace == null || packagesSpace.size() == 0)
            return null;

        int n = packagesSpace.size();
        ArrayList<Integer> result = new ArrayList<>();
        int a[] = new int[2];
        a[0] = -1;
        a[1] = -1;
        for (int i = 0; i < n; i++) {
            int sum = packagesSpace.get(i);
            for (int j = i + 1; j < n; j++) {
                if (truckSpace - (sum + packagesSpace.get(j)) == 30) {

                    if (a[0] == -1) {
                        a[0] = i;
                        a[1] = j;
                    } else if (sum + packagesSpace.get(j) >= packagesSpace.get(a[0]) + packagesSpace.get(a[1])) {
                        a[0] = i;
                        a[1] = j;
                    }
                }
            }
        }
        result.add(a[0]);
        result.add(a[1]);

        return result;

    }
}
