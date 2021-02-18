package com.string.substring;

public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome l = new LongestPalindrome();
        System.out.println(l.longestPalindrome("cbbd"));
    }

    public String longestPalindrome(String s) {
        lo = new int[2];
        for (int i = 0; i < s.length(); i++) {
            palindromeCheck(i, i, s);
            palindromeCheck(i, i + 1, s);

        }
        return s.substring(lo[0],lo[1]);
    }

    int[] lo;

    private void palindromeCheck(int a, int b, String s) {
        while (a >= 0 && b < s.length()) {

            if (s.charAt(a) == s.charAt(b)) {
                a--;
                b++;
            } else break;
        }
        if (a >= b) {
            if (lo[1] - lo[0] == 0) {
                lo[0] = a+1;
                lo[1] = a+1;
            }
        } else {
            if (lo[1] - lo[0] < b - a) {
                lo[0] = a+1;
                lo[1] = b;
            }
        }
    }
}
