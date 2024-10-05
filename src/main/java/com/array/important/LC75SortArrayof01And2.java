package com.array.important;

import java.util.Arrays;

public class LC75SortArrayof01And2 {

    public static void main(String[] args) {
       int[] nums = {2,0,2,1,1,0};
       LC75SortArrayof01And2 sortArrayof01And2 = new LC75SortArrayof01And2();
       sortArrayof01And2.sortColors(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    public void sortColors(int[] nums) {
        if(nums.length==0)
            return;
        int mid=0;
        int low = 0;
        int high = nums.length-1;

        while(mid<=high){
            if(nums[mid]==0){
                swap(mid,low,nums);
                low++;
                mid++;
            } else if(nums[mid]==2){
                swap(mid, high, nums);
                high--;
            }
            else {mid++;}
        }

    }

    public void swap(int mid, int high, int[] arr){
        int temp = arr[mid];
        arr[mid]=arr[high];
        arr[high]=temp;
    }
}
