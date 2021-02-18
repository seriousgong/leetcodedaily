package com.dailyproblem;


public class ValidPlaindRome {
    public static void main(String[] args) {
        ValidPlaindRome validPlaindRome = new ValidPlaindRome();
        System.out.println(validPlaindRome.validPalindrome("acbcba"));
        System.out.println(validPlaindRome.validPalindrome("aba"));
        System.out.println(validPlaindRome.validPalindrome("abc"));
        System.out.println(validPlaindRome.validPalindrome("ab"));
        System.out.println(validPlaindRome.validPalindrome("a"));
        System.out.println(validPlaindRome.validPalindrome("acba"));
        System.out.println(validPlaindRome.validPalindrome("abca"));
        System.out.println(validPlaindRome.validPalindrome("abcca"));
        System.out.println(validPlaindRome.validPalindrome("abcbcca"));
        System.out.println(validPlaindRome.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
//        System.out.println(validPlaindRome.validPalindrome("aguokepatgbnvfqmgmlucupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuclmgmqfvnbgtapekouga"));
//        char[] chars = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga".toCharArray();
//        for (int i = 0; i <= chars.length-1-i; i++) {
//            char temp = chars[i];
//            chars[i]=chars[chars.length-1-i];
//            chars[chars.length-1-i]=temp;
//        }
//
//        System.out.println(java.lang.String.valueOf(chars));
    }
    public boolean validPalindrome(String s) {
        int length = s.length();
        int end = length-1;
        int count = 0;
        for (int i = 0; i <= end; i++) {
            /*双指针*/
            if(s.charAt(i)!=s.charAt(end)){
                 if(s.charAt(i+1)==s.charAt(end)&&(i+2>end-1||s.charAt(i+2)==s.charAt(end-1))){
                     i++;
                     count++;
                 }else if(s.charAt(i)==s.charAt(end-1)&&(i+1>end-2||s.charAt(i+1)==s.charAt(end-2))){
                     end--;
                     count++;
                 }else {
                     return false;
                 }
             }
            if(count>1)return false;
             end--;
        }
        return true;
    }
}
