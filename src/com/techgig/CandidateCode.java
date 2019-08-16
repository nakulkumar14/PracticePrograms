package com.techgig;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


/*
2
6
10 20 50 100 500 400
30 20 60 70 90 490
5
10 20 30 40 50
40 50 60 70 80
 */
public class CandidateCode {
    public static void main(String args[]) throws Exception {

        //Write code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- != 0) {
            int n = Integer.parseInt(br.readLine());
            int vp[] = new int[n];
            int pp[] = new int[n];

            String vpower[] = br.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                vp[i] = Integer.parseInt(vpower[i]);
            }

            String ppower[] = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                pp[i] = Integer.parseInt(ppower[i]);
            }

            Arrays.sort(vp);
            Arrays.sort(pp);

            boolean flag = true;
            for (int i = n - 1; i >= 0; i--) {
                if (vp[i] >= pp[i]) {
                    flag = false;
                    break;
                }
            }

            if (flag)
                System.out.println("WIN");
            else
                System.out.println("LOSE");

        }


    }
}