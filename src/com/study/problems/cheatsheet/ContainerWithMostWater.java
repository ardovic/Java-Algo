package com.study.problems.cheatsheet;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[] {1, 4, 5, 6, 30, 20, 2}));
    }

    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxWater = 0;
        while (l < r) {
            maxWater = Math.max(maxWater, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxWater;
    }
}
