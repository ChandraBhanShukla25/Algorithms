package com.array;

public class LC136SingleNumber {

    public static void main(String[] args) {
        int[] arr= {4,1,2,1,2};
        LC136SingleNumber singleNumber = new LC136SingleNumber();
        int x = singleNumber.singleNumber(arr);
        System.out.println(x);

    }
    public int singleNumber(int[] nums) {
      int num = 0;
      for(int i=0;i<nums.length;i++){
          num^=nums[i];
      }
      return num;
    }
}
