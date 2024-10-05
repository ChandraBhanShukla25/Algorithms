package com.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC539 {

    public static void main(String[] args) {
       String[] timePoints = {"05:31","22:08","00:35"};
       LC539 lc539 = new LC539();
       int diff = lc539.findMinDifference(timePoints);
        System.out.println(diff);
    }


    public int findMinDifference(String[] timePoints) {

        List<Integer> durations = convertToMinutes( timePoints);
        Collections.sort(durations);
        System.out.println(durations);
        int  minDiff = Integer.MAX_VALUE;
        for(int i=0;i<durations.size()-1;i++){
            minDiff = Integer.min(minDiff,durations.get(i+1)-durations.get(i));
        }

        return minDiff;
    }

    private List<Integer> convertToMinutes(String[] timePoints) {
        List<Integer> durationList = new ArrayList<>();
        for(String s: timePoints){
            String[] point = s.split(":");
            int duration1 = Integer.parseInt(point[0])*60+Integer.parseInt(point[1]);
            int duration2 = (Integer.parseInt(point[0])+24)*60+Integer.parseInt(point[1]);
            durationList.add(duration1);
            durationList.add(duration2);
        }
        return durationList;
    }
}
