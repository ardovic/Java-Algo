package com.study.problems.hard;

public class FastPowerAlgorithm {

    public static void main(String[] args) {
        System.out.println(myPow(1.0, 123123));
        System.out.println(myPow(2.0, -123123));
        System.out.println(myPow(2.123, -4));
        System.out.println(myPow(15.123, 14));
        System.out.println(myPow(34.52, 344));
    }

    public static double myPow(double x, int n) {
        if (x == 1) return x;

        if (n < 0) {
            n = -n;
            return 1 / fastPow(x, n);
        } else {
            return fastPow(x, n);
        }
    }

    public static double fastPow(double x, int n) {
        if (n == 0) return 1.0;

        double half = fastPow(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
