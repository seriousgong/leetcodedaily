package com.string;


import java.util.*;

public class PalindromePairs {
    public static void main(String[] args) {
        PalindromePairs p = new PalindromePairs();
        System.out.println(p.palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));
        System.out.println(p.palindromePairs(new String[]{"a", ""}));
        System.out.println(p.palindromePairs(new String[]{"a", "abc", "aba", ""}));
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String, Integer> preMap = new HashMap<>();
        HashMap<String, Integer> revMap = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            revMap.put(reverse(words[i]), i);
        }
        System.out.println(revMap.toString());
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int len = word.length();
            for (int i1 = 0; i1 <= word.length(); i1++) {
                if (isPalindrome(word, i1, len - 1)) {
                    String substring = word.substring(0, i1);
                    Integer val = revMap.getOrDefault(substring, -1);
                    if (val != -1 && val != i) {
                        ans.add(Arrays.asList(i, val));
                    }
                }
                if (i1 > 0 && isPalindrome(word, 0, i1 - 1)) {
                    Integer val = revMap.getOrDefault(word.substring(i1, len), -1);
                    if (val != -1 && val != i) {
                        ans.add(Arrays.asList(val, i));
                    }
                }
            }
        }
        return ans;

    }

    boolean isPalindrome(String word, int left, int right) {
        for (int i = 0; i < right-left+1 ; i++) {
            if (!(word.charAt(left+i) == word.charAt(right - i))) return false;
        }
        return true;
    }

    String reverse(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i <= chars.length - i - 1; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }
        return new String(chars);
    }
}
