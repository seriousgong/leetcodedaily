package com.string.substring;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"aa","a"}));
    }
    public String longestCommonPrefix(String[] strs) {

        if(strs==null||strs.length==0)return "";
        String prefix = strs[0];
        for (int i =1; i < strs.length; i++) {
            String str = strs[i];
            for (int i1 = 0; i1 < str.length()&&i1<prefix.length(); i1++) {
                if(!(str.charAt(i1)==prefix.charAt(i1))){
                    prefix=prefix.substring(0,i1);
                    break;
                }
            }
            if(prefix.length()>str.length())prefix=prefix.substring(0,str.length());
        }
        return  prefix;
    }
}
