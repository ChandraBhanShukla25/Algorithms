package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class LC2597BeautifulSubsets {

    static List<List<Integer>>  lst = new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = {2,4,6};
        int k =2;
        LC2597BeautifulSubsets beautifulSubsets = new LC2597BeautifulSubsets();
        beautifulSubsets.beautifulSubsets(nums, k);
        System.out.println(lst);
    }

    public int beautifulSubsets(int[] nums, int k) {

       for(int i=0;i<=nums.length; i++){
           getBeautifulSubsets(nums, k, i, new ArrayList<>());
       }
       return lst.size();
    }

    private void getBeautifulSubsets(int[] nums, int k, int index, List<Integer> list) {
        if(list.size()>=index){
            lst.add(new ArrayList<>(list));
            return;
        }
        for(int i = index;i<nums.length;i++){
            if(list.isEmpty() || list.get(list.size()-1)-nums[i]!=k){
                list.add(nums[i]);
                getBeautifulSubsets(nums, k, i+1, list);
                list.remove(list.size()-1);
            }

        }
    }
}
