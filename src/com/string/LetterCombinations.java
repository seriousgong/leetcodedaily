package com.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {

    public static void main(String[] args) {

        LetterCombinations l = new LetterCombinations();
        System.out.println(l.letterCombinations("234"));
        System.out.println(l.letterCombinations(""));
    }

    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        sb = new StringBuilder();
        char[] a = new char[]{'a', 'b', 'c'};
        char[] a1 = new char[]{'d', 'e', 'f'};
        char[] a2 = new char[]{'g', 'h', 'i'};
        char[] a3 = new char[]{'j', 'k', 'l'};
        char[] a4 = new char[]{'m', 'n', 'o'};
        char[] a5 = new char[]{'p', 'q', 'r', 's'};
        char[] a6 = new char[]{'t', 'u', 'v'};
        char[] a7 = new char[]{'w', 'x', 'y', 'z'};
        alphlet.put('2', a);
        alphlet.put('3', a1);
        alphlet.put('4', a2);
        alphlet.put('5', a3);
        alphlet.put('6', a4);
        alphlet.put('7', a5);
        alphlet.put('8', a6);
        alphlet.put('9', a7);

        recall(digits, 0);
        return ans;
    }

    List<String> ans;
    HashMap<Character, char[]> alphlet = new HashMap<>();

    StringBuilder sb;

    void recall(String digits, int index) {
        if (digits == null || "".equals(digits)) return;
        if (index >= digits.length()) {
            ans.add(sb.toString());
            return;
        }
        char c = digits.charAt(index);
        char[] chars = alphlet.get(c);
        for (char aChar : chars) {
            if (sb.length() > index)
                sb.setCharAt(index, aChar);
            else sb.append(aChar);
            recall(digits, index + 1);
        }
    }
}
