package com.new21point;

public class New21Point {
    public double new21Game(int N, int K, int W) {
        /*最多抽取k此*/
        int minCount = K%W==0?K/W:K/W+1;

            return minCount;
    }
}
