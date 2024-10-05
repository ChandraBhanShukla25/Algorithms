package com.recursion;

public class CheckSubsequnceWithSumK {

    public static void main(String[] args) {
        int[] nums = {3,5,6,7,2};
        int target = 17;
        CheckSubsequnceWithSumK lc = new CheckSubsequnceWithSumK();
        boolean contains = lc.numSubseq(nums,target, 0, 0);
        System.out.println(contains);
    }

    private boolean numSubseq(int[] nums, int target, int idx, int sum) {
        if(idx>=nums.length){
           if(sum==target)
               return true;
           else
               return false;
        }
        sum=sum+nums[idx];
        if(numSubseq(nums, target, idx + 1, sum))
            return true;
        sum=sum-nums[idx];
        if(numSubseq(nums,target,idx+1,sum))
            return true;
        return false;
    }
}
