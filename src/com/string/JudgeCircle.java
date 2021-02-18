package com.string;

import java.util.Arrays;

public class JudgeCircle {
    public static void main(String[] args) {
        String s = "LRDU";
        System.out.println(Arrays.toString(s.getBytes()));
    }

    public boolean judgeCircle(String moves) {
        if (moves.length() % 2 != 0) return false;
        byte[] bytes = moves.getBytes();
        int row = 0;
        int column = 0;
        for (byte aByte : bytes) {
            switch (aByte) {
                case 76:
                    row--;
                    break;
                case 82:
                    row++;
                    break;
                case 68:
                    column--;
                    break;
                case 85:
                    column++;
            }
        }
        return row == 0 && column == 0;
    }

    boolean way2(String moves) {
        int[] alphet = new int[26];
        for (int i = 0; i < moves.length(); i++) {
            alphet[moves.charAt(i) - 'A']++;
        }
        return alphet['L' - 'A'] == alphet['R' - 'A'] && alphet['U' - 'A'] == alphet['D' - 'A'];
    }
}
