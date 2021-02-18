package hot100;

public class _461 {
    public int hammingDistance(int x, int y) {
        int res = x ^ y;
        int ans = 0;
        while (res != 0) {
            if (res % 2 == 1) {
                ans++;
            }
            res /= 2;
        }
        return ans;
    }
}
