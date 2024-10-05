package com.array;

public class ReverseInteger7 {

    public int reverse(int x, int y) {
        if(x==0){
            return y;
        }
        y+= x%10;
      x=x/10;
      if(x!=0) {
          y = y * 10;
      }
      return reverse(x, y);
    }

    public static void main(String[] args) {
        int x = 123;
        ReverseInteger7 reverse = new ReverseInteger7();
        System.out.println(reverse.reverse(x, 0));
    }
}
