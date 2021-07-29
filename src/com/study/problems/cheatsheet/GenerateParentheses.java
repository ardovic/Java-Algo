package com.study.problems.cheatsheet;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(5));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        if (n == 0) {
            answer.add("");
        } else {
            for (int i = 0; i < n; i++) {
                for (String left : generateParenthesis(i)) {
                    for (String right : generateParenthesis(n - 1 - i)) {
                        answer.add("(" + left + ")" + right);
                    }
                }
            }
        }
        return answer;
    }
}
