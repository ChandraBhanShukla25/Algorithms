package com.binarysearch;

public class LC34FirstAndLastOccurrenceInSortedArray {

    public static void main(String[] args) {
       int[] nums = {5,7,7,8,8,8,8,10};
       int target = 8;
       LC34FirstAndLastOccurrenceInSortedArray lc34 = new LC34FirstAndLastOccurrenceInSortedArray();
       int[] arr = lc34.searchRange(nums,target);
       System.out.println(arr[0] + " -- "+ arr[1]);
    }

    public int[] searchRange(int[] nums, int target) {
      int high = nums.length;
      int low = 0;
      if(nums.length==0){
          return new int[] {-1,-1};
      }
      int floor = getFloor(nums,high, low, target);
      int ceil = getCeil(nums, high, low, target);
      return new int[]{ceil,floor};
    }

    public int getFloor(int[] nums, int high, int low, int target){

        int ans = high;
        int end = high-1;
        int start = low;

        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]<=target){
                ans = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return ans;
    }

    public int getCeil(int[] nums, int high, int low, int target){

        int ans = high;
        int end = high-1;
        int start = low;

        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]>=target){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        System.out.println(ans);
        return ans;
    }
}
