package com.array;

public class MedianOfSortedArraysLC4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int totalLength =  nums1.length+nums2.length;
      double sum = 0.0;
      int mid = totalLength/2;
      if(mid <= nums1.length && mid+1 <=nums1.length-1){
          sum = nums1[mid]+ nums1[mid +1];
      }else if(mid > nums1.length-1 && mid/2+1 > nums1.length-1) {
          sum = nums2[mid-(nums1.length)]+ nums2[mid-(nums1.length) +1 ];
      } else{
          sum = nums1[nums1.length-1] + nums2[0];
      }
      return sum/2;
    }

    public static void main(String[] args) {
       int[] nums1 = {1,3};
       int[] nums2 = {2};

       int[] nums3 = {1,2};
       int[] nums4 = {3,4};

       MedianOfSortedArraysLC4 median = new MedianOfSortedArraysLC4();
      // double sum = median.findMedianSortedArrays(nums1,nums2);
       double sum1 = median.findMedianSortedArrays(nums3,nums4);
       //System.out.println(sum);
       System.out.println(sum1);
    }
}
