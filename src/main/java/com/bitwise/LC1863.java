package com.bitwise;

public class LC1863 {

    int totalSum = 0;
    public static void main(String[] args) {
       int arr[] = {5,1,6};
       LC1863 xorSum = new LC1863();
       int totalSum = xorSum.subsetXORSum(arr);
        System.out.println(totalSum);
    }

    public int subsetXORSum(int[] nums) {
       getXorSum(nums, 0, 0);
       return totalSum;
    }

    private void getXorSum(int[] nums, int currentSum, int index) {
        totalSum+=currentSum;

        for(int i=index;i<nums.length;i++){
            currentSum=currentSum^nums[i];
            getXorSum(nums,currentSum,i+1);
            currentSum=currentSum^nums[i];
        }
    }
}
