package leetcode.sept;

public class Day2 {
    public static void main(String[] args) {
        System.out.println(isNumber("5e"));
        System.out.println(isNumber("1"));
        System.out.println(isNumber("1."));
        System.out.println(isNumber("1 "));
        System.out.println(isNumber("959440.94f"));
        System.out.println(Float.valueOf("959440.94f"));
        System.out.println(isNumber("."));
        System.out.println(isNumber(".."));
        System.out.println('a' - 0);
    }

    public static boolean isNumber(String s) {
       return false;
    }


    static boolean check(byte b) {
        return b >= '0' && b <= '9' || b == '.';
    }

    static boolean checkNum(byte b) {
        return b >= '0' && b <= '9';
    }
}

