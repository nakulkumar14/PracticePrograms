package com.practice;

import java.util.Scanner;

/**
 * Created by nakul on 04-Feb-17.
 */
public class DecimalToRoman {
    private static String toRoman(int num) {
        String[] romanCharacters = {"M", "CM", "D", "C", "XC", "L", "X", "IX", "V", "I"};
        int[] romanValues = {1000, 900, 500, 100, 90, 50, 10, 9, 5, 1};
        String result = "";

        for (int i = 0; i < romanValues.length; i++) {
            int numberInPlace = num / romanValues[i];
            if (numberInPlace == 0) continue;
            result += numberInPlace == 4 && i > 0 ? romanCharacters[i] + romanCharacters[i - 1] :
                    new String(new char[numberInPlace]).replace("\0", romanCharacters[i]);
            num = num % romanValues[i];
        }
        return result;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int decimal = scanner.nextInt();
        System.out.println(toRoman(decimal));
    }
}
