package com.string;

import java.util.HashMap;

public class PatternMatching {
    public static void main(String[] args) {
        PatternMatching patternMatching = new PatternMatching();
        System.out.println(patternMatching.patternMatching("aaaa", "dogcatcatdog"));
        System.out.println(patternMatching.patternMatching("abba", "dogcatcatdog"));
        System.out.println(patternMatching.patternMatching("bbb", "xxxxxx"));
        System.out.println(patternMatching.patternMatching("bbba", "xxxxxxy"));
        System.out.println(patternMatching.patternMatching("bbbaa", "xxxxxxy"));
        System.out.println(patternMatching.patternMatching("aaaaab", "xahnxdxyaahnxdxyaahnxdxyaahnxdxyaauxuhuo"));
    }

    public boolean patternMatching(String pattern, String value) {
        int counta = 0;
        int countb = 0;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (c == 'a') counta++;
            else countb++;
        }
        char[] chars = pattern.toCharArray();
        if (counta < countb) {
            for (int i = 0; i < chars.length; i++) {
                chars[i] = chars[i] == 'a' ? 'b' : 'a';
            }
        }
        if (pattern.length() == 0) return value.length() == 0;
        if (value.length() == 0) return countb == 0;
        for (int lena = 0; lena * counta <= value.length(); lena++) {
            /*遍历value取得每个a,b*/
            int rest= value.length()-lena*counta;
            if ((countb == 0 && rest == 0) || (countb != 0 && rest%countb == 0)) {
                int lenb = countb==0?0:rest/countb;
                int pos = 0;
                String a = "";
                String b = "";
                boolean flag = true;
                String value_a = "", value_b = "";
                for (char ch: pattern.toCharArray()) {
                    if (ch == 'a') {
                        String sub = value.substring(pos, pos + lena);
                        if (value_a.length() == 0) {
                            value_a = sub;
                        } else if (!value_a.equals(sub)) {
                            flag = false;
                            break;
                        }
                        pos += lena;
                    } else {
                        String sub = value.substring(pos, pos + lenb);
                        if (value_b.length() == 0) {
                            value_b = sub;
                        } else if (!value_b.equals(sub)) {
                            flag = false;
                            break;
                        }
                        pos += lenb;
                    }
                }
                if (flag&&!a.equals(b)) return true;

            }
        }
        return false;
    }


}
