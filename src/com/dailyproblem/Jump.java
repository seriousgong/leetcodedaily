package com.dailyproblem;

import java.util.HashMap;
import java.util.Stack;

public class Jump {
    public boolean canJump(int[] nums) {

        int maxLength = 0;
        for (int i = nums.length-2; i < nums.length; i--) {
            maxLength = Math.max(maxLength,i+nums[i]);
        }
        return maxLength==0;

    }

    public static void main(String[] args) {
    }


    static class StepMsg {
        boolean canLeft = true;
        StepMsg last = null;

        boolean canRight = true;
        int pos = -1;

        public StepMsg(int pos, StepMsg last) {
            this.pos = pos;
            this.last = last;
        }

        public boolean isCanLeft() {
            return canLeft;
        }


        public boolean isCanRight() {
            return canRight;
        }

        public void setCanRight(boolean canRight) {
            this.canRight = canRight;
        }

        public int getPos() {
            return pos;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }
    }
}
