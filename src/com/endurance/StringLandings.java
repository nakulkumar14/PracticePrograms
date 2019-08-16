package com.endurance;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StringLandings {
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x = br.readLine();
        String y = br.readLine();
        char[] xArr = x.toCharArray();
        Arrays.sort(xArr);

        char[] yArr = y.toCharArray();
        Arrays.sort(yArr);

        boolean flag = true;
        boolean temp = false;
        for (int i = 0; i < xArr.length; i++) {
            if (xArr[i] >= yArr[i] && flag) {
                flag = true;
                temp = true;
            } else {
                flag = false;
            }
        }

        if (flag)
            System.out.println(flag);
        else if (!flag && !temp)
            System.out.println(!flag);
        else if (!flag && temp)
            System.out.println(flag);
    }
}
