package com.string.bracket;

import java.util.Stack;

public class IsValid {
    public static void main(String[] args) {
        IsValid s = new IsValid();
        System.out.println(s.isValid(""));
        System.out.println(s.isValid("()"));
        System.out.println(s.isValid("(]"));
    }

    public boolean isValid(String s) {
        int length = s.length();
        if ((length & 1) == 1) return false;
        int[] a1 = new int[length];
        int index = -1;
        for (int i = 0; i < length; i++) {
            switch (s.charAt(i)) {
                case '(':
                    a1[++index] = '(';
                    break;
                case ')':
                    if (index == -1 || a1[index] != '(') return false;
                    else a1[index--] = 0;
                    break;
                case '{':
                    a1[++index] = '{';
                    break;
                case '}':
                    if (index == -1 || a1[index] != '{') return false;
                    else a1[index--] = 0;
                    break;
                case '[':
                    a1[++index] = '[';
                    break;
                case ']':
                    if (index == -1 || a1[index] != '[') return false;
                    else a1[index--] = 0;
                    break;
            }
        }
        return index == -1;
    }
}
