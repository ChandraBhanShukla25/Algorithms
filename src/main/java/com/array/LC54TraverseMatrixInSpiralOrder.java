package com.array;

import java.util.ArrayList;
import java.util.List;

public class LC54TraverseMatrixInSpiralOrder {
    public static void main(String[] args) {
      int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
      LC54TraverseMatrixInSpiralOrder traverseMatrixInSpiralOrder = new LC54TraverseMatrixInSpiralOrder();
      List<Integer> sprialList = traverseMatrixInSpiralOrder.spiralOrder(matrix);
        System.out.println(sprialList);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
       int left = 0;
       int right =matrix[0].length-1;
       int top=0;
       int bottom = matrix.length-1;
       List<Integer> res = new ArrayList<>();
       int x = 0;
       while(top<=bottom && left<=right){

           if(x==0) {
               // going right
               for (int i = left; i <= right; i++) {
                   res.add(matrix[top][i]);
               }
               top++;
               x=1;
           }

           if(x==1) {
               //go down
               for (int i = top; i <= bottom; i++) {
                   res.add(matrix[i][right]);
               }
               right--;
               x=2;
           }

           if(x==2) {
               //go left
               for (int i = right; i >= left; i--) {
                   res.add(matrix[bottom][i]);
               }
               bottom--;
               x=3;
           }

           if(x==3) {
               //go up
               for (int i = bottom; i >= top; i--) {
                   res.add(matrix[i][left]);
               }
               left++;
               x=0;
           }

       }
       return res;
    }
}
