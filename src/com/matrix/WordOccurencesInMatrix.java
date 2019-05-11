package com.matrix;

// https://www.geeksforgeeks.org/find-all-occurrences-of-the-word-in-a-matrix/
public class WordOccurencesInMatrix {

    static void findWords(char[][] mat, char[] word) {
        int k = 0;
        String s = "";
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (word[k] == mat[i][j]) {
                    dfs(mat, i, j, word, k, s);
                }
            }
        }
    }

    private static void dfs(char[][] mat, int i, int j, char[] word, int k, String s) {
        int r[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int c[] = {-1, 0, 1, -1, 1, -1, 0, 1};

        if (i < 0 || j < 0 || i > mat.length || j > mat[0].length || mat[i][j] != word[k])
            return;

        s += "(" + i + "," + j + ") ";

        if (k == word.length - 1) {
            System.out.println(s);
        }

        for (int l = 0; l < 8; l++) {
//            System.out.println((i+r[l]) +" " + (j+c[l]) + " " + (k+1));
            if (!isValid(mat, i + r[l], j + c[l], word, k + 1) && mat[i + r[l]][j + c[l]] == word[k + 1]) {
                dfs(mat, i + r[l], j + c[l], word, k + 1, s);
            }
        }
    }

    private static boolean isValid(char[][] mat, int i, int j, char[] word, int k) {
        return i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || k >= word.length;
    }

    public static void main(String[] args) {
        char mat[][] = {
                {'B', 'N', 'E', 'Y', 'S'},
                {'H', 'E', 'D', 'E', 'S'},
                {'S', 'G', 'N', 'D', 'E'}
        };
        char word[] = {'D', 'E', 'S'};
        findWords(mat, word);

        char word1[] = "BNEGSHBN".toCharArray();
        findWords(mat, word1);
    }
}
