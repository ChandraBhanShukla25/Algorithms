package com.backtracking;

public class SumEqualsTarget {

    public static void main(String[] args) {
       int[] nums = {1,1,1,1,1};
       int target = 3;
       SumEqualsTarget sumEqualsTarget = new SumEqualsTarget();

        System.out.println(sumEqualsTarget.findTargetSumWays(nums,target));
    }

    public int findTargetSumWays(int[] nums, int target) {
        return findTargetWays(nums, target, nums.length-1, 0);
    }

    private int findTargetWays(int[] nums, int target, int n, int sum) {
        if(n<0){
            if(target==sum) return 1;
            else return 0;
        }

        int x= findTargetWays(nums, target-nums[n], n-1,sum);
        int y = findTargetWays(nums, target+nums[n], n-1,sum);
        return x+y;
    }
}
