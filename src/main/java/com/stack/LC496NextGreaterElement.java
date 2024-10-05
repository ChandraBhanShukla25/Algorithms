package com.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC496NextGreaterElement {

    public static void main(String[] args) {
        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};
        LC496NextGreaterElement nextGreaterElement = new LC496NextGreaterElement();
        int[] nge = nextGreaterElement.nextGreaterElement(nums1, nums2);
        for(int i: nge){
            System.out.println(i);
        }
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
      Map<Integer, Integer> map = new HashMap<>();
      Stack<Integer> stack = new Stack<>();

      int n = nums1.length;
      int[] nge = new int[n];

      for(int i=0;i<nums2.length;i++){
          while(!stack.isEmpty() && stack.peek()< nums2[i]){
              map.put(stack.pop(), nums2[i]);
          }
          stack.push(nums2[i]);
      }

      for(int i=0;i<nums1.length;i++){
          nge[i]= map.getOrDefault(nums1[i],-1);
      }
      return nge;
    }
}
