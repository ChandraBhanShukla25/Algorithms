package com.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC881BoatToSavePeople {

    public static void main(String[] args) {
       int[] people = {5,1,4,2};
       int limit = 6;
       LC881BoatToSavePeople boatToSavePeople = new LC881BoatToSavePeople();
       int x= boatToSavePeople.numRescueBoats(people,limit);
       System.out.println(x);
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int i=0;
        int j=people.length-1;
        while(i<=j){
            if(people[i]+people[j]<=limit){
                count++;
                i++;
                j--;
            }else{
                count++;
                j--;
            }
        }
     return count;
    }
}
