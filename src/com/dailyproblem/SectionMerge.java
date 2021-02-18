package com.dailyproblem;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SectionMerge {
    public static int[][] merge(int[][] intervals) {
        if(intervals.length==0){
            return intervals;
        }
        /*排序*/
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
        /*合并*/
//        int[][] ints = new int[intervals.length][]
        int index=0;
        for (int i = 0; i < intervals.length; i++) {
            if(index==i){
                continue;
            }
            if(intervals[index][1]<intervals[i][0]){
                intervals[++index]=intervals[i];
            }else if (intervals[index][1]>=intervals[i][0]){
                intervals[index][1]=Math.max(intervals[i][1],intervals[index][1]);
            }
        }
        return Arrays.copyOfRange(intervals,0,index+1);
    }


    public static void main(String[] args) {
        int[][][] merge = new int[][][]{
                merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}),
                merge(new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}}),
                merge(new int[][]{{0, 8}, {2, 3}, {1, 5}}),
                merge(new int[][]{{4, 5}, {1, 4}}),
                merge(new int[][]{{4, 5}, {2, 4}, {4, 6}, {3, 4}, {0, 0}, {1, 1}, {3, 5}, {2, 2}}),
                merge(new int[][]{{2, 3}, {4, 6}, {5, 7}, {3, 4}}),
                merge(new int[][]{{3, 3}, {1, 3}, {4, 7}}),
                merge(new int[][]{{2, 3}, {2, 2}, {3, 3}, {1, 3}, {5, 7}, {2, 2}, {4, 6}}),
                merge(new int[][]{{0, 0}, {1, 2}, {5, 5}, {2, 4}, {3, 3}, {5, 6}, {5, 6}, {4, 6}, {0, 0}, {1, 2}, {0, 2}, {4, 5}}),
                merge(new int[][]{{2, 3}, {3, 4}, {5, 5}, {4, 5}, {5, 6}, {2, 3}, {4, 6}, {0, 0}}),
                merge(new int[][]{{4, 4}, {3, 5}, {2, 3}, {1, 1}, {3, 3}, {1, 3}, {2, 2}, {0, 0}, {5, 5}, {0, 0}, {4, 6}}),
                merge(new int[][]{{1, 1}, {2, 2}, {0, 0}, {2, 3}, {1, 3}, {3, 5}, {2, 3}, {3, 5}}),
                merge(new int[][]{{3, 5}, {0, 0}, {4, 4}, {0, 2}, {5, 6}, {4, 5}, {3, 5}, {1, 3}, {4, 6}, {4, 6}, {3, 4}})};
        for (int[][] ints : merge) {
            for (int i = 0; i < ints.length; i++) {
                System.out.print("[" + ints[i][0] + "," + ints[i][1] + "]");
            }
            System.out.println();
        }

    }
}
