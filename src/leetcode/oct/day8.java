package leetcode.oct;

public class day8 {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length - i - 1; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
    }
}
