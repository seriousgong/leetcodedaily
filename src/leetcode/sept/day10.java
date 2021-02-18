package leetcode.sept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class day10 {
    public static void main(String[] args) {
        day10 d = new day10();
        System.out.println(d.combinationSum2(new int[]{5,2,1,1,4,2,1}, 3));
        System.out.println(d.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(d.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        temp = new LinkedList<>();
        if (candidates == null || candidates.length == 0) return ans;
        quickSort(candidates, 0, candidates.length - 1);
        System.out.println(Arrays.toString(candidates));
        recall(candidates, target, 0, 0, 0);
        return ans;
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
            arr[left] = arr[right];
            while (left < right && arr[left] <= standard) {
                left++;
            }
            arr[right]=arr[left];
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

    List<List<Integer>> ans;
    LinkedList<Integer> temp;

    void recall(int[] arr, int target, int index, int sum, int num) {
        if (sum == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        int last = -1;
        for (int i = index; i < arr.length; i++) {
            if (last != -1 && arr[i] == arr[last] || sum + arr[i] > target) {
                continue;
            }
            temp.addLast(arr[i]);
            recall(arr, target, i + 1, sum + arr[i], num + 1);
            temp.removeLast();
            last = i;
        }
    }
}
