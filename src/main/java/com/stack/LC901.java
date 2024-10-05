package com.stack;

import java.util.*;

public class LC901 {

    Stack<int[]> stack = new Stack<>();
    public LC901() {

    }

    public int next(int price) {
      int ans = 1;
      while(!stack.isEmpty() && stack.peek()[0]<=price){
          ans+=stack.pop()[1];
      }
      stack.push(new int[]{price,ans});
      return ans;
    }

    public static void main(String[] args) {
         LC901 lc901 = new LC901();
         int x= lc901.next(100);
    }
}
