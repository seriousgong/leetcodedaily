package leetcode.sept;

import java.util.ArrayList;
import java.util.List;

public class day8 {
    public static void main(String[] args) {
        day8 d = new day8();
        System.out.println(d.combine(4, 2));
        System.out.println(d.combine(4, 3));
        System.out.println(d.combine(20, 16));
    }

    public List<List<Integer>> combine(int n, int k) {
        size = n;
        ans = new ArrayList<>();
        temp = new ArrayList<>();

        recall(n, k, 0, 1);
        return ans;
    }

    int size;
    List<List<Integer>> ans;
    List<Integer> temp;

    void recall(int n, int k, int num, int index) {
        if (num >= k) {
                ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i <= n-(k-num)+1; i++) {
            if (temp.size() <= num) temp.add(i);
            else temp.set(num, i);
            recall(n, k, num + 1, i + 1);
        }

    }

    private boolean contain() {
        for (List<Integer> an : ans) {
            boolean[] arr = new boolean[size + 1];
            for (Integer integer : an) {
                arr[integer] = true;
            }
            boolean flag = true;
            for (Integer integer : temp) {
                flag &= arr[integer];
            }
            if (flag) return true;
        }
        return false;
    }
}
