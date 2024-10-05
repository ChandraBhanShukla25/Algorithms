package com.array;

import java.util.Arrays;

public class LC1552MagneticForce {

    public static void main(String[] args) {
       int[] position = {1,2,3,4,7}; int m = 3;
        LC1552MagneticForce magneticForce = new LC1552MagneticForce();
        int maxDistBruteForce = magneticForce.maxDistanceBruteForce(position, m);
        int maxDist = magneticForce.maxDistance(position, m);
        System.out.println(maxDistBruteForce);
        System.out.println(maxDist);
    }

    public int maxDistanceBruteForce(int[] position, int m) {
        Arrays.sort(position);
        int min = 1;
        int max = position[position.length-1]-position[0];

        for(int i=1;i<=max-min;i++){
            if(!canPlace(position, m, i)){
                return i-1;
            }
        }
        return 0;
    }



    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int low = position[0];
        int high = position[n-1];

        while(low<=high){
            int mid = (low+high)/2;
            if(canPlace(position, m, mid)){
                low = mid+1;
            }else{
                high=mid-1;
            }
        }
        return high;
    }

    public boolean canPlace(int[] position, int m , int dist){
        int last = position[0];
        int totalMagnets = 1;

        for(int i=1;i<position.length;i++){
            if(position[i]-last>=dist){
                totalMagnets++;
                last= position[i];
            }
            if(totalMagnets==m){
                return true;
            }
        }
        return false;
    }
}
