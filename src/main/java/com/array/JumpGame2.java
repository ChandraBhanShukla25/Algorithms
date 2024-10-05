package com.array;

import java.util.Arrays;

public class JumpGame2 {

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        JumpGame2 jumpGame2 = new JumpGame2();
        int x = jumpGame2.jump(nums);
        System.out.println(x);
    }

    public int jump(int[] nums) {

        int minJump =calculateJump(nums, 0);
        return minJump;
    }

    private int calculateJump(int[] nums, int index) {
        int jumps = 0, currentJumpEnd = 0, farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentJumpEnd) {
                jumps++;
                currentJumpEnd = farthest;
            }
        }
        return jumps;
    }
}
