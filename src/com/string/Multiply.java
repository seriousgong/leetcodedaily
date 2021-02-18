package com.string;

public class Multiply {
    public static void main(String[] args) {
        Multiply m = new Multiply();
        StringBuilder s = new StringBuilder();
        s.append(0).append(2).append(9);
//        m.add(19, 1, s);
        System.out.println(s.toString());
//        System.out.println(m.multiply("123", "456"));
//        System.out.println(m.multiply("19", "19"));
        System.out.println(m.multiply("999", "999"));
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int n1len = num1.length();
        int n2len = num2.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n1len + n2len; i++) {
            sb.append(0);
        }
        for (int i = n1len - 1; i >= 0; i--) {
            int c = num1.charAt(i) - '0';
            for (int i1 = n2len - 1; i1 >= 0; i1--) {
                int c1 = num2.charAt(i1) - '0';
                int i2 = c * c1;
                int bit10 = n1len - 1 - i + n2len - 1 - i1; //10的几次方
                add(i2, bit10, sb);
            }
        }
        if (sb.charAt(0) == '0') return sb.substring(1);
        return sb.toString();
    }

    private void add(int i2, int bit10, StringBuilder sb) {
        int index = sb.length() - bit10 - 1;
        int flag = 0;
        while (i2 != 0) {
            int i = sb.charAt(index) - '0' + i2 % 10 + flag;
            flag = 0;
            if (i >= 10) {
                i -= 10;
                flag += 1;
            }
            sb.setCharAt(index, (char) (i + 48));
            i2 /= 10;
            index--;
        }
        while (flag != 0) {
            int i = sb.charAt(index) - '0' + flag;
            flag = 0;
            if (i >= 10) {
                i -= 10;
                flag = 1;
            }
            sb.setCharAt(index, (char) (i + '0'));
            index--;
        }
    }
}

