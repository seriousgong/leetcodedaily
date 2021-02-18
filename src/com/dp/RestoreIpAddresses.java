package com.dp;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public static void main(String[] args) {
        RestoreIpAddresses r = new RestoreIpAddresses();
        System.out.println(r.restoreIpAddresses("25525511135"));
        System.out.println(r.restoreIpAddresses("0000"));
        System.out.println(r.restoreIpAddresses("010010"));

    }

    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        if (s == null || s.length() <= 3 || s.length() > 12) return ans;
        else if (s.length() == 4) {
            ans.add(s.charAt(0) + "." + s.charAt(1) + "." + s.charAt(2) + "." + s.charAt(3));
            return ans;
        }
        chars = new char[s.length() + 3];
        recall(s, 0, 0);
        return ans;
    }

    char[] chars;
    List<String> ans;

    void recall(String s, int index, int dolt) {
        if (dolt == 4 && index < s.length()) return;
        if (index >= s.length()) {
            if (dolt == 4) {
                ans.add(new String(chars));
            }
            return;
        }
        int sum = 0;
        for (int i = index; i < index + 3 && i < s.length(); i++) {
            sum = sum * 10 + (s.charAt(i) - 48);
            chars[i + dolt] = s.charAt(i);
            if (dolt < 3) chars[i + dolt + 1] = '.';
            if (sum == 0) {
                recall(s, i + 1, dolt + 1);
                return;
            } else if (sum <= 255) {
                recall(s, i + 1, dolt + 1);
            }
        }
    }
}
