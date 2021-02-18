package leetcode.oct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class day22 {
    public static void main(String[] args) {
        day22 d = new day22();
        System.out.println(d.partitionLabels("ababcbacadefegdehijhklij"));
    }

    public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0) return null;
        List<Integer> ans = new ArrayList<>();
        int[] alphet = new int[26];
        HashSet<Character> hashSet = new HashSet<>();
        byte[] bytes = S.getBytes();
        for (byte aByte : bytes) {
            alphet[aByte - 'a']++;
        }
        HashSet<Byte> h = new HashSet<>();
        int count = 0;
        for (byte aByte : bytes) {
            if (h.isEmpty()) {
                h.add(aByte);
            } else {
                if (!h.contains(aByte)) {
                    boolean flag = true;
                    for (Byte aByte1 : h) {
                        if (alphet[aByte1 - 'a'] > 0) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        ans.add(count);
                        count = 0;
                        h.clear();
                    }
                    h.add(aByte);
                }
            }
            alphet[aByte - 'a']--;
            count++;
        }
        if (count != 0) ans.add(count);
        return ans;
    }
}
