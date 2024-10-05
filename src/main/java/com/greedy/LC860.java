package com.greedy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC860 {

    public static void main(String[] args) {
        int[] bills = {5,5,10,10,20};
        int val = 5;
        boolean isPossible = lemonadeChange(bills, val);
        System.out.println(isPossible);
    }

    public static boolean lemonadeChange(int[] bills, int val) {
        int five=0;
        int ten = 0;

        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                five++;
            }else if(bills[i]==10){
                ten++;
                five--;
            }else{
                five--;
                ten--;
            }

            if(five<0 || ten<0){
                return false;
            }
        }
        return true;
    }
}
