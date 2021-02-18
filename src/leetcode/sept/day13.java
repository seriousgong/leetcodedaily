package leetcode.sept;

public class day13 {
    public static void main(String[] args) {
        day13 a = new day13();
//        System.out.println(a.exist(new char[][]{new char[]{'a', 'b'}, new char[]{'c', 'd'}}, "cdba"));
//        System.out.println(a.exist(new char[][]{new char[]{'C', 'A', 'A'}, new char[]{'A', 'A', 'A'}, new char[]{'B', 'C', 'D'}}, "AAB"));
        System.out.println(a.exist(new char[][]{new char[]{'A', 'B', 'C', 'E'}, new char[]{'S', 'F', 'E', 'S'}, new char[]{'A', 'D', 'E', 'E'}}, "ABCESEEEFS"));
    }

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return true;
        if (board == null || board.length == 0) return false;
        n1 = board.length;
        n2 = board[0].length;
        isVisit = new boolean[n1][n2];
        boolean ans = false;
        for (int i = 0; i < board.length; i++) {
            for (int i1 = 0; i1 < board[i].length; i1++) {
                if (board[i][i1] == word.charAt(0)) {
                    ans |= recall(board, i, i1, word, 0);
                }
            }
        }
        return ans;
    }

    int n1;
    int n2;
    boolean[][] isVisit;

    private boolean recall(char[][] board, int x, int y, String word, int index) {
        if (index >= word.length() - 1) {
            return true;
        }
        if (isVisit[x][y]) return true;
        if (board[x][y] == word.charAt(index)) {
            isVisit[x][y] = true;
            boolean flag = false;
            if (y + 1 < n2) flag |= recall(board, x, y + 1, word, index + 1);
            if (y - 1 >= 0) flag |= recall(board, x, y - 1, word, index + 1);
            if (x - 1 >= 0) flag |= recall(board, x - 1, y, word, index + 1);
            if (x + 1 < n1) flag |= recall(board, x + 1, y, word, index + 1);
            isVisit[x][y] = false;
            return flag;
        }
        return false;
    }
}
