package leetcode.exam;

import java.util.Arrays;

public class question2 {
    public static void main(String[] args) {
        question2 a = new question2();
        System.out.println(a.breakfastNumber(new int[]{10, 20, 5}, new int[]{5, 5, 2}, 15));
    }

    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int ans = 0;
        int j = drinks.length - 1;
        for (int i = 0; i < staple.length; i++) {
            int count = drinks.length;
            while (j > 0 && drinks[j] + staple[i] > x) {
                count--;
                j--;
            }
            ans += count;
        }
        return ans % 1000000007;
    }

    void quickSort(int[] arr, int start, int end) {
        if (start < 0 || end >= arr.length || start > end) return;
        int left = start;
        int right = end;
        int standard = arr[start];
        while (left < right) {
            while (left < right && arr[right] > standard) {
                right--;
            }
            while (left < right && arr[left] <= standard) {
                left++;
            }
            /*swap*/
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        /*基准数归位*/
        int temp = arr[start];
        arr[start] = arr[left];
        arr[left] = temp;
        quickSort(arr, start, left - 1);
        quickSort(arr, left + 1, end);
    }

    void recall(int[] staple, int[] drinks, int x) {

    }


}
