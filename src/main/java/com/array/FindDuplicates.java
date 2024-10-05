package com.array;

public class FindDuplicates {

    public static void main(String[] args) {
      int[] nums = {1,3,4,2,2};
      FindDuplicates findDuplicates = new FindDuplicates();
      int dupliacteElement = findDuplicates.findDuplicate(nums);
        System.out.println(dupliacteElement);
    }

    public int findDuplicate(int[] nums) {
      int tortoise = nums[0];
      int hare = nums[0];;

      do{
          tortoise = nums[tortoise];
          hare = nums[nums[hare]];
      } while(hare!=tortoise);


      tortoise = nums[0];

      while(tortoise!=hare){
          tortoise = nums[tortoise];
          hare = nums[hare];
      }

      return tortoise;
    }

}
