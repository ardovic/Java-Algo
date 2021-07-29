package com.study.problems.hard;

import java.util.Random;

public class RandomPickAndWeight {

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 15, 3, 4, 5});

        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());

        // Most should be 1
    }

    static class Solution {

        int sum;
        int[] sumAtIdx;
        int[] w;
        Random r;

        public Solution(int[] w) {
            this.w = w;
            r = new Random();
            sumAtIdx = new int[w.length];
            for (int i = 0; i < w.length; i++) {
                sum += w[i];
                sumAtIdx[i] = sum;
            }
        }

        public int pickIndex() {
            int picker = r.nextInt(sum);
            for (int i = 0; i < w.length; i++) {
                if (picker < sumAtIdx[i]) {
                    return i;
                }
            }
            return 0;
        }
    }
}
