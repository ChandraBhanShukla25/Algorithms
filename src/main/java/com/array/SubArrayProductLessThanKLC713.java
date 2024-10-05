package com.array;

public class SubArrayProductLessThanKLC713 {


    public static void main(String[] args) {
        int[] nums  = {10,5,2,6};
        int k=100;
        int[] nums1 = {1,2,3};
        int k1=0;
        SubArrayProductLessThanKLC713 productLessThanKLC713 = new SubArrayProductLessThanKLC713();
        int x = productLessThanKLC713.numSubarrayProductLessThanK(nums,k);
        int y = productLessThanKLC713.numSubarrayProductLessThanK(nums1,k1);
        System.out.println(x);
        System.out.println(y);

    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
      if(k<=1){
          return 0;
      }
      int prod = 1;
      int count =0;
      int left = 0;
      int i = 0;

      while(i<nums.length){
          prod = prod*nums[i];
          while(prod>=k){
              prod = prod/nums[left++];
          }
         count+=i-left+1;
          i++;

    }
        return count;
    }
}
