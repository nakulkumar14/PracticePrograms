package com.cvent;

// rank soldiers
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int ranks[] = {3, 4, 3, 0, 2, 2, 3, 0, 0};
        System.out.println(solution.solution(ranks));

        int ranks1[] = {4, 2, 0};
        System.out.println(solution.solution(ranks1));

        int ranks2[] = {4, 4, 3, 3, 1, 0};
        System.out.println(solution.solution(ranks2));
    }

    public int solution(int[] ranks) {
        // write your code in Java SE 8
        int max = ranks[0];
        for (int i = 0; i < ranks.length; i++) {
            if (max < ranks[i])
                max = ranks[i];
        }

        int count[] = new int[max + 1];

        for (int i = 0; i < ranks.length; i++) {
            count[ranks[i]]++;
        }

        int no = 0;
        for (int i = 0; i < count.length - 1; i++) {
            if (count[i] > 0 && count[i + 1] > 0) {
                no += count[i];
            }
        }

        return no;
    }
}