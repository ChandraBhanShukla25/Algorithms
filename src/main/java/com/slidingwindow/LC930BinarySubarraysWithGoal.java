package com.slidingwindow;

public class LC930BinarySubarraysWithGoal {

    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0};
        int goal = 0;
        LC930BinarySubarraysWithGoal binarySubarraysWithGoal = new LC930BinarySubarraysWithGoal();
        int x = binarySubarraysWithGoal.numSubarraysWithSum(nums, goal);
        System.out.println(x);
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return findSubarrayWithSumLessThanOrEqualToGoal(nums, goal)-findSubarrayWithSumLessThanOrEqualToGoal(nums, goal-1);
    }

    private int findSubarrayWithSumLessThanOrEqualToGoal(int[] nums, int goal) {
        int sum = 0; int count = 0;
        int j=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            while(j<nums.length && sum>goal){
                sum-=nums[j];
                j++;
            }
            if(i>=j) {
                count += i - j + 1;
            }
        }
        return count;
    }
}
