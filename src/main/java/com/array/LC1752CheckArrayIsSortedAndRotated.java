package com.array;

public class LC1752CheckArrayIsSortedAndRotated {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        LC1752CheckArrayIsSortedAndRotated checkSorted = new LC1752CheckArrayIsSortedAndRotated();
        boolean isSorted = checkSorted.check(nums);
        System.out.println(isSorted);
    }

    public boolean check(int[] nums) {
        if(nums.length==0){
            return false;
        }
        int i=0;
        int last = Integer.MIN_VALUE;
        for(i=0;i<nums.length;i++){
            if(nums[i]<last){
                break;
            }
            last = nums[i];
        }
        if(i==nums.length){
            return true;
        }
        if(nums[0]<nums[nums.length-1]){
            return false;
        }
        last = Integer.MIN_VALUE;

        while(i<nums.length){
            if(nums[i]<last){
                return false;
            }
            last = nums[i];
            i++;
        }

        return true;
    }


}
