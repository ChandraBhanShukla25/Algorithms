package com.greedy;

import java.util.Arrays;

public class ShortestJobFirst {
    static int solve(int bt[] ) {
        // code here
        if(bt.length==0){
            return 0;
        }
        if(bt.length==1){
            return bt[0];
        }
        Arrays.sort(bt);
        int totalTime = 0;
        int waitTime=0;
        for(int i=0;i<bt.length;i++){
             waitTime = bt[i];
             totalTime+=waitTime;
        }
        return totalTime/(bt.length-1);
    }

    public static void main(String[] args) {
        int[] bt = {4,3,7,1,2};
        System.out.println(solve(bt));
    }
}
