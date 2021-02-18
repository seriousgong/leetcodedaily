package leetcode.oct;

public class day19 {
    public static void main(String[] args) {
        System.out.println('#');
        day19 d = new day19();
        System.out.println(d.backspaceCompare("ab#c", "ad#c"));
    }

    public boolean backspaceCompare(String S, String T) {
        StringBuilder sb = new StringBuilder();
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '#') {
                if (sb.length() != 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(chars[i]);
            }
        }
        String newS = sb.toString();
        System.out.println(newS);
        sb = new StringBuilder();
        chars = T.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '#') {
                if (sb.length() != 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(chars[i]);
            }
        }
        String newT = sb.toString();
        System.out.println(newT);

        return newT.equals(newS);
    }
}
