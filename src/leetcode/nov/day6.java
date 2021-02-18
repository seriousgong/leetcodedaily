package leetcode.nov;


import java.util.Arrays;

public class day6 {
    public static void main(String[] args) {
        day6 day6 = new day6();
        System.out.println(Arrays.toString(day6.sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8})));
    }

    public int[] sortByBits(int[] arr) {

        int[][] n = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            n[i][1] = arr[i];
            n[i][0] = conversion(arr[i]);
        }
        System.out.println();
        System.out.println();
        quickSort(n, 0, n.length - 1);
        sort(n);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = n[i][1];
        }
        for (int[] ints : n) {
            System.out.println(ints[0] + "," + ints[1] + ",");
        }
        return arr;
    }

    private void sort(int[][] n) {
        for (int i = 0; i < n.length - 1; i++) {
            int[] arr1 = n[i];
            int[] arr2 = n[i + 1];
            if (arr1[0] == arr2[0] && arr1[1] > arr2[1]) {
                int temp = arr1[1];
                arr1[1] = arr2[1];
                arr2[1] = temp;
            }
        }
    }

    private int conversion(int i) {
        int count = 0;
        while (i != 0) {
            if (i % 2 != 0) {
                i--;
                count++;
            }
            i >>= 1;
        }
        return count;
    }

    private void quickSort(int[][] arr, int start, int end) {
        if (start > end || start < 0 || end >= arr.length) return;
        int left = start;
        int right = end;
        int[] stand = arr[start];
        while (left < right) {
            while (left < right && (arr[right][0] > stand[0] ||(arr[right][0]==stand[0]&&arr[right][1]>=stand[1]))) {
                right--;
            }
            while (left < right && (arr[left][0] < stand[0] || (arr[left][0] == stand[0] && arr[left][1] <= stand[1]))) {
                left++;
            }

            if (left < right) {
                int[] temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        /*基准数归位*/
        int[] temp = arr[left];
        arr[left] = stand;
        arr[start] = temp;

        quickSort(arr, start, left - 1);
        quickSort(arr, left + 1, end);
    }

}
