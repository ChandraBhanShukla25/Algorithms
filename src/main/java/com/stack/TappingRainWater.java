package com.stack;

public class TappingRainWater {

    public static void main(String[] args) {
        int[] height= {0,1,0,2,1,0,1,3,2,1,2,1};
        
        int tap = findMax(height);
        System.out.println(tap);
    }

    private static int findMax(int[] height) {
        int n = height.length;
        int[] suffix = new int[n];
        int[] prefix = new int[n];
        prefix[0]=height[0];
        suffix[n-1]=height[n-1];
        int tapWater = 0;

        for(int i=1;i<n;i++){
            prefix[i]= Integer.max(height[i],prefix[i-1]);
        }

        for(int i=n-2;i>=0;i--){
            suffix[i]= Integer.max(suffix[i+1],height[i]);
        }

        for(int i=0;i<height.length;i++){
            tapWater+= Integer.min(suffix[i],prefix[i])-height[i];
        }

        return tapWater;
    }
}
