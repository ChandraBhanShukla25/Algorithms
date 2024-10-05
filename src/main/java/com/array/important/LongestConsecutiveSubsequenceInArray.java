package com.array.important;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequenceInArray {

    public static void main(String[] args) {
        int arr[] = {100,4,200,1,3,2};
        LongestConsecutiveSubsequenceInArray longest = new LongestConsecutiveSubsequenceInArray();
        int x = longest.longestConsecutive(arr);
        System.out.println(x);
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        if(nums.length==0){
            return 0;
        }
        int count = 1;
        int maxLength = 1;

        for(int i=0;i<nums.length;i++){
            int x = nums[i];
            while(set.contains(x+1)){
                count++;
                x=x+1;
                maxLength = Integer.max(maxLength,count);
            }
            count=1;
        }

        return maxLength;

    }
}
