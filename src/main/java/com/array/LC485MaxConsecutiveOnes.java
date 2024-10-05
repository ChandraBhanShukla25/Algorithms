package com.array;

public class LC485MaxConsecutiveOnes {

    public static void main(String[] args) {
      int[] nums = {1,1,0,1,1,1};
      LC485MaxConsecutiveOnes maxConsecutiveOnes = new LC485MaxConsecutiveOnes();
      int count = maxConsecutiveOnes.findMaxConsecutiveOnes(nums);
        System.out.println(count);
    }

    public int findMaxConsecutiveOnes(int[] nums) {
      int max=0;
      int currentMax = 0;
      for(int i=0;i<nums.length;i++){
          if(nums[i]==0) {
              currentMax=0;
              continue;
          }
          currentMax++;
          if (currentMax>max){
              max=currentMax;
          }
      }
      return max;
    }
}
