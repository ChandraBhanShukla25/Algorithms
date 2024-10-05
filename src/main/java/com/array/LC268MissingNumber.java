package com.array;

public class LC268MissingNumber {

    public static void main(String[] args) {
       int[] nums = {0,1};
       LC268MissingNumber missingNumber = new LC268MissingNumber();
       int x = missingNumber.missingNumber(nums);
        System.out.println(x);
    }

    public int missingNumber(int[] nums) {
        int xor1 = 0;
        int xor2 = 0;
       for(int i=0;i<nums.length;i++){
           xor1^= nums[i];
           xor2^=i;
       }
       xor2^=nums.length;
       return xor1^xor2;
    }
}
