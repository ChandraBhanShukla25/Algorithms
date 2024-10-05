package com.array;

import java.util.ArrayList;
import java.util.List;

public class ArrayLeaders {

    static ArrayList<Integer> leaders(int n, int arr[]) {
        // Your code here
        ArrayList<Integer> lst = new ArrayList<>();
        if(n==0){
            return lst;
        }

        lst.add(arr[n-1]);
        int max = arr[n-1];
        for(int i=n-2;i>=0;i--){
            if(max<arr[i]){
                lst.add(0,arr[i]);
                max = arr[i];
            }
        }
        return lst ;
    }

    public static void main(String[] args) {
        int arr[] = {16,17,4,3,5,2};
        int n = 6;
        List<Integer> lst = leaders(n, arr);
        System.out.println(lst);
    }
}
