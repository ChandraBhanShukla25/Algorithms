package com.slidingwindow;

public class MaximumPointsLC1423 {


    public static void main(String[] args) {
       int[] cardPoints = {1,2,3,4,5,6,1};
       int k = 3;

       MaximumPointsLC1423 maximum = new MaximumPointsLC1423();
       int maxScore = maximum.maxScore(cardPoints, k);
       System.out.println(maxScore);
    }

    public int maxScore(int[] cardPoints, int max) {
       int maxSum = 0;
       int sum  = 0;
       int low = 0;
       int high = cardPoints.length-1;

       for(low=0;low<max;low++){
           sum = sum+ cardPoints[low];
       }
       maxSum = Integer.max(maxSum,sum);
       low= low-1;
       while(low >= 0){
         sum = sum-cardPoints[low];
         sum = sum+cardPoints[high];
         maxSum =Integer.max(maxSum,sum);
         low--;
         high--;
       }
       return maxSum;
    }
}
