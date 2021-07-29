package com.study.problems.cheatsheet;

import java.util.Arrays;

public class TaskScheduler {

    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2)); // 8
    }


    public static int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        if (tasks.length == 1) return 1;

        int[] counts = new int[26];

        for (char task : tasks) {
            counts[task - 'A']++;
        }

        Arrays.sort(counts);

        int freqTaskCount = counts[25];
        int idleTime = (freqTaskCount - 1) * n;

        for (int i = 24; i >= 0 && idleTime > 0; i--) {
            idleTime -= Math.min(freqTaskCount - 1, counts[i]);
        }

        idleTime = Math.max(0, idleTime);

        return idleTime + tasks.length;
    }
}
