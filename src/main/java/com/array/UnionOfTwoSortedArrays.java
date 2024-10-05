package com.array;

import java.util.ArrayList;
import java.util.List;

public class UnionOfTwoSortedArrays {

    public static void main(String[] args) {
       int n = 5; int arr1[] = {1, 2, 3, 4, 5};
       int m = 5; int arr2 [] = {1, 2, 3, 6, 7};
       List<Integer> lst = findUnion(arr1,arr2,n,m);
        System.out.println(lst);
    }

    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        int i=0;
        int j=0;

        ArrayList<Integer> lst = new ArrayList<>();

        while(i<n && j<m){
             if(arr1[i]>=arr2[j]){
                if(lst.isEmpty()){
                    lst.add(arr2[j]);
                } else if(lst.get(lst.size()-1)!=arr2[j]){
                    lst.add(arr2[j]);
                }
                j++;
            }else{
                if(lst.isEmpty()){
                    lst.add(arr1[i]);
                } else if(lst.get(lst.size()-1)!=arr1[i]){
                    lst.add(arr1[i]);
                }
                i++;
            }
        }

        while(i<n){
            if(lst.get(lst.size()-1)!=arr1[i]){
                lst.add(arr1[i]);
            }
            i++;
        }
        while(j<m){
            if(lst.get(lst.size()-1)!=arr2[j]){
                lst.add(arr2[j]);
            }
            j++;
        }
        return lst;
    }
}
