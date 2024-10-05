package com.array;

public class LC53MaxSubarray {

    public static void main(String[] args) {
      int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
      LC53MaxSubarray maxSubarray = new LC53MaxSubarray();
      int sum = maxSubarray.maxSubArray(nums);
        System.out.println(sum);
    }

    public int maxSubArray(int[] nums) {
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;

        for(int i=0;i<nums.length;i++){
            max_ending_here = nums[i]+max_ending_here;
            if(nums[i]>max_ending_here){
                max_ending_here=nums[i];
            }
            if(max_ending_here<0){
                max_ending_here=0;
            }
            max_so_far=Integer.max(max_so_far,max_ending_here);

        }
        return max_so_far;
    }
}
