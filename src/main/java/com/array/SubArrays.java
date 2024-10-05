package com.array;

public class SubArrays {


    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0};
        int[] arr1 = {1,0,1,0,1};
        int goal = 0;
        SubArrays subArrays = new SubArrays();
        int count1 = subArrays.numSubarraysWithSum(arr, goal);
        int count = subArrays.numSubarraysWithSum(arr1, 2);
        System.out.println(count);
        System.out.println(count1);
    }

    int numSubarraysWithSum(int[] nums, int goal){

      int count =0;

      for(int i=0;i<nums.length;i++){
          int sum = 0;
          for(int j=0;j<nums.length;j++){
              if(sum+nums[j]==goal){
                  count = count+1;
              }
          }
      }
      return count;
    }

}
