package com.ifocus.preps.stack;

import java.util.Stack;

/*
"3[a3[c]]"
Initialize an empty stack.
Iterate through the string:
Encounter 3, push 3 to the stack.
Encounter [, do nothing.
Encounter a, push a to the stack.
Encounter 3, push 3 to the stack.
Encounter [, do nothing.
Encounter c, push c to the stack.
Encounter ], pop c and 3, form ccc and push it back to the stack.
Encounter ], pop ccc, a, and 3, form acccacccaccc and push it back to the stack.
The final stack contains acccacccaccc as the only element, which is the decoded string.
 */
public class DecodeString {
    public String decodeString(String s) {
        System.out.println("Decode " + s);
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> resStack = new Stack<>();
        int idx = 0;
        StringBuilder res = new StringBuilder();
        int k = 0;
        while (idx < s.length()) {
            char current = s.charAt(idx);
            if (Character.isDigit(current)) {
                // If digit, continue read and calculate the number k
                while (Character.isDigit(s.charAt(idx))) {
                    k = k * 10 + s.charAt(idx) - '0';
                    idx++;
                }
            } else if (current == '[') {
                // Push the number k and reset k
                // Push the current result to the stack and reset result
                countStack.push(k);
                k = 0;
                // push the current accumulated res to the stack and reset the accumulated res to multiply later
                resStack.push(res);
                res = new StringBuilder();
                idx++;
            } else if (current == ']') {
                // Pop a count from the countStack and append the current result that many times to the last result in resStack
                StringBuilder temp = res;
                res = resStack.pop();
                for (k = countStack.pop(); k > 0; k--) {
                    res.append(temp);
                }
                idx++;
            } else {
                // Append the current character to the result
                res.append(current);
                idx++;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        DecodeString sol = new DecodeString();
//        System.out.println(sol.decodeString("a3[b]")); // Output: acccacccaccc
        System.out.println(sol.decodeString("3[a3[c]]")); // Output: acccacccaccc
//        System.out.println(sol.decodeString("2[b3[d]]")); // Output: bdddbddd
//        System.out.println(sol.decodeString("4[z]")); // Output: zzzz
    }
}

