package com.backtracking;

public class LC2035 {

    public static void main(String[] args) {
        int[] nums = {-36,3};
        LC2035 lc2035 = new LC2035();
        int x = lc2035.minimumDifference(nums);
        System.out.println(x);
    }

    public int minimumDifference(int[] nums) {

        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int prefix =0;
        return Math.abs(minDiff(nums, sum, 0, prefix));

    }

    private int minDiff(int[] nums, int sum, int index, int prefix) {
        if(index==nums.length)
             return Math.abs((sum - prefix)
                - prefix);

        int left = minDiff(nums, sum, index+1, prefix+nums[index]);
        int right = minDiff(nums, sum, index+1, prefix);

        return Math.min(left,right);

    }
}
