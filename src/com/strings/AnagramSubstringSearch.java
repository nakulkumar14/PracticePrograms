package com.strings;

//https://www.geeksforgeeks.org/anagram-substring-search-search-permutations/
public class AnagramSubstringSearch {

    static void printPositions(char c1[], char c2[]){
        int countT[] = new int[256];

        // count of characters of pattern.
        for (int i = 0; i < c2.length; i++) {
            countT[c2[i]]++;
        }

        int countW[] = new int[256];

        // count of characters in window of pattern size.
        for (int i = 0; i < c2.length; i++) {
            countW[c1[i]]++;
        }

        for (int i = c2.length; i < c1.length ; i++) {
            // compare the count of current window to pattern window.
            if (compare(countT, countW)){

                // print starting index of window.
                System.out.println(i-c2.length);
            }

            // remove first character of window.
            countW[c1[i-c2.length]]--;
            // add new character to window.
            countW[c1[i]]++;
        }
        // compare the last window.
        if (compare(countT, countW)){
            System.out.println(c1.length-c2.length);
        }
        
    }

    // compare takes constant time as character size limit is fixed.
    private static boolean compare(int[] countT, int[] countW) {
        for (int i = 0; i < countT.length; i++) {
            if (countT[i]!=countW[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        String s1 = "BACDGABCDA";
        String s1 = "AAABABAA";
//        String s2 = "ABCD";
        String s2 = "AABA";
        printPositions(s1.toCharArray(), s2.toCharArray());
    }
}
