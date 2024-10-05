package com.array;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArrayLC525 {

    public static void main(String[] args) {
        int[] nums = {0,1,0};
        int[] nums1 = {0,0,0,1,1,1,0};
        ContiguousArrayLC525 contiguousArrayLC525 = new ContiguousArrayLC525();
        int maxLength = contiguousArrayLC525.findMaxLength(nums);
        int maxLength1 = contiguousArrayLC525.findMaxLength(nums1);
        System.out.println(maxLength);
        System.out.println(maxLength1);
    }
    public int findMaxLength(int[] nums) {

      Map<Integer,Integer> map = new HashMap<>();
      map.put(-1,0);
      int sum = 0;
      int maxLength= 0;
      for(int i=0;i<nums.length;i++){
          if(nums[i]==0){
              sum+=-1;
          } else if(nums[i]==1){
              sum+=1;
          }
          if(map.containsKey(sum)){
              int idx = map.get(sum);
              maxLength = Integer.max(maxLength,i-idx);
          }else{
              map.put(sum,i);
          }

      }
        return maxLength;
    }
}
