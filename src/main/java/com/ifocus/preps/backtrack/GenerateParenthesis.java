package com.ifocus.preps.backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        backtracking(answer, new StringBuilder(), 0, 0, n);

        return answer;
    }

    private void backtracking(List<String> answer, StringBuilder curString, int leftCount, int rightCount, int n) {
        // even pairs reached
        if (curString.length() == n * 2) {
            answer.add(curString.toString());
            return;
        }
        // Add left parenthesis
        if (leftCount < n) {
            curString.append("(");
            backtracking(answer, curString, leftCount + 1, rightCount, n);
            // backtrack, deleting last inserted
            curString.deleteCharAt(curString.length() - 1);
        }
        // Add right parenthesis if left is greater
        if (leftCount > rightCount) {
            curString.append(")");
            backtracking(answer, curString, leftCount, rightCount + 1, n);
            curString.deleteCharAt(curString.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> strings = new GenerateParenthesis().generateParenthesis(6);
        strings.forEach(System.out::println);
    }
}
