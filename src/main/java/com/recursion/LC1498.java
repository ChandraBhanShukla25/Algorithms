package com.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC1498 {

    public static void main(String[] args) {
       int[] nums = {3,5,6,7};
        //int[] nums = {2,3,3,4,6,7};
        //int[] nums = {1,6,7};
        int target = 9;
        LC1498 lc = new LC1498();
        int x = lc.numSubseq(nums,target);
        System.out.println(x);
    }

    public int numSubseq(int[] nums, int target) {
        int sum = 0;
        List<Integer> result = new ArrayList<>();
        return getAllSubsequnece(nums, target, 0, result);
    }




//    private int getSubsequnece(int[] nums, int i, int target, int sum) {
//        if(i==nums.length){
//            if(sum<=target){
//                return 1;
//            }
//            else return 0;
//        }
//
//        return getSubsequnece(nums,i+1, target,sum+nums[i]) + getSubsequnece(nums,i+1,target,sum);
//    }

   public int getAllSubsequnece(int[] nums, int target, int i, List<Integer> result){
        if(i>=nums.length){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            if(!result.isEmpty()) {
                min = Collections.min(result);
                max = Collections.max(result);
                if (target >= min + max) {
                    return 1;
                }
            }
            //}
            return 0;
        }
       // sum+=nums[i];
        result.add(nums[i]);//2
        int x = getAllSubsequnece(nums, target,i+1, result);
        result.remove(result.size()-1);
       // sum-=nums[i];
        int y= getAllSubsequnece(nums, target, i+1, result);
        return x +y;
    }

}
