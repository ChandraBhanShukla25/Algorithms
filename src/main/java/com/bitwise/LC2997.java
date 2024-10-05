package com.bitwise;

public class LC2997 {

    public static void main(String[] args) {
        int [] nums = {2,1,3,4};
        int k = 1;
        LC2997 lc2997 = new LC2997();
        int x= lc2997.minOperations(nums,k);
        System.out.println(x);
    }

    public int minOperations(int[] nums, int k) {
        for(int i: nums){
            k^=i;
        }
       return Integer.bitCount(k);

    }
}
