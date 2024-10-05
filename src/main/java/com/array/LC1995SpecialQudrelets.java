package com.array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LC1995SpecialQudrelets {

    public static void main(String[] args) {
       int nums[] = {1,2,3,6};
       LC1995SpecialQudrelets qudrelets = new LC1995SpecialQudrelets();
       int x = qudrelets.countQuadruplets(nums);
        System.out.println(x);
    }

    public int countQuadruplets(int[] nums) {
        int sum = IntStream.of(nums).sum();
        System.out.println(sum);
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(sum-nums[i]==nums[i]){
                count++;
            }
        }
        return count;
    }
}
