package com.matrix;

public class LC861ScoreAfterFlippingMatrix {

//    public static void main(String[] args) {
//      int grid[][]  = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
//      LC861ScoreAfterFlippingMatrix scoreAfterFlippingMatrix = new LC861ScoreAfterFlippingMatrix();
//      scoreAfterFlippingMatrix.matrixScore(grid);
//    }
//
//    public int matrixScore(int[][] grid) {
//       int maxSum = 0;
//       int[] maxRow= new int[grid.length];
//       //row flip
//       for(int i=0;i<grid.length;i++){
//           int[] currentRow = grid[i];
//           int currentRowVal = getCurrentRowVal(currentRow);
//           int flipRowVal = getCurrentRowVal(flip(currentRow));
//           maxRow[i] = Integer.max(currentRowVal,flipRowVal);
//       }
//    }
//
//  //  public int colFlip()
//
//    private int getCurrentRowVal(int[] currentRow) {
//        int val = 0;
//        int power = 0;
//        for(int i=currentRow.length-1;i>=0;i--){
//            if (currentRow[i] == 1) {
//                val += (int) Math.pow(2, power);
//            }
//            power++;
//        }
//        return val;
//    }
//
//    public int[] flip (int[] grid){
//        int arr[] = new int[grid.length];
//      for(int i=0;i<grid.length;i++){
//          if(grid[i]==0){
//              arr[i]=1;
//          }else{
//              arr[i]=0;
//          }
//      }
//      return arr;
//    }
//

}
