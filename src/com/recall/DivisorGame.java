package com.recall;

public class DivisorGame {
    public static void main(String[] args) {
        DivisorGame s = new DivisorGame();
//        System.out.println(s.divisorGame(2));
//        System.out.println(s.divisorGame(3));
//        System.out.println(s.divisorGame(4));
        System.out.println(s.divisorGame(5));
    }

    public boolean divisorGame(int N) {
        flag = false;
        recurise(N, 0);
        boolean[] dp = new boolean[N];
        dp[1] = false;
        for (int i = 2; i < N; i++) {

        }
        return flag;
    }

    boolean flag;
    boolean[] dp;

    private void recurise(int N, int count) {
        if (flag) return;
        if (N <= 1) {
            if (count % 2 == 1) flag = true;
            return;
        }
        for (int i = 1; i <= N / 2; i++) {
            if (N % i == 0 && N - i >= 1) {
                recurise(N - i, count + 1);
            }
        }

    }
}
