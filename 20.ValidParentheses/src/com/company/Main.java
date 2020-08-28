package com.company;

import java.util.Stack;

public class Main {
    public static boolean isValid(String s) {
        char[] str = s.toCharArray();
        //System.out.println(str);

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(' || str[i] == '[' || str[i] == '{') {
                stack.push(str[i]);
            } else {
                if (stack.empty()) {
                    return false;
                }
                if (str[i] == ')') {
                    char c = stack.pop();
                    if (c != '(')
                        return false;
                }
                if (str[i] == ']') {
                    char c = stack.pop();
                    if (c != '[')
                        return false;
                }
                if (str[i] == '}') {
                    char c = stack.pop();
                    if (c != '{')
                        return false;
                }
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "(";
        System.out.println(isValid(s));
    }
}
