package leetcode.sept;

import java.util.ArrayList;
import java.util.List;

public class day11 {
    public static void main(String[] args) {
        day11 d = new day11();
        System.out.println(d.combinationSum3(3, 7));
        System.out.println(d.combinationSum3(3, 9));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        if (k == 0 || n == 0) return ans;
        temp = new ArrayList<>();
        recall(k, n, 1, 0);
        return ans;
    }

    ArrayList<Integer> temp;

    private void recall(int k, int n, int curr, int sum) {
//        if (temp.size() > k) return;
        if (temp.size() == k) {
            if (sum == n) ans.add(new ArrayList<>(temp));
        }
        for (int i = curr; i < 10; i++) {
            if (sum + i > n) continue;
            if (temp.size() >= k) return;
            temp.add(i);
            recall(k, n, i + 1, sum + i);
            temp.remove(temp.size() - 1);
        }
    }

    List<List<Integer>> ans;
}
