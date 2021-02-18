package leetcode.exam;

public class question3 {
    public static void main(String[] args) {
        question3 q = new question3();
        System.out.println(q.minimumOperations("rrryyyrryyyrr"));
        System.out.println(q.minimumOperations("yry"));
        System.out.println(q.minimumOperations("yyy"));
        System.out.println(q.minimumOperations("rrr"));
        System.out.println(q.minimumOperations("rrrr"));
        System.out.println(q.minimumOperations("rryrryrr"));
        System.out.println(q.minimumOperations("yryrryry"));
        System.out.println(q.minimumOperations("ryr"));
        System.out.println(q.minimumOperations("yrrrrry"));
    }

    public int minimumOperations(String leaves) {
        int ans = 0;
        char[] chars = leaves.toCharArray();
        char aChar = chars[chars.length - 1];
        if (aChar == 'y') ans++;
        if (chars[0] == 'y') ans++;
        int x = 0;
        int y = 0;
        int start = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != 'r') {
                start = i;
                break;
            }
        }
        int end = 0;
        for (int i = chars.length - 2; i > 0; i--) {
            if (chars[i] != 'r') {
                end = i;
                break;
            }
        }

        for (int i = start; i <= end; i++) {
            if (chars[i] == 'r') x++;
            else y++;
        }
        if (y == 0) return ans + 1;
        return x + ans;
    }
}
