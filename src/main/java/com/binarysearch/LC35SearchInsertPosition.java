package com.binarysearch;

public class LC35SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 5;
        LC35SearchInsertPosition lc35 = new LC35SearchInsertPosition();
        int x = lc35.searchInsert(nums,target);
        System.out.println(x);
    }

    public int searchInsert(int[] nums, int target) {
        if(nums.length==0){
          return 0;
        }
       int high = nums.length;
       int low = 0;
       int ans=1000000;
       while(low<high){
           int mid = (low+high)/2;
           if(nums[mid]<=target){
               ans = mid;
               low = mid+1;
           }else{
               high =mid-1;
           }
       }
       if(nums[ans]==target){
           return ans;
       }
       return ans+1;
    }
}
