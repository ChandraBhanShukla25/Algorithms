package com.array;

import java.sql.ClientInfoStatus;
import java.util.*;

public class IntersectionOfArray {

    public static void main(String[] args) {
        int [] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};

        IntersectionOfArray intersect = new IntersectionOfArray();
        int[] res = intersect.interseaction(nums1,nums2);
    }

    private int[] interseaction(int[] nums1, int[] nums2) {
        Set<Integer> hashSet = new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            hashSet.add(nums1[i]);
        }
        List<Integer> lst = new ArrayList<>();
        for(int i=0;i<nums2.length;i++){
            if(hashSet.contains(nums2[i]) && !lst.contains(nums2[i])){
                lst.add(nums2[i]);
            }
        }
        return  lst.stream().mapToInt(Integer::intValue).toArray();
    }
}
