package com.carousell;


import java.io.BufferedReader;
import java.io.InputStreamReader;

// max earnings - kadane's algorithm
public class Earnings {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if (s == null || s.length() == 0 || s.trim().length() == 0) {
            System.out.println("0");
        } else if (s.indexOf(",") == -1) {
            System.out.println("0");
        } else {
            //1. all 0 or -ve
            String[] split = s.trim().split(",");
            boolean flag = false;
            int count = 0;
            for (int i = 0; i < split.length; i++) {
                try {
                    count += Integer.parseInt(split[i].trim());
                } catch (Exception e) {
                    count = 0;
                    break;
                }
            }
            if (count <= 0) {
                System.out.println("0");
            }

            //2. check for valid scenario.
            int maxsofar = 0, maxendinghere = 0;
            for (int i = 0; i < split.length; i++) {
                maxendinghere += Integer.parseInt(split[i].trim());
                if (maxendinghere <= 0) {
                    maxendinghere = 0;
                }
                if (maxsofar < maxendinghere) {
                    maxsofar = maxendinghere;
                }
            }
            System.out.println(maxsofar);
        }

    }
}
