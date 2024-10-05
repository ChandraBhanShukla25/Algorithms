package com.practice.dp;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement {

    public static void main(String[] args) {
      int[] nums = {2,2,1,3};
        List<Integer> result = majorityElement(nums);
        System.out.println(result);
    }


    public static List<Integer> majorityElement(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MIN_VALUE;
        int count1 = 0;
        int count2 = 0;
        List<Integer> lst = new ArrayList<>();

        for(int x: nums){
            if(first == x){
                count1++;
            }else if(second==x){
                count2++;
            } else if(count1==0){
                first=x;
                count1=1;
            } else if(count2==0){
                second=x;
                count2=1;
            }else{
                count1--;
                count2--;
            }
        }
        System.out.println(first);
        System.out.println(first);

        count1 = 0;
        count2 = 0;
        for(int i=0;i<nums.length;i++){
            if(first==nums[i]){
                count1++;
            }
            else if(second==nums[i]){
                count2++;
            }
        }
        if(count1>nums.length/3){
            lst.add(first);
        }
        if(count2>nums.length/3){
            lst.add(second);
        }

        return lst;
    }


}
