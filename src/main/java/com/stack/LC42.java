package com.stack;

public class LC42 {

    public static void main(String[] args) {
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trappedWater = new LC42().trap(heights);
        System.out.println(trappedWater);
        int trappedWater1 = new LC42().trap1(heights);
        System.out.println(trappedWater1);

    }

    public int trap(int[] height) {
        int[] suffix = new int[height.length];
        int[] prefix = new int[height.length];
        int n = height.length;
        prefix[0]=height[0];
        suffix[n-1]=height[n-1];
        int trappedWater = 0;

        for(int i=1;i<height.length;i++){
            prefix[i] = Math.max(height[i], prefix[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            suffix[i]= Math.max(height[i], suffix[i+1]);
        }

        for(int i=0;i<height.length;i++){
            trappedWater+= Math.min(prefix[i],suffix[i])-height[i];
        }
        return trappedWater;
    }

    public int trap1(int[] height) {
        int n = height.length;
        int trappedWater = 0;
        for(int i=0;i<height.length;i++){
            int leftMax = 0;
            int rightMax = 0;
            int j=i;
            while(j>=0){
                leftMax=Integer.max(leftMax,height[j]);
                j--;
            }
            j=i;
            while(j<n){
                rightMax= Integer.max(rightMax,height[j]);
                j++;
            }

            trappedWater+= Integer.min(leftMax,rightMax)-height[i];
        }
        return trappedWater;
    }
}
