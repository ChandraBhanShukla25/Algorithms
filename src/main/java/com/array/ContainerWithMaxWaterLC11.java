package com.array;

public class ContainerWithMaxWaterLC11 {

    public int maxArea(int[] height) {
      int n = height.length;
      int i=0;
      int j= n-1;
      int maxArea = 0;

      while(i<=j){
         int currentMax = Integer.min(height[i],height[j])* (j-i);
         if(height[i]<height[j]){
             i++;
         }else{
             j--;
         }
         maxArea = Integer.max(maxArea,currentMax);
      }
      return maxArea;
    }

    public static void main(String[] args) {
        int height[] = {1,8,6,2,5,4,8,3,7};
        int[] height1 ={1,1};
        ContainerWithMaxWaterLC11 maxWater = new ContainerWithMaxWaterLC11();
        int result = maxWater.maxArea(height);
        System.out.println(result);
        int result1 = maxWater.maxArea(height1);
        System.out.println(result1);
    }
}
