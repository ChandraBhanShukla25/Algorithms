package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum {

    public static void main(String[] args) {
        int n = 3;
        List<Integer> arr = Arrays.asList(5, 2, 1);
        subsetSums(arr,n);
    }
    private static ArrayList<Integer> subsetSums(List<Integer> arr, int n) {
        List<Integer> result = new ArrayList<>();
        ArrayList<Integer> lst = new ArrayList<>();
         getSubsetSums(arr, n, 0, lst,result);
        System.out.println(lst);
        return lst;
    }

    public static  void getSubsetSums(List<Integer> arr, int n, int idx, ArrayList<Integer> lst, List<Integer> result){
        if(idx>=n){
            List<Integer> newList = new ArrayList<>(result);
            lst.add(newList.stream().mapToInt(Integer::intValue).sum());
            return;
        }
        result.add(arr.get(idx));
        getSubsetSums(arr, n, idx+1,lst,result);
        result.remove(result.size()-1);
        getSubsetSums(arr,n,idx+1,lst,result);
    }
}
