package com.array;

import java.util.*;

public class FourSumLC18 {

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;

        int[] nums1 = {2,2,2,2,2}; int target1 = 8;
        FourSumLC18 fourSum = new FourSumLC18();
        List<List<Integer>> lst = fourSum.fourSum(nums, target);
        System.out.println(lst);

        List<List<Integer>> lst1 = fourSum.fourSum(nums1, target1);
        System.out.println(lst1);
    }

    static class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        Map<Integer, Pair > map = new HashMap<>();
        int n = nums.length;
        List<List<Integer>> lst = new ArrayList<>();
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int sum = nums[i]+nums[j];
                Pair pair = new Pair(i,j);
                map.put(sum, pair);
            }
        }

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int sum = nums[i]+nums[j];
                if(map.containsKey(target-sum)){
                    Pair pair = map.get(target-sum);
                    if(i!= pair.first && i!=pair.second && j!=pair.first && j!=pair.second){
                        lst.add(Arrays.asList(nums[pair.first], nums[pair.second], nums[i], nums[j]));
                    }
                }
            }
        }
        return lst;
    }
}
