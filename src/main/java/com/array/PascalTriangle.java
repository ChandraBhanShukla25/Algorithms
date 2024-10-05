package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {
        int n =5;
        PascalTriangle pascalTriangle = new PascalTriangle();
        List<List<Integer>> result = pascalTriangle.getPascalTriangle(n);
        System.out.println(result);
    }

    public List<List<Integer>> getPascalTriangle(int n){

        List<List<Integer>> lst = new ArrayList<>();
        lst.add(0, List.of(1));

        for(int row=1;row<=n;row++){
            List<Integer> prev = lst.get(row-1);

            List<Integer> currentList = new ArrayList<>();
            currentList.add(1);

            for(int i=1;i<row;i++){
                currentList.add(prev.get(i)+prev.get(i-1));
            }
            currentList.add(1);
            lst.add(currentList);

        }
     return lst;
    }
}
