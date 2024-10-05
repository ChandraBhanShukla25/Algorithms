package com.numbers;

public class FirstMissingPositiveLC41 {

    public int firstMissingPositive(int[] nums) {
      int n = nums.length;

      for(int i=0;i<nums.length;i++){
          while(nums[i]>0 &&  nums[i]<n+1 && nums[i]!=nums[nums[i]-1]){
              swap(nums, i, nums[i]-1);
          }
      }

      for(int i=0;i<nums.length;i++){
          if(nums[i]!=i+1){
              return i+1;
          }
      }
      return n+1;
    }

    public void swap(int[] nums, int idx, int ldx){
        int x = nums[idx];
        nums[idx] = nums[ldx];
        nums[ldx]= x;
    }

    public static void main(String[] args) {
        int[] num1 = {7,8,9,11,12};
        int[] num2 = {1,2,0};
        FirstMissingPositiveLC41 lc41 = new FirstMissingPositiveLC41();
        int result1 = lc41.firstMissingPositive(num1);
        int result2 = lc41.firstMissingPositive(num2);
        System.out.println(result1);
        System.out.println(result2);

    }
}
