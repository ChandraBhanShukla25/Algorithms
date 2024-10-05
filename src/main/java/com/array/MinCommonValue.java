package com.array;

public class MinCommonValue {

    public static void main(String[] args) {
     int nums1[]= {6,13,18,18,28,34,37,39,46,50,52,54,62,63,65,66,75,80,97,98};
     int nums2[] = {10,13,13,19,27,33,40,41,43,46,56,61,69,72,78,79,82,88,91,94};
     MinCommonValue minCommonValue = new MinCommonValue();
     int x = minCommonValue.getCommon(nums1,nums2);
     System.out.print(x);
    }

    public int getCommon(int[] nums1, int[] nums2) {
        int i=0; int j=0;

        while(i< nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                return nums1[i];
            } else if(nums1[i]>nums2[j]){
                j++;
            } else{
                i++;
            }
        }
        return -1;
    }
}
