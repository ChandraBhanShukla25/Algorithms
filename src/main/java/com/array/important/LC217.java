package com.array.important;

public class LC217 {

    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        LC217 lc217 = new LC217();
        boolean hasDuplicate = lc217.containsDuplicate(nums);
        System.out.println(hasDuplicate);
    }

    public boolean containsDuplicate(int[] nums) {
        int i=0;
        while(true){
            i=Math.abs(nums[i]);
            if(nums[i]<0) return true;
            nums[i]=-1*nums[i];
        }
    }

}
