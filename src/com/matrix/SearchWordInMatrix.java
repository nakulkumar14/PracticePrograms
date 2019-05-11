package com.matrix;

// https://www.geeksforgeeks.org/check-if-a-word-exists-in-a-grid-or-not/
// visited cells not marked but should be done.
public class SearchWordInMatrix {

    static boolean searchUtil(char[][] mat, int i, int j, char[] word, int k) {
        if (k > mat.length * mat.length)
            return false;

        if (i < 0 || j < 0 || i >= mat.length || j >= mat.length)
            return false;

        if (k == word.length)
            return true;

        System.out.println(word[k] + ", " + i + " " + j);

        if (word[k] == mat[i][j]) {
            return searchUtil(mat, i + 1, j, word, k + 1) ||
                    searchUtil(mat, i - 1, j, word, k + 1) ||
                    searchUtil(mat, i, j + 1, word, k + 1) ||
                    searchUtil(mat, i, j - 1, word, k + 1);
        } else
            return false;
    }

    static boolean search(char[][] mat, char[] word, int k) {

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (word[k] == mat[i][j]) {
                    System.out.println(word[k] + ", " + i + " " + j);
                    if (searchUtil(mat, i, j, word, k))
                        return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        char mat[][] = {
                {'a', 'x', 'm', 'y'},
                {'b', 'g', 'd', 'f'},
                {'x', 'e', 'e', 't'},
                {'r', 'a', 'k', 's'}
        };
        char word[] = {'g', 'e', 'e', 'k', 's'};
        System.out.println(search(mat, word, 0));

    }
}
