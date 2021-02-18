package com.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solve {
    public static void main(String[] args) {
        Solve s = new Solve();
//        s.solve(new char[][]{new char[]{'O', 'X', 'O', 'O', 'O', 'X'}, new char[]{'O', 'O', 'X', 'X', 'X', 'O'}, new char[]{'X', 'X', 'X', 'X', 'X', 'O'}, new char[]{'O', 'O', 'O', 'O', 'X', 'X'}, new char[]{'X', 'X', 'O', 'O', 'X', 'O'}, new char[]{'O', 'O', 'X', 'X', 'X', 'X'}});
//        s.solve(new char[][]{new char[]{'X', 'X', 'X', 'X'}, new char[]{'X', 'O', 'O', 'X'}, new char[]{'X', 'X', 'O', 'X'}, new char[]{'X', 'O', 'X', 'X'}});
//        s.solve(new char[][]{new char[]{'X', 'O', 'X', 'O', 'X', 'O'}, new char[]{'O', 'X', 'O', 'X', 'O', 'X'}, new char[]{'X', 'O', 'X', 'O', 'X', 'O'}, new char[]{'O', 'X', 'O', 'X', 'O', 'X'}});
        s.solve(new char[][]{new char[]{'O', 'O', 'O', 'O', 'X', 'X'}, new char[]{'O', 'O', 'O', 'O', 'O', 'O'}, new char[]{'O', 'X', 'O', 'X', 'O', 'O'}, new char[]{'O', 'X', 'O', 'O', 'X', 'O'}, new char[]{'O', 'X', 'O', 'X', 'O', 'O'}, new char[]{'O', 'X', 'O', 'O', 'O', 'O'}});
//        s.solve(new char[][]{new char[]{'X', 'O', 'X'}, new char[]{'O', 'X', 'O'}, new char[]{'X', 'O', 'X'}});
    }

    public void solve(char[][] board) {
        if (board.length > 2) {
            List<int[]> list = new ArrayList<>();
            int width = board[0].length;
            int len = board.length;

            for (int i = 0; i < width; i++) {
                if (board[0][i] == 'O') dfs(board, 0, i);
                if (board[len - 1][i] == 'O') dfs(board, len - 1, i);

            }


            for (int i = 0; i < board.length; i++) {
                if (board[i][0] == 'O') dfs(board, i, 0);
                if (board[i][width - 1] == 'O') dfs(board, i, width - 1);
            }

            for (int i = 0; i < board.length; i++) {
                char[] chars = board[i];
                for (int i1 = 0; i1 < chars.length; i1++) {
                    if (board[i][i1] == '0') {
                        board[i][i1] = 'O';
                    } else if (board[i][i1] == 'O') {
                        board[i][i1] = 'X';
                    }
                }
            }
        }
    }


    void dfs(char[][] board, int x, int y) {
        if (board[x][y] == 'O') {
            board[x][y] = '0';
            if (x - 1 >= 0) dfs(board, x - 1, y);
            if (x + 1 <= board.length - 1) dfs(board, x + 1, y);
            if (y + 1 <= board[0].length - 1) dfs(board, x, y + 1);
            if (y - 1 >= 0) dfs(board, x, y - 1);
        }

    }
}

