package com.array;

public class DecreasingCheck {

    public static void main(String[] args) {
        int[] A= {1,2,2};
        int x= checkDescreasing(A);
        System.out.println(x);
    }

    private static int checkDescreasing(int[] a) {
        int last = Integer.MIN_VALUE;

        for(int i=0;i<a.length;i++){
            if(last>a[i]){
                return 0;
            }
            last= a[i];
        }
        return 1;
    }
}
