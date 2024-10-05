package com.slidingwindow;

public class LC1423MaxCards {

    public static void main(String[] args) {
      int[] cardPoints = {1,2,3,4,5,6,1};
      int k = 3;

      int maxScore = new LC1423MaxCards().maxScore(cardPoints,k);
      System.out.println(maxScore);
    }

    public int maxScore(int[] cardPoints, int k) {
        int maxScore = 0;
        int maxCurrent = 0;
        int j = cardPoints.length - 1;
        int i = 0;
        int n = cardPoints.length;
        for (i = 0; i < k; i++) {
            maxCurrent += cardPoints[i];
            maxScore = Integer.max(maxCurrent, maxScore);
        }
        i=i-1;
        while ( i>= 0 && n - j <= k) {
            maxCurrent -= cardPoints[i];
            i--;
            maxCurrent += cardPoints[j];
            j--;
            maxScore = Integer.max(maxCurrent, maxScore);
        }
        return maxScore;
    }

}
