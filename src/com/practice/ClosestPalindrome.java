package com.practice;

public class ClosestPalindrome {

    static String closestPalindrome(String s) {

        System.out.print(s + ": ");

        if (s == null || s.trim().length() == 0)
            return s;

        int num = Integer.parseInt(s);
        if (s.length() == 1 || num == 10)
            return (num - 1) + "";

        if (all9(s))
            return (num + 2) + "";


        int temp = num - 2;
        if (all9(temp + ""))
            return temp + "";


        String fh = s.substring(0, s.length() / 2);
        String sh = reverse(fh);

        if (s.length() % 2 == 0) {

            String one = fh + sh;
            int base = Integer.parseInt(one);

            if (base == num) {
                int i = Integer.parseInt(fh) + 1;
                String h1 = i + "";
                String hS = h1 + reverse(h1);
                int hi = Integer.parseInt(hS);

                i = Integer.parseInt(fh) - 1;
                String l1 = i + "";
                String lS = l1 + reverse(l1);
                int li = Integer.parseInt(lS);

                return Math.abs(hi - num) > Math.abs(num - li) ? lS : hS;
            } else {
                int li = Integer.parseInt(fh) - 1;
                String lowS = li + reverse(li + "");
                int low = Integer.parseInt(lowS);

                int hi = Integer.parseInt(fh) + 1;
                String highS = hi + reverse(hi + "");
                int high = Integer.parseInt(highS);

                int d1 = Math.abs(base - num);
                int d2 = Math.abs(low - num);
                int d3 = Math.abs(high - num);

                return min(d1, d2, d3, base, low, high) + "";
            }


        } else {
            String c = s.charAt(s.length() / 2) + "";
            String base = fh + c + sh;
            int basei = Integer.parseInt(base);

            String low;
            if ("0".equals(c)) {
                int li = Integer.parseInt(fh) - 1;
                low = li + "9" + reverse(li + "");
            } else {
                low = fh + (Integer.parseInt(c) - 1) + reverse(fh + "");
            }
            int lowi = Integer.parseInt(low);

            String high;
            if ("9".equals(c)) {
                int hi = Integer.parseInt(fh) + 1;
                high = hi + "0" + reverse(hi + "");
            } else {
                high = fh + (Integer.parseInt(c) + 1) + reverse(fh + "");
            }
            int highi = Integer.parseInt(high);

            int d1 = Math.abs(basei - num);
            int d2 = Math.abs(lowi - num);
            int d3 = Math.abs(highi - num);

            return min(d1, d2, d3, basei, lowi, highi) + "";
        }
    }

    static int min(int d1, int d2, int d3, int base, int low, int high) {
        int min;
        if (d1 == 0)
            min = d2 < d3 ? low : high;
        else if (d2 == 0)
            min = d1 < d3 ? base : high;
        else if (d3 == 0)
            min = d1 < d2 ? base : low;
        else
            min = d1 < d2 ? (d1 < d3 ? base : high) : (d2 < d3 ? low : high);
        return min;
    }

    static String reverse(String s) {
        String r = "";
        for (int i = 0; i < s.length(); i++) {
            r = s.charAt(i) + r;
        }
        return r;
    }

    private static boolean all9(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '9')
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(closestPalindrome("1001"));
        System.out.println(closestPalindrome("101"));
        System.out.println(closestPalindrome("99"));
        System.out.println(closestPalindrome("88"));
        System.out.println(closestPalindrome("4444"));
        System.out.println(closestPalindrome("4994"));
        System.out.println(closestPalindrome("4004"));
        System.out.println(closestPalindrome("404"));
        System.out.println(closestPalindrome("11"));
        System.out.println(closestPalindrome("1111"));
        System.out.println(closestPalindrome("494"));
        System.out.println(closestPalindrome("123"));
        System.out.println(closestPalindrome("127"));
        System.out.println(closestPalindrome("125"));
        System.out.println(closestPalindrome("123456"));
        System.out.println(closestPalindrome("999"));
        System.out.println(closestPalindrome("91"));
        System.out.println(closestPalindrome("912"));
        System.out.println(closestPalindrome("10"));
        System.out.println(closestPalindrome("7"));
    }
}
