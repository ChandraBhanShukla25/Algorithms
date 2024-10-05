package com.recursion;

public class PrintSubseqenceWithKSum {

    public static void main(String[] args) {
        int[] nums = {3,5,6,7,2};
        int target = 9;
        PrintSubseqenceWithKSum lc = new PrintSubseqenceWithKSum();
        int count = lc.numSubseq(nums,target);
        System.out.println(count);
    }
    public int numSubseq(int[] nums, int target) {
        int  sum = 0;
        int count= getSubsequnece(nums,0, target, sum);
        return count;
    }
    private int getSubsequnece(int[] nums,int idx, int target, int sum) {
        if(idx==nums.length){
            if(sum<=target){
                return 1;
            }
            return 0;
        }
        sum+=nums[idx];
        int x = getSubsequnece(nums, idx + 1, target, sum);
        sum-=nums[idx];
        int y = getSubsequnece(nums, idx+1, target, sum);
        return x+y;
    }
}
