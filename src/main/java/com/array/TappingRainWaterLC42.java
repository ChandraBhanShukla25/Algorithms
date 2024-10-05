package com.array;

public class TappingRainWaterLC42 {

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height1 = {4,2,0,3,2,5};
        TappingRainWaterLC42 tappingRainWater = new TappingRainWaterLC42();
        int max= tappingRainWater.trap(height);
        int max1= tappingRainWater.trap(height1);
        System.out.println(max);
        System.out.println(max1);
    }

    public int trap(int[] nums){
        int n = nums.length-1;
        int left = 0;
        int right = n;
        int left_max = 0;
        int right_max = 0;
        int result = 0;
        while(left<=right){

            if(right_max<=left_max){
                result+= Math.max(0,right_max-nums[right]);
                right_max = Math.max(nums[right], right_max);
                right = right-1;
            }else{
                result+= Math.max(0,left_max-nums[left]);
                left_max=Math.max(nums[left],left_max);
                left =left+1;
            }
        }
        return result;
    }
}
