package com.array;

import java.util.ArrayList;
import java.util.List;

public class LC229MajorityElement {

    public static void main(String[] args) {
      int arr[] ={3,2,3};
      LC229MajorityElement majorityElement = new LC229MajorityElement();
        List<Integer> res = majorityElement.majorityElement(arr);
        System.out.println(res);
    }

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int first =0;
        int second=0;
        int firstCount =0;
        int secondCount = 0;

        for(int i:nums){
            if(i==first) {
                firstCount++;
            }else if(i==second) {
                    secondCount++;
            }else if(firstCount==0){
                firstCount=1;
                first=i;
            }else if(secondCount==0){
                secondCount=1;
                second=i;
            }else{
                firstCount--;
                secondCount--;
            }
        }

         firstCount =0;
         secondCount = 0;

        for(int i:nums){
            if(i==first){
                firstCount++;
            }
            if(i==second){
                secondCount++;
            }
        }

        if(firstCount>nums.length/3){
            res.add(first);
        }
        if(secondCount>nums.length/3){
            res.add(second);
        }
      return res;
    }
}
