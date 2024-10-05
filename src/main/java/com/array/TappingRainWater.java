package com.array;

public class TappingRainWater {

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height1 = {4,2,0,3,2,5};
        TappingRainWater tappingRainWater = new TappingRainWater();
        int max= tappingRainWater.trap(height);
        int max1= tappingRainWater.trap(height1);
        System.out.println(max);
        System.out.println(max1);
    }

    public int trap(int[] height) {
      int max = 0;
      int n = height.length;
      for(int i=0;i<n;i++){
          int leftMax = height[i];
          for(int j=0;j<i;j++){
              leftMax = Integer.max(leftMax, height[j]);
          }
          int rightMax = height[i];
          for(int j=i;j<n;j++){
              rightMax = Integer.max(rightMax,height[j]);
          }

          max = max+ Integer.min(leftMax,rightMax)-height[i];
      }
      return max;
    }
}
