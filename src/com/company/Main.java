package com.company;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        System.out.println(getMax("ddaa"));
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String format = simpleDateFormat.format(new Date());
//        System.out.println(format);
        System.out.println("++++"+reverseWords("the sky is blue")+"+++++");
        System.out.println("+++" + reverseWords("  hello world!  ") + "++++");
        System.out.println("+++" + reverseWords("a good   example") + "++++");

//        System.out.println(Arrays.toString(" ".getBytes()));
    }

    public static Character getMax(String string) {
        int max = 0;
        int[] sum = new int[127];
        char maxLetter = 0;
        for (int i = 0; i < string.length(); i++) {
            char num = string.charAt(i);
            if (++sum[num] > max) {
                max = sum[num];
                maxLetter = num;
            } else if (sum[num] == max) {
                maxLetter = maxLetter > num ? num : maxLetter;
            }
        }
        return maxLetter;
    }

    /*输出n对括号的所有排列*/
    public static List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int temp = i;
            StringBuilder stringBuilder = new StringBuilder();
            while (temp > 0) {
                stringBuilder.insert(0, "(").append(")");
                temp--;
            }
        }

        return list;

    }

    public static String reverseWords(String s) {
        s = s.trim();
        if(s.length()==0){
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String[] s1 = s.split(" ");
        for (int i = s1.length-1; i >= 0; i--) {
               if(s1[i].length()!=0)stringBuilder.append(s1[i]).append(" ");
                ;
        }
        return stringBuilder.deleteCharAt(stringBuilder.length()-1).toString();
    }
}
