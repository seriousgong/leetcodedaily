package com.matrix;

import java.util.Arrays;

public class FloodFill {
    public static void main(String[] args) {
        FloodFill f = new FloodFill();
        f.floodFill(new int[][]{new int[]{0, 0, 0}, new int[]{0, 1, 1}}, 1, 1, 1);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        standard = image[sr][sc];
        isVisit = new int[image.length][image[0].length];
        this.newColor = newColor;
        dfs(image, sr, sc);
        for (int[] ints : image) {
            System.out.println(Arrays.toString(ints));
        }
        return image;
    }

    int[][] isVisit;
    int standard;
    int newColor;

    void dfs(int[][] image, int x, int y) {
        if (isVisit[x][y] == 0 && image[x][y] == standard) {
            isVisit[x][y] = 1;
            image[x][y] = newColor;
            if (x > 0) dfs(image, x - 1, y);
            if (x < image.length - 1) dfs(image, x + 1, y);
            if (y > 0) dfs(image, x, y - 1);
            if (y < image[0].length - 1) dfs(image, x, y + 1);
        }
    }
}
