package com.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LC386 {

    public static void main(String[] args) {
        int n = 13;
        System.out.println(lexicalOrder(n));
    }

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        int num =1;
       // n=13;
        int i=0;
        while(i<=n){
            result.add(num);
            if(num*10<=n){
                num=num*10; //10
            }else{
                if(num>=n){
                    num=num/10;
                }
                num++;//11
                while(num%10==0) num=num/10;
            }
            i++;
        }
        return result;
    }
}
