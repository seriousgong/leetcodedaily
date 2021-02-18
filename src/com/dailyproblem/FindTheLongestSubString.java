package com.dailyproblem;

import java.util.Arrays;

public class FindTheLongestSubString {


    public static void main(String[] args) {
        FindTheLongestSubString findTheLongestSubString = new FindTheLongestSubString();
        System.out.println(findTheLongestSubString.findTheLongestSubstring("eleetminicoworoep"));
        System.out.println(findTheLongestSubString.findTheLongestSubstring("leetcodeisgreat"));
        System.out.println(findTheLongestSubString.findTheLongestSubstring("eeodeisgroatc"));
        System.out.println(findTheLongestSubString.findTheLongestSubstring("bcbcbc"));
        System.out.println(findTheLongestSubString.findTheLongestSubstring("a"));
        System.out.println(findTheLongestSubString.findTheLongestSubstring("ao"));
        System.out.println(findTheLongestSubString.findTheLongestSubstring("ci"));
        System.out.println(findTheLongestSubString.findTheLongestSubstring("ic"));
    }

    public int findTheLongestSubstringV2(String s) {
        int length = s.length();
        int count = 0;
        for (int index = 0; index < length; index++) {
            int a = 0;
            int e = 0;
            int i = 0;
            int o = 0;
            int u = 0;
            char c = s.charAt(index);
            switch (c) {
                case 'a':
                    a++;
                    break;
                case 'e':
                    e++;
                    break;
                case 'i':
                    i++;
                    break;
                case 'o':
                    o++;
                    break;
                case 'u':
                    u++;
                    break;
            }
            if (a % 2 == 0 && e % 2 == 0 && i % 2 == 0 && o % 2 == 0 && u % 2 == 0) {
                count = Math.max(count, 1);
            }
            if (count > length - 1 - index) break;
            for (int j = index + 1; j < length; j++) {
                char d = s.charAt(j);
                switch (d) {
                    case 'a':
                        a++;
                        break;
                    case 'e':
                        e++;
                        break;
                    case 'i':
                        i++;
                        break;
                    case 'o':
                        o++;
                        break;
                    case 'u':
                        u++;
                        break;
                }
                if (a % 2 == 0 && e % 2 == 0 && i % 2 == 0 && o % 2 == 0 && u % 2 == 0) {
                    count = Math.max(count, j - index + 1);
                }
            }

        }
        return count;
    }


    public int findTheLongestSubstring(String s) {

        int count = 0;
        int []byteArray = new int [1<<5];
        /*所有奇数偶数情况都未遇见*/
        Arrays.fill(byteArray,-1);
        byteArray[0]=0;//表示元音字符均为偶数个，那么最长串应为0-index;
        int byteValue = 0;
        for (int index = 0; index < s.length(); index++) {
            switch (s.charAt(index)) {
                case 'a':
                    byteValue ^=(1<<4);
                    break;
                case 'e':
                    byteValue ^=(1<<3);
                    break;
                case 'i':
                    byteValue ^=(1<<2);
                    break;
                case 'o':
                    byteValue ^=(1<<1);
                    break;
                case 'u':
                    byteValue ^=1;
                    break;
            }
            if(byteArray[byteValue]==-1){
                byteArray[byteValue]=index+1;//+1原因是byteArray[0]=0,相减缺少一个元素;
            }else {
                count=Math.max(count,index-byteArray[byteValue]+1);
            }

        }
        return count;
    }


}
