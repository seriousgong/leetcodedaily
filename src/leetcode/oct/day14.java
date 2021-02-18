package leetcode.oct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day14 {
    public static void main(String[] args) {
        day14 d = new day14();
        System.out.println(d.commonChars(new String[]{"bella", "label", "roller"}));
    }

    public List<String> commonChars(String[] A) {
        int[] alphet = new int[26];
        int[] temp = new int[26];

        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                for (int i1 = 0; i1 < A[0].length(); i1++) {
                    alphet[A[0].charAt(i1) - 'a']++;
                }
                System.out.println(Arrays.toString(alphet));
            } else {
                for (int i1 = 0; i1 < A[i].length(); i1++) {
                    temp[A[i].charAt(i1) - 'a']++;
                }
                System.out.println("temp:" + Arrays.toString(temp));
                for (int i1 = 0; i1 < alphet.length; i1++) {
                    alphet[i1] = Math.min(alphet[i1], temp[i1]);
                    temp[i1] = 0;
                }
                System.out.println(Arrays.toString(alphet));
            }
        }

        System.out.println(Arrays.toString(alphet));
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < alphet.length; i++) {
            if (alphet[i] != 0) {
                for (int i1 = 0; i1 < alphet[i]; i1++) {
                    ans.add(String.valueOf((char) (i + 'a')));
                }
            }
        }
        return ans;

    }
}
