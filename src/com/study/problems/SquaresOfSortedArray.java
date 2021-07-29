package com.study.problems;

import java.util.Arrays;

public class SquaresOfSortedArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-7, -3, 2, 3, 11})));
    }

    public static int[] sortedSquares(int[] nums) {

        if (nums[0] < 0) {

            int left = 0;
            int right = 0;
            int[] result = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= 0) {
                    left = i - 1;
                    right = i;
                    break;
                }
            }

            int i = 0;

            while (true) {

                if (left < 0 && right < nums.length) {
                    result[i] = nums[right] * nums[right];
                } else if (left >= 0 && right >= nums.length) {
                    result[i] = nums[left] * nums[left];
                } else if (left < 0 && right >= nums.length) {
                    break;
                } else {

                    if (-nums[left] > nums[right]) {
                        result[i] = nums[left] * nums[left];
                        left--;
                    } else {
                        result[i] = nums[right] * nums[right];
                        right++;
                    }
                }


            }

            return result;

        } else {

            for (int i = 0; i < nums.length; i++) {
                nums[i] = nums[i] * nums[i];
            }

            if(nums[0] < 0) {

            }
        }

        return nums;
    }
}
