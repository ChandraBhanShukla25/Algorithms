package com.array.important;

public class LC287 {

    public int findDuplicateWithNegativeMarking(int[] nums) {
        int i=0;
        while(true){
            i = Math.abs(nums[i]);
            if(nums[i]<0) return i;
            nums[i]= nums[i]*-1;
        }
    }

    public int findDuplicateWithHareAndTortoise(int[] nums){
        int slow = nums[0];
        int fast = nums[0];
        do{
            slow =nums[slow];
            fast = nums[nums[fast]];
        } while(fast!=slow);

        int ptr1 = slow;
        int ptr2 = nums[0];
        while(ptr2!=ptr1){
            ptr2=nums[ptr2];
            ptr1 = nums[ptr1];
        }
        return ptr1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        LC287 lc287 = new LC287();
        int num = lc287.findDuplicateWithNegativeMarking(nums);
        System.out.println(num);
    }
}
