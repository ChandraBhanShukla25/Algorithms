package com.stack;

public class LC84 {

    public static void main(String[] args) {
      int[]  heights = {2,4};
      int aread = new LC84().largestRectangleArea(heights);
        System.out.println(aread);
    }
    public int largestRectangleArea(int[] heights) {

        int largestArea = 0;

        int n = heights.length;

        for(int i=0;i<heights.length;i++){

            int leftMax = 0;
            int leftMaxIndex = -1;
            int rightMax = 0;
            int rightMaxIndex = -1;
            int j=i;

            while(j>=0){
                if(heights[j]>leftMax){
                    leftMaxIndex=j;
                    leftMax=heights[j];
                }
                j--;
            }
             j=i;
            while(j<n){
                if(heights[j]>rightMax){
                    rightMaxIndex=j;
                    rightMax=heights[j];
                }
                j++;
            }

            largestArea = Math.max(largestArea,(Math.min(rightMax, leftMax)*Math.abs(rightMaxIndex-leftMaxIndex+1)));
        }
        return largestArea;
    }

}
