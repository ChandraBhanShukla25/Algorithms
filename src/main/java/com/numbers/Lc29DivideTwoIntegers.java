package com.numbers;

public class Lc29DivideTwoIntegers {

    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor = -1;
        Lc29DivideTwoIntegers lc29DivideTwoIntegers = new Lc29DivideTwoIntegers();
        int x = lc29DivideTwoIntegers.divide(dividend,divisor);
        System.out.println(x);
    }

    public int divide(int dividend, int divisor) {
     /*   long x = 0;
        if(dividend<0 && divisor<0){
           dividend = ;
           divisor = Math.floorMod(divisor, 0);

           long count = 0;
           while(dividend>=divisor){
               dividend-=divisor;
               count++;
           }
           return (int )count;
        }else if(dividend<0 || divisor<0){
            dividend = Math.abs(dividend);
            divisor = Math.abs(divisor);

            long count = 0;
            while(dividend>=divisor){
                dividend-=divisor;
                count++;
            }
            return (int)-count;
        } else{
            long count = 0;
            while(dividend>=divisor){
                dividend-=divisor;
                count++;
            }
            return (int)count;
        }

*/
        return 0;
    }
}
