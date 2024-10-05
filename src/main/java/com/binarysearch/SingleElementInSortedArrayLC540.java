package com.binarysearch;

public class SingleElementInSortedArrayLC540 {

    public static void main(String[] args) {
     int[] nums = {1,1,2,3,3,4,4,8,8};
     SingleElementInSortedArrayLC540 singelElement = new SingleElementInSortedArrayLC540();
     int x = singelElement.singleNonDuplicate(nums);
     System.out.println(x);
    }

    public int singleNonDuplicate(int[] nums) {
        int n = nums.length-1;

        if(n==0){
            return nums[0];
        }

        if(nums[0]!=nums[1]){
            return nums[0];
        }

        if(nums[n]!=nums[n-1]){
            return nums[n];
        }
        int low = 1;
        int high = n-1;

        while(low<=high){
            int mid = (low+high)/2;

            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }
            if((mid%2==0 && nums[mid]==nums[mid+1]) || (mid%2==1 && nums[mid]==nums[mid-1])){
                  low = mid+1;
            }else{
                high = mid-1;
            }
        }
       return -1;
    }
}
