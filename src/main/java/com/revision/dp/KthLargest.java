package com.revision.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargest {

    public static void main(String[] args) {
        int[] nums = {4, 5, 8, 2};
        int k =3;
        KthLargest kthLargest = new KthLargest(k, nums);
        System.out.println(kthLargest.add(3));
    }

    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    int k;
    public KthLargest(int k, int[] nums) {
       this.k = k;
       for(int i=0;i<nums.length;i++){
           pq.offer(nums[i]);
       }
    }

    public int add(int val) {
      pq.add(val);
      List<Integer> lst = new ArrayList<>();
      while(pq.size()>k){
          lst.add(pq.poll());
      }

      int kthLargest = pq.peek();
      pq.addAll(lst);
      return kthLargest;
    }
}
