package com.array;

public class ArithmeticSlices {

    public static void main(String[] args) {
      int arr[] ={1,2,3,4};
      int x = numberOfArithmeticSlices(arr);
        System.out.println(x);
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        int count = 0;
        int consecutive = 0;
        int i=2;
        if(nums.length<3){
            return 0;
        }
        while(i<nums.length){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                consecutive++;
                count+=consecutive;
            }else{
                consecutive=0;
            }
            i++;
        }
        return count;
    }
}
