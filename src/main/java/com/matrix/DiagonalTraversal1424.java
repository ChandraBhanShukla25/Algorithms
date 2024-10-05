package com.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalTraversal1424 {

    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        DiagonalTraversal1424 diagonalTraversal1424 = new DiagonalTraversal1424();
        int[] result = diagonalTraversal1424.findDiagonalOrder(nums);

        Arrays.stream(result).forEach(System.out::println);
    }


   public int[] findDiagonalOrder(int[][] nums) {

       List<Integer> lst = new ArrayList<>();
       for(int i=0;i<nums.length;i++){
           int j=0;
           int row = i;
           while(row>=0 && j>=0 && j<nums[row].length){
               lst.add(nums[row][j]);
               j++;
               row--;
           }
       }
       return lst.stream()
               .mapToInt(Integer::intValue)
               .toArray();
   }


}
