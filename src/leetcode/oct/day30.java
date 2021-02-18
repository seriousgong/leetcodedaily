package leetcode.oct;

public class day30 {
    public static void main(String[] args) {
        day30 d = new day30();
        System.out.println(d.islandPerimeter(new int[][]{new int[]{0, 1}, new int[]{1, 1}}));
    }

    public int islandPerimeter(int[][] grid) {

        ans = 0;
        if (grid == null || grid.length == 0) return ans;
        column = grid.length;
        row = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            int[] ints = grid[i];
            for (int i1 = 0; i1 < ints.length; i1++) {
                if (grid[i][i1] == 1) {
                    dfs(grid, i, i1);
                    return ans;
                }
            }
        }
        return ans;
    }

    int ans;
    int column;
    int row;

    private void dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= column || y < 0 || y >= row) {
            ans++;
            return;
        }
        if (grid[x][y] == 2) return;
        if (grid[x][y] == 1) {
            grid[x][y] = 2;
            dfs(grid, x - 1, y);
            dfs(grid, x + 1, y);
            dfs(grid, x, y - 1);
            dfs(grid, x, y + 1);
        } else {
            ans++;
        }
    }
}
