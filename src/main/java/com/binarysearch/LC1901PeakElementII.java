package com.binarysearch;

public class LC1901PeakElementII {

    public static void main(String[] args) {
      int[][] matrix = {{41,8,2,48,18},
                        {16,15,9,7,44},
                        {48,35,6,38,28},
                        {3,2,14,15,33},
                        {39,36,13,46,42}};
      LC1901PeakElementII peakElementII = new LC1901PeakElementII();
      int[] arr = peakElementII.findPeakGrid(matrix);

      for(int i=0;i<arr.length;i++){
           System.out.println(arr[i]);
      }
    }


    public int[] findPeakGrid(int[][] mat) {

        int n = mat[0].length;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = (low+high)/2;
            int maxElementRow = getMaxElementRow(mat, mid);
            int leftColVal = mid-1>=0 ? mat[maxElementRow][mid-1] : -1;
            int rightColVal = mid+1<n ? mat[maxElementRow][mid+1] : -1;
            if(mat[maxElementRow][mid]>leftColVal && mat[maxElementRow][mid]>rightColVal){
                return new int[] {maxElementRow, mid};
            }
            if(mat[maxElementRow][mid] < leftColVal){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return new int[] {-1,-1};

    }

    private int getMaxElementRow(int[][] arr, int mid) {
        int maxElement = 0;
        int maxIndex = 0;

        for(int i=0;i<arr.length;i++){
            if(maxElement<arr[i][mid]){
                maxElement=arr[i][mid];
                maxIndex=i;
            }
        }
       return maxIndex;
    }
}
