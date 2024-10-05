package com.string;

import java.util.*;

public class LC179 {

    public static void main(String[] args) {
        int[] arr = {3,30,34,5,9};
        String str = largestNumber(arr);
        System.out.println(str);
    }
    public static String largestNumber(int[] nums) {
        List<String> lst = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            lst.add(String.valueOf(nums[i]));
        }

        lst.sort((a, b) -> (b + a).compareTo(a + b));
        if(lst.get(0).equals("0")){
            return "0";
        }
        StringBuilder res = new StringBuilder();
        for(int i=0;i<lst.size();i++){
            res.append(lst.get(i));
        }
        return res.toString();
    }
}
