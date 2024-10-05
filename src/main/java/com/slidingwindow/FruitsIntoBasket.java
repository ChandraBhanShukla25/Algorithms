package com.slidingwindow;

import java.util.*;

public class FruitsIntoBasket {

    public static void main(String[] args) {
        int N = 2;
        int[] fruits = {2,1,2};
        int count = FruitsIntoBasket.totalFruits(N, fruits);
        System.out.println(count);
    }

    public static int totalFruits(int N, int[] fruits) {
        if(fruits.length==0){
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int totalFruits = 0;
        int j=0;
        for(int i=0;i<fruits.length;i++){
            if(map.containsKey(fruits[i])){
                map.put(fruits[i], map.get(fruits[i])+1);
            }else{
                map.put(fruits[i],1);
            }
            while(map.size()>N){
              map.put(fruits[j], map.get(fruits[j])-1);
              if(map.get(fruits[j])==0){
                  map.remove(fruits[j]);
              }
              j++;
            }
            totalFruits = Integer.max(totalFruits, map.values().stream().mapToInt(Integer::intValue).sum());
        }
        return totalFruits;
    }
}
