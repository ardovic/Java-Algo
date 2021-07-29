package com.study.problems;

import java.util.HashMap;
import java.util.Map;

class SparseVector {

    public static void main(String[] args) {
        SparseVector v1 = new SparseVector(new int[]{0, 1, 0, 0, 2, 0, 0});
        SparseVector v2 = new SparseVector(new int[]{1, 0, 0, 0, 3, 0, 4});

        System.out.println(v1.dotProduct(v2));
    }

    Map<Integer, Integer> map;

    SparseVector(int[] arr) {
        map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                map.put(i, arr[i]);
            }
        }
    }

    public int dotProduct(SparseVector vec) {
        int product = 0;
        for (Map.Entry<Integer, Integer> entry : vec.map.entrySet()) {
            int key = entry.getKey();
            if (this.map.containsKey(key)) {
                product += entry.getValue() * this.map.get(key);
            }
        }
        return product;
    }
}
