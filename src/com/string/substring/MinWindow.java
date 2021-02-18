package com.string.substring;


import java.util.HashMap;

public class MinWindow {
    public static void main(String[] args) {
        int[] charArray = new int[129];
        MinWindow minWindow = new MinWindow();
        System.out.println(minWindow.minWindow("ADOBEODEBNC", "ABC"));
        System.out.println(minWindow.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow.minWindow("ADOBCNNBANC", "ABC"));
        System.out.println(minWindow.minWindow("ADOBECODEBAN", "ABC"));
        System.out.println(minWindow.minWindow("ADOBECODEBAN", "AB"));
        System.out.println(minWindow.minWindow("ADOBECODEBAN", "BB"));
        System.out.println(minWindow.minWindow("ADOBECODEBAN", "BBA"));
        System.out.println(minWindow.minWindow("ADOBECODEBAN", "B"));
        System.out.println(minWindow.minWindow("ADOBECODEBAN", ""));
        System.out.println(minWindow.minWindow("BCDOBEAOCDEBAN", "ABC"));
        System.out.println(minWindow.minWindow("a", "aa"));
        System.out.println(minWindow.minWindow("ab", "b"));
        System.out.println(minWindow.minWindow("aa", "aa"));
        System.out.println(minWindow.minWindow("aab", "ba"));


    }

    public String minWindowV2(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        HashMap<Character, Integer> hashMap1 = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (hashMap.containsKey(c)) hashMap.put(c, hashMap.get(c) + 1);
            else hashMap.put(c, 1);
        }
        int start = 0;
        int end = 0;
        int left = 0;
        int right = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hashMap.containsKey(c)) {
                if (!hashMap1.containsKey(c)) {
                    hashMap1.put(c, 1);
                    count++;
                } else {
                    if (hashMap.get(c) > hashMap1.get(c)) count++;
                    hashMap1.put(c, hashMap1.get(c) + 1);
                }
                end = i;
            }
            while (count == t.length() & t.length() > 0) {
                if (right - left > end - start) {
                    right = end;
                    left = start;
                }
                if (left == right) break;
                /*start开始移动*/
                if (start < end && hashMap.containsKey(s.charAt(start))) {
                    if (hashMap1.get(s.charAt(start)) <= hashMap.get(s.charAt(start))) {
                        count--;
                    }
                    hashMap1.put(s.charAt(start), hashMap1.get(s.charAt(start)) - 1);
                    start++;
                }
                while (start < end && !hashMap.containsKey(s.charAt(start))) {
                    start++;
                }
            }
        }
        return right == Integer.MAX_VALUE ? "" : s.substring(left, right + 1);
    }
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        if (sLen == 0 || tLen == 0 || sLen < tLen) {
            return "";
        }

        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        int[] tFreq = new int[128];
        for (char c : charArrayT) {
            tFreq[c]++;
        }

        // 滑动窗口内部还差多少 T 中的字符，对应字符频数超过不重复计算
        int distance = tLen;
        int minLen = sLen + 1;
        int begin = 0;

        int left = 0;
        int right = 0;
        // [left..right)
        while (right < sLen) {
            char charRight = charArrayS[right];
            if (tFreq[charRight] > 0) {
                distance--;
            }
            tFreq[charRight]--;
            right++;

            // System.out.println(distance + " " + s.com.string.substring(left, right));
            while (distance == 0) {
                // System.out.println("左边界收缩 " + distance + " " + s.com.string.substring(left, right));
                // System.out.println(tFreq['A'] + "," + tFreq['B'] + "," + tFreq['C']);

                if (right - left < minLen) {
                    minLen = right - left;
                    begin = left;
                }

                char charLeft = charArrayS[left];
                tFreq[charLeft]++;
                if (tFreq[charLeft] > 0) {
                    distance++;
                }
                left++;
            }
        }

        if (minLen == sLen + 1) {
            return "";
        }
        return s.substring(begin, begin + minLen);
    }
}
