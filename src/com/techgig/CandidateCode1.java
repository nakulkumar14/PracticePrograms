package com.techgig;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// Neighbour hating each other
public class CandidateCode1 {
    public static void main(String args[]) throws Exception {

        //Write code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- != 0) {
            int n = Integer.parseInt(br.readLine());
            int a[] = new int[n];
            String[] tickets = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(tickets[i]);
            }

            int msum = 0, tmp = 0;
            List<Integer> list3 = new ArrayList<>();
            for (int i = 0; i < n; i++) {

                List<Integer> list1 = new ArrayList<>();
                List<Integer> list2 = new ArrayList<>();


                int ftwo = 0, sectwo = 0;
                if (i + 2 < n) {
                    if (a[i] < 0 && a[i + 2] > 0) {
                        ftwo = a[i + 2];
                        list1.add(a[i + 2]);
                    } else if (a[i + 2] < 0 && a[i] > 0) {
                        ftwo = a[i];
                        list1.add(a[i]);
                    } else {
                        ftwo = (a[i] + a[i + 2]);
                        list1.add(a[i]);
                        list1.add(a[i + 2]);
                    }
                } else if (i + 1 < n && i + 3 < n) {

                    if (a[i + 1] < 0 && a[i + 3] > 0) {
                        sectwo = a[i + 3];
                        list2.add(a[i + 3]);
                    } else if (a[i + 3] < 0 && a[i + 1] > 0) {
                        sectwo = a[i + 1];
                        list2.add(a[i + 1]);
                    } else {
                        sectwo = (a[i + 1] + a[i + 3]);
                        list2.add(a[i + 1]);
                        list2.add(a[i + 3]);
                    }
                }

                if (ftwo > sectwo) {
                    list3.addAll(list1);
                } else if (ftwo < sectwo) {
                    list3.addAll(list2);
                } else {
                    for (int j = 0; j < list1.size() && j < list2.size(); j++) {
                        if (list1.get(j) > list2.get(j)) {
                            list3.addAll(list1);
                            break;
                        } else {
                            list3.addAll(list2);
                            break;
                        }
                    }
                }


            }

            list3.forEach(e -> System.out.print(e));
        }

    }
}
