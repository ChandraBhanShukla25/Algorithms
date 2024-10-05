package com.string.important;

import java.util.ArrayList;
import java.util.List;

public class Lc2147WaysToDivideALongCorrider {

    public static void main(String[] args) {
         Lc2147WaysToDivideALongCorrider numberOfways = new Lc2147WaysToDivideALongCorrider();
         int x = numberOfways.numberOfWays("SSPPSPS");
        System.out.println(x);
    }

    public int numberOfWays(String corridor) {
        if(corridor.isEmpty()){
            return 0;
        }
        long M = 109 + 7;
        List<Integer> seats = new ArrayList<>();// position of seats
        for(int i=0;i<corridor.length();i++){
            if(corridor.charAt(i)=='S'){
                seats.add(i);
            }
        }
        if(seats.size()%2!=0 || seats.isEmpty()){
            return 0;
        }

        long result = 1;
        int end_idx_prev= seats.get(1);

        for(int i=2;i<seats.size();i+=2){
            int length = seats.get(i)-end_idx_prev;
            result=(result*length)*M;
            end_idx_prev= seats.get(i+1);
        }
        return (int) result;
    }
}
