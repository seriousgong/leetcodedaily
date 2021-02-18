package com.dailyproblem;

public class AddStrings {
    public static void main(String[] args) {
        System.out.println((char) 48);
        AddStrings a = new AddStrings();
//        System.out.println(a.addStrings("0", "9"));
        System.out.println(a.addStrings("9", "99"));
    }

    public String addStrings(String num1, String num2) {
        int in1 = num1.length() - 1;
        int in2 = num2.length() - 1;
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        if (num1.length() >= num2.length()) {
            int flag = 0;
            while (in1 >= 0) {
                int sum;
                if (in2 >= 0) {
                    sum = chars1[in1] + chars2[in2] - 96 + flag;// 每位位置的int数
                } else sum = chars1[in1] - 48+ flag;
                flag = 0;
                if (sum >= 10) {
                    sum -= 10;
                    flag = 1;
                }
                sum += 48;
                chars1[in1] = (char) (sum);
                in2--;
                in1--;
            }
            if (flag != 0) return "1" + String.valueOf(chars1);
            return String.valueOf(chars1);
        } else {
            int flag = 0;
            while (in2 >= 0) {
                int sum;
                if (in1 >= 0) {
                    sum = chars1[in1] + chars2[in2] - 96 + flag;// 每位位置的int数
                } else sum = chars2[in2] - 48 + flag;
                flag = 0;
                if (sum >= 10) {
                    sum -= 10;
                    flag = 1;
                }
                sum += 48;
                chars2[in2] = (char) (sum);
                in2--;
                in1--;
            }
            if (flag != 0) return "1" + String.valueOf(chars2);
            return String.valueOf(chars2);
        }

    }
}
