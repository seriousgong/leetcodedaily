package leetcode.exam.huawei;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int x = 0;
        int s = input.nextInt();
        int[] arr = new int[s];
        for (int i = 0; i < s; i++) {
            arr[i] = i;
        }
        int i = 0;
        int count = arr.length;
        int index = 0;
        while (count != 1) {
            if (arr[index % arr.length] == -1) ;
            else {
                i++;
                if (i % 3 == 0 && i != 0) {
                    arr[index % arr.length] = -1;
                    count--;
                }
            }
            index++;
        }
        for (int i1 : arr) {
            if (i1 != -1) {
                System.out.println(i1);
                break;
            }
        }
    }


}
