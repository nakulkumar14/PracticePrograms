package com.practice;

import java.math.BigDecimal;

public class ClosestPalindrome {

    static String closestPalindrome(String s) {
        if (s == null || s.trim().length() == 0)
            return s;

        if (s.length() == 1 || "10".equals(s))
            return (Integer.parseInt(s) - 1) + "";

        if (all9(s))
            return (Integer.parseInt(s) + 2) + "";

        String fh = s.substring(0, s.length() / 2);
        String sh = reverse(fh);

        if (s.length() % 2 == 0) {
            BigDecimal org = new BigDecimal(s);
            String one = fh + sh;
            BigDecimal oneB = new BigDecimal(one);

            BigDecimal m;
            if (oneB.compareTo(org) > 0) {
                m = new BigDecimal(fh).subtract(BigDecimal.ONE);
                String two = m.toString() + reverse(m.toString());
                BigDecimal twoB = new BigDecimal(two);
                return oneB.subtract(org).compareTo(org.subtract(twoB)) > 0 ? twoB.toString() : oneB.toString();
            } else {
                m = new BigDecimal(fh).add(BigDecimal.ONE);
                String two = m.toString() + reverse(m.toString());
                BigDecimal twoB = new BigDecimal(two);
                return twoB.subtract(org).compareTo(org.subtract(org)) > 0 ? oneB.toString() : twoB.toString();
            }


        } else {
            String c = s.charAt(s.length() / 2) + "";
            String one = fh + c + sh;
            BigDecimal org = new BigDecimal(s);
            BigDecimal oneB = new BigDecimal(one);

            String two;
            if (oneB.compareTo(org) > 0) {
                if (Integer.parseInt(c) != 0) {
                    two = fh + (Integer.parseInt(c) - 1) + sh;
                } else {
                    fh = (Integer.parseInt(fh) - 1) + "";
                    two = fh + "9" + reverse(fh);
                }
                BigDecimal twoB = new BigDecimal(two);
                return oneB.subtract(org).compareTo(org.subtract(twoB)) > 0 ? twoB.toString() : oneB.toString();
            } else {
                if (Integer.parseInt(c) != 9) {
                    two = fh + (Integer.parseInt(c) + 1) + sh;
                } else {
                    fh = (Integer.parseInt(fh) + 1) + "";
                    two = fh + "0" + reverse(fh);
                }
                BigDecimal twoB = new BigDecimal(two);
                return twoB.subtract(org).compareTo(org.subtract(oneB)) > 0 ? oneB.toString() : twoB.toString();
            }
        }
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
        System.out.println(closestPalindrome("123"));
        System.out.println(closestPalindrome("127"));
        System.out.println(closestPalindrome("125"));
        System.out.println(closestPalindrome("807045053224792883"));
        System.out.println(closestPalindrome("123456"));
        System.out.println(closestPalindrome("999"));
        System.out.println(closestPalindrome("91"));
        System.out.println(closestPalindrome("912"));
        System.out.println(closestPalindrome("10"));
        System.out.println(closestPalindrome("7"));
    }
}
