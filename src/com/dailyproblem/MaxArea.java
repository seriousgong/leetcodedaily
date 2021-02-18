package com.dailyproblem;

public class MaxArea {

    public  static  int maxArea(int[] height) {
        int max  = 0;
//        for (int i = 0; i < height.length-1; i++) {
//            for (int j = i+1; j < height.length; j++) {
//                int area = Math.min(height[j], height[i])*(j-i);
//                max = Math.max(area,max);
//            }
//        }
        int sta=0;
        int end = height.length-1;
        while (sta<end){
            int wide = end-sta;
            int leftHeight = height[sta];
            int rightHeight = height[end];
            max = Math.max(wide*Math.min(leftHeight,rightHeight),max);
            int highDiff = leftHeight - rightHeight;
            if(highDiff<0){
                sta++;
            }else{
                end--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
