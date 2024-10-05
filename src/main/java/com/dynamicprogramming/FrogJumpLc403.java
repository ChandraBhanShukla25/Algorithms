package com.dynamicprogramming;

import java.util.ArrayList;
import java.util.Set;

public class FrogJumpLc403 {

    public static void main(String[] args) {
        int[] stones = {0,1,3,5,6,8,12,17};
        int[] stones1 = {0,1,2,3,4,8,9,11};
        FrogJumpLc403 frogJumpLc403 = new FrogJumpLc403();
        boolean x = frogJumpLc403.canCross(stones);
        boolean x1 = frogJumpLc403.canCross(stones1);
        System.out.println(x);
        System.out.println(x1);
    }

    public boolean canCross(int[] stones) {
      int step=1;
      int index = 1;
      boolean canCross = isAbleToCross(stones, index,step);
      return canCross;

    }


    private boolean isAbleToCross(int[] stones, int index, int step) {
        if(index==stones.length-1){
            return true;
        }
        if(stones[index]> stones[index-1]+step+1)
            return false;
        else
            if(stones[index]== stones[index-1]+step) {
               return isAbleToCross(stones, index + 1, step);
            }else{
                return isAbleToCross(stones, index+1, step+1) ;
            }

    }
}
