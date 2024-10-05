package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequence {

    public static void main(String[] args) {
        int arr[] = {3,1,2};
        List<List<Integer>> lst = new ArrayList<>();
        int i = 0;
        List<Integer> result = new ArrayList<>();
        printSubsequence(arr, i, lst, result);
        System.out.println(lst);
    }

    private static void printSubsequence(int[] arr, int i, List<List<Integer>> lst, List<Integer> result) {
        if(i>=arr.length){
            lst.add(new ArrayList<>(result));
            return;
        }
        result.add(arr[i]);
        printSubsequence(arr,i+1,lst,result);
        result.remove(result.size()-1);
        printSubsequence(arr,i+1,lst,result);
    }


}
