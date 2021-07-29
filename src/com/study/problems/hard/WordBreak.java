package com.study.problems.hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class WordBreak {

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code"))); // true
        System.out.println(wordBreak("applepenapple", Arrays.asList("apple", "pen"))); // true
        System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"))); // false
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        // [l, e, e, t, c, o, d, e, X]
        // [t, f, f, f, t, f, f, f, t]

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
