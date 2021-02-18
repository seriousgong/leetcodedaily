package com.dailyproblem;

public class MinCostTickets {
    public static void main(String[] args) {
        System.out.println(mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
    }
    public static int mincostTickets(int[] days, int[] costs) {
    /*days记录的是一年中的哪一天需要旅行票*/
        int tripDays = days.length;
        int cost1 = tripDays;
        int cost7 = 0;
        int cost20 = 0;
        int startTripDay = days[0];
        int endTripDay = days[tripDays -1];
        int daysDiff = endTripDay-startTripDay; //旅行天数最大跨度
        /*假设今年旅行消耗 a 张 1天票  b张 7天票 c 张 20天票 */
        int minCost=tripDays*costs[0];
        int count=0;
//        for (int i = 1; i < tripDays; i++) {
//            if(days[i]-startTripDay>=7){
//                tripDays-(i+1)
//            }
//        }
        return minCost;
    }
}
