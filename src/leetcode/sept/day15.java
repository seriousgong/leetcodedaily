package leetcode.sept;

import java.util.ArrayList;
import java.util.List;

public class day15 {

    public static void main(String[] args) {

        char[][] chars = {new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        day15 d = new day15();
        d.solveSudoku(chars);
    }

    int[][] line = new int[9][9];
    int[][] column = new int[9][9];
    int[][][] block = new int[3][3][9];
    boolean ans;
    List<int[]> poss;

    public void solveSudoku(char[][] board) {
        ans = false;
        poss = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            char[] chars = board[i];
            for (int i1 = 0; i1 < chars.length; i1++) {
                if (board[i][i1] == '.') {
                    poss.add(new int[]{i, i1});
                } else {
                    int num = board[i][i1] - 49;
                    line[i][num] = 1; //第i行的 数字board[i][i1] - 1出现了
                    column[i1][num] = 1;//第i列 数字board[i][i1] - 1出现了
                    block[i / 3][i1 / 3][num] = 1; //第i/3行第i/3列方块 数字board[i][i1] - 1出现过了
                }
            }
        }
        recall(board, 0);
    }

    void recall(char[][] board, int index) {
        if (index == poss.size()) {
            ans = true;
            return;
        }
        if (ans) return;
        int[] pos = poss.get(index);
        int x = pos[0];
        int y = pos[1];
        for (int i = 0; i < 9; i++) {
            if ((line[x][i] | column[y][i] | block[x / 3][y / 3][i]) == 0) {
                line[x][i] = column[y][i] = block[x / 3][y / 3][i] = 1;
                board[x][y] = (char) (i + 49);
                recall(board, index + 1);
                board[x][y] = '.';
                line[x][i] = column[y][i] = block[x / 3][y / 3][i] = 0;
            }
        }
    }

}
