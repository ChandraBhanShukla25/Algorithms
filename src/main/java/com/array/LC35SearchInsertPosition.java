package com.array;

public class LC35SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
       for(int i=0;i<nums.length;i++){
           if(nums[i]==target){
               return i+1;
           }else if(nums[i]>target){
                   return i+1;
           }
       }

       return nums.length+1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 5;
        LC35SearchInsertPosition position = new LC35SearchInsertPosition();
        int x = position.searchInsert(nums,target);
        System.out.println(x);
    }
}
