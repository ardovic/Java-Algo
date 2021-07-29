package com.study.problems.cheatsheet;

public class TrappingRainWater {

    public static void main(String[] args) {
        System.out.println(trapWater(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public static int trapWater(int[] height) {

        int water = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;

        while (left < right) {
            if (height[left] > leftMax) {
                leftMax = height[left];
            }
            if (height[right] > rightMax) {
                rightMax = height[right];
            }
            if (leftMax < rightMax) {
                water += leftMax - height[left];
                left++;
            } else {
                water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }
}
