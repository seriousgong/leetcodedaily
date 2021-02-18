package com.string.substring;

public class CountBinarySubstrings {
    public static void main(String[] args) {
        CountBinarySubstrings s = new CountBinarySubstrings();
        System.out.println(s.countBinarySubstrings1("00110011"));
        System.out.println(s.countBinarySubstrings1("10101"));
        System.out.println(s.countBinarySubstrings1("00110"));
        System.out.println(s.countBinarySubstrings1("01100"));

    }

    public int countBinarySubstrings(String s) {
        ans = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            centerDevelopment(s, i, i + 1);
        }
        return ans;
    }

    void centerDevelopment(String s, int left, int right) {
        char c = s.charAt(left);
        char c1 = s.charAt(right);
        if (c != c1) {
            ans++;
            left--;
            right++;
            while (left >= 0 && right < s.length() && s.charAt(left) == c && s.charAt(right) == c1) {
                ans++;
                left--;
                right++;
            }
        }
    }

    int ans;

    public int countBinarySubstrings1(String s) {
        char[] chars = s.toCharArray();
        int[] nums = new int[2];
        int count = 0;
        int flag = -1;
        int ans = 0;
        for (char aChar : chars) {
            if (flag == -1) {
                flag = aChar - 48;
                nums[flag]++;
            } else {
                if (aChar - 48 == flag) {
                    nums[flag]++;
                    if (nums[flag] <= count) ans++;
                } else {
                    count = nums[flag];
                    flag = aChar - 48;
                    nums[flag] = 1;
                    ans++;
                }
            }
        }
        return ans;
    }
}
