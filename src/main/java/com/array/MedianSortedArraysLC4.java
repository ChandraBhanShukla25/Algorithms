package com.array;

import java.util.ArrayList;
import java.util.List;

public class MedianSortedArraysLC4 {

    public static void main(String[] args) {
        int[] nums1 = {1,1,1,1,1,1,1,1,1,1,4,4};
        int[] nums2 = {1,3,4,4,4,4,4,4,4,4,4};

        //[1,2], nums2 = [3,4]
        MedianSortedArraysLC4 sortedMedian = new MedianSortedArraysLC4();
        double median =sortedMedian.median(nums1,nums2);
        System.out.println(median);
    }

    public double median(int[] nums1, int[] nums2){
        List<Integer> mergedList = merge(nums1,nums2);
        if(mergedList.size()%2!=0){
            return mergedList.get((mergedList.size()/2));
        }else{
            int x = mergedList.get(mergedList.size()/2);
            int y = mergedList.get((mergedList.size()/2) -1);
            return (double) (x+y)/2;
        }
    }

    public List<Integer> merge(int[] nums1, int[] nums2){
        int i=0; int j=0;
        List<Integer> lst = new ArrayList<>();
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                lst.add(nums1[i]);
                i++;
            }else if(nums1[i]>nums2[j]){
                lst.add(nums2[j]);
                j++;
            }else{
                lst.add(nums1[i]);
                lst.add(nums2[j]);
                i++;
                j++;
            }
        }

        while(i<nums1.length){
            lst.add(nums1[i]);
            i++;
        }
        while(j<nums2.length){
            lst.add(nums2[j]);
            j++;
        }
        return lst;
    }
}
