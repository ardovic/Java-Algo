package com.study.problems;

public class SearchInsertPosition {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
    }

    public static int searchInsert(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (arr[left] >= target) {
            return left;
        } else {
            return left + 1;
        }
    }
}
