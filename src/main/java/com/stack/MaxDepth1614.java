package com.stack;

public class MaxDepth1614 {


    public static void main(String[] args) {
       String  s = "(1+(2*3)+((8)/4))+1";
       MaxDepth1614 maxDepth1614 = new MaxDepth1614();
       int maxDepth = maxDepth1614.maxDepth(s);
       System.out.println(maxDepth);
    }

    public int maxDepth(String s) {
        int maxCoun =0;
        int count = 0;
        char[] arr = s.toCharArray();
        for(char ch: arr){
            if(ch=='('){
                count++;
            }else if(ch==')'){
                count--;
            }
            maxCoun = Integer.max(count,maxCoun);
        }
      return maxCoun;
    }
}
