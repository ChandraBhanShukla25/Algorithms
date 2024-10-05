package com.array;

public class Lc2149ArrangeElementsBySign {

    public static void main(String[] args) {
        int[] nums = {3,1,-2,-5,2,-4};
        Lc2149ArrangeElementsBySign rearrangeElements  = new Lc2149ArrangeElementsBySign();
        rearrangeElements.rearrangeArray(nums);
    }

    public int[] rearrangeArray(int[] nums) {
       int[] arr = new int[nums.length];
       int k = 0;
       for(int i=0;i<nums.length;i++){
           if(nums[i]>0){
               arr[2*k] = nums[i];
               k++;
           }
       }

        k = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                arr[2*k+1] = nums[i];
                k++;
            }
        }

        return arr;
    }
}
