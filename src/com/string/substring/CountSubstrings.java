package com.string.substring;

import java.util.ArrayList;
import java.util.List;

public class CountSubstrings {
    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        ans = chars.length;
        for (int i = 0; i < chars.length; i++) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
                ans++;
                left--;
                right++;
            }
            left = i;
            right = i + 1;
            while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
                ans++;
                left--;
                right++;
            }
        }
        return ans ;
    }

    int ans;

    /**
     * 向两头延展
     */
    void spread(String str, int left, int right) {

    }


}
