package com.array;

public class LC26RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        LC26RemoveDuplicatesFromSortedArray removeDuplicates = new LC26RemoveDuplicatesFromSortedArray();
        int length = removeDuplicates.removeDuplicates(nums);
        System.out.println(length);
    }

    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
         int i=1;
         int j=0;
         int n = nums.length;
         while(i<n){
             if(nums[i]==nums[j]){
                 i++;
             }else{
                 ++j;
                 nums[j]=nums[i];
                 i++;
             }
         }
         return j+1;
    }
}
