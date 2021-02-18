package leetcode.sept;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class day3 {
    public static void main(String[] args) {
        day3 d = new day3();
        System.out.println(d.solveNQueens(1));
        System.out.println(d.solveNQueens(2));
        System.out.println(d.solveNQueens(3));
        System.out.println(d.solveNQueens(4));
        System.out.println(d.solveNQueens(5));
    }

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        list = new ArrayList<>();
        queenMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(".");
            queenMap.put(i, -1);
        }
        String row = sb.toString();
        for (int i = 0; i < n; i++) {
            list.add(row);
        }
        recall(n - 1, 0);
        return ans;
    }

    HashMap<Integer, Integer> queenMap;
    List<String> list;
    List<List<String>> ans;

    private void recall(int n, int level) {
        if (n < level) {
            ans.add(new ArrayList<>(list));
            return;
        }
        String s = list.get(level);
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i <= n; i++) {
            if (checkColumn(level, i) && checkAround(level, i) && checkDiagonalLine(level, i)) {
                sb.setCharAt(i, 'Q');
                list.set(level, sb.toString());
                queenMap.put(level, i);
                recall(n, level + 1);
                sb.setCharAt(i, '.');
                list.set(level, sb.toString());
                queenMap.put(level, -1);
            }
        }
    }

    private boolean checkAround(int level, int i) {
        if (level - 1 >= 0) {
            Integer loc = queenMap.get(level - 1);
            return (loc - i > 1 || i - loc > 1);
        }
        return true;
    }

    private boolean checkColumn(int level, int i) {
        for (int i1 = 0; i1 < level; i1++) {
            if (queenMap.get(i1) == i) {
                return false;
            }
        }
        return true;
    }

    /*确认主副对角线queen唯一*/
    private boolean checkDiagonalLine(int level, int i) {
        boolean flag = true;
        int tmp = level - 1;
        int tmp1 = i - 1;

        while (tmp >= 0 && tmp1 >= 0 && flag) {
            flag = (queenMap.get(tmp) != tmp1);
            tmp--;
            tmp1--;
        }
        tmp = level - 1;
        tmp1 = i + 1;
        while (tmp >= 0 && tmp1 < queenMap.size() && flag) {
            flag = (queenMap.get(tmp) != tmp1);
            tmp--;
            tmp1++;
        }
        return flag;
    }

}
