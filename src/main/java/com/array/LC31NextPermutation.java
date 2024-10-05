package com.array;

import java.util.Arrays;

public class LC31NextPermutation {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        LC31NextPermutation nextPermutation = new LC31NextPermutation();
        nextPermutation.nextPermutation(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;
        for(int i=n-2;i>=0;i--){
            if(nums[i+1]>nums[i]){
                index = i;
                break;
            }
        }
        if(index==-1){
            reverseArr(nums, 0, n-1);
            return;
        }


        for(int i=n-1;i>index;i--){
            if(nums[i]>nums[index]){
               swap(nums, i, index);
               break;
            }
        }

        reverseArr(nums, index+1, nums.length-1);
    }

    public void reverseArr(int[] arr, int start, int end){
        while(start<=end){
            int temp = arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }

    public void swap(int[] arr, int start, int end){
       int temp = arr[start];
       arr[start]=arr[end];
       arr[end]=temp;
    }
}
