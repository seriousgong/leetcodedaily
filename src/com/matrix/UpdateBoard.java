package com.matrix;

public class UpdateBoard {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'X' || board[x][y] == 'B') return board;
        else if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        ans = board;
        isVisit = new int[board.length][board[0].length];
        bfs(x, y);
        return board;
    }

    int[][] isVisit;
    char[][] ans;

    void bfs(int x, int y) {
        if (x < 0 || x >= ans.length || y < 0 || y >= ans[0].length || isVisit[x][y] == 1) return;
        if (ans[x][y] == 'E') {
            isVisit[x][y] = 1;
//            int count = bombNums(x, y);
            int count = 0;
            if (x - 1 >= 0 && ans[x - 1][y] == 'M') {
                count++;
            }
            if (x + 1 <= ans.length - 1 && ans[x + 1][y] == 'M') {
                count++;
            }
            if (y - 1 >= 0 && ans[x][y - 1] == 'M') {
                count++;
            }
            if (y + 1 <= ans[0].length - 1 && ans[x][y + 1] == 'M') {
                count++;
            }
            if (x - 1 >= 0 && y - 1 >= 0 && ans[x - 1][y - 1] == 'M') count++;
            if (x - 1 >= 0 && y + 1 <= ans[0].length - 1 && ans[x - 1][y + 1] == 'M') count++;
            if (x + 1 <= ans.length - 1 && y + 1 <= ans[0].length - 1 && ans[x + 1][y + 1] == 'M') count++;
            if (x + 1 <= ans.length - 1 && y - 1 >= 0 && ans[x + 1][y - 1] == 'M') count++;
            if (count == 0) {
                /*不与炸弹相邻的空地标记为E*/
                ans[x][y] = 'B';
                /*标记所有与空地相邻的不为炸弹的空地*/
                bfs(x - 1, y);
                bfs(x + 1, y);
                bfs(x + 1, y + 1);
                bfs(x + 1, y - 1);
                bfs(x - 1, y - 1);
                bfs(x - 1, y + 1);
                bfs(x, y + 1);
                bfs(x, y - 1);
            } else {
                ans[x][y] = (char) (count + 48);
            }
        }
    }

    private int bombNums(int x, int y) {
        int count = 0;
        if (x - 1 >= 0 && ans[x - 1][y] == 'M') {
            count++;
        }
        if (x + 1 <= ans.length - 1 && ans[x + 1][y] == 'M') {
            count++;
        }
        if (y - 1 >= 0 && ans[x][y - 1] == 'M') {
            count++;
        }
        if (y + 1 <= ans[0].length - 1 && ans[x][y + 1] == 'M') {
            count++;
        }
        if (x - 1 >= 0 && y - 1 >= 0 && ans[x - 1][y - 1] == 'M') count++;
        if (x - 1 >= 0 && y + 1 <= ans[0].length - 1 && ans[x - 1][y + 1] == 'M') count++;
        if (x + 1 <= ans.length - 1 && y + 1 <= ans[0].length - 1 && ans[x + 1][y + 1] == 'M') count++;
        if (x + 1 <= ans.length - 1 && y - 1 >= 0 && ans[x + 1][y - 1] == 'M') count++;
        return count;
    }


}
