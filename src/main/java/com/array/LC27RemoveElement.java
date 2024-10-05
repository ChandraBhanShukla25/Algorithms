package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC27RemoveElement {

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        LC27RemoveElement removeElement = new LC27RemoveElement();
        int n = removeElement.removeElement(nums,val);
        Arrays.stream(nums).forEach(System.out::println);
    }
    public int removeElement(int[] nums, int val) {
        List<Integer> lst = new ArrayList<>();
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                lst.add(nums[i]);
                count++;
            }
        }
        for(int i=0;i<lst.size();i++){
            nums[i]=lst.get(i);
        }
        return lst.size()-1;
    }
}
