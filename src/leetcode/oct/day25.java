package leetcode.oct;

public class day25 {
    public int longestMountain(int[] A) {
        int ans = 0;
        int index = 0;
        while (index < A.length) {
            while (index <= A.length - 1 && A[index] >= A[index + 1]) {
                index++;
            }
            int count = 0;
            while (index < A.length - 1 && A[index] < A[index + 1]) {
                count++;
                index++;
            }
            if(index == A.length - 1){
                break;
            }
            if (A[index] == A[index + 1]) {
                continue;
            }
            while (index <= A.length - 1 && A[index] < A[index + 1]) {
                count++;
                index++;
            }
            if (A[index] == A[index + 1]) {
                ans = Math.max(count, ans);
            }
        }
        return ans;
    }
}
