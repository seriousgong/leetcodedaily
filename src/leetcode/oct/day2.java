package leetcode.oct;

public class day2 {
    public static void main(String[] args) {
        System.out.println('a' - 0);
        System.out.println('A' - 0);
    }

    public int numJewelsInStones(String J, String S) {
        if (J == null || S == null || J.length() == 0 || S.length() == 0) return 0;
        int[] map = new int[52];
        byte[] bytes = J.getBytes();
        for (byte aByte : bytes) {
            if (aByte >= 97) {
                map[aByte - 'a' + 26]++;
            } else
                map[aByte - 'A']++;

        }
        int ans = 0;
        for (byte aByte : S.getBytes()) {
            if (aByte >= 97) {
                ans += map[aByte - 'a' + 26];
            } else {
                ans += map[aByte - 'A'];
            }
        }
        return ans;
    }
}
