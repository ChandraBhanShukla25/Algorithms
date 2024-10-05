package com.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasketsLC904 {

    public static void main(String[] args) {
        int[] fruits = {1,2,3,2,2};
        int baskets = 2;
        FruitsIntoBasketsLC904 pickFruits = new FruitsIntoBasketsLC904();
        int x = pickFruits.totalFruit(fruits, baskets);
        System.out.println(x);
    }

    public int totalFruit(int[] fruits, int basket) {

        Map<Integer, Integer> map = new HashMap<>();

        int i=0;
        int j=0;
        int maxFruits = 0;
        while(i<fruits.length){
            map.merge(fruits[i], 1, Integer::sum);
            while(map.size()>2){
                map.merge(fruits[j], -1, Integer::sum);
                if(map.get(fruits[j])==0){
                    map.remove(fruits[j]);
                }
                j++;
            }
            maxFruits = Integer.max(maxFruits,i-j+1);
            i++;
        }

   return maxFruits;
    }
}
