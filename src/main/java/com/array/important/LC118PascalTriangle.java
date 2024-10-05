package com.array.important;

import java.util.ArrayList;
import java.util.List;

public class LC118PascalTriangle {

    public static void main(String[] args) {
        int n = 5;
        LC118PascalTriangle pascalTriangle = new LC118PascalTriangle();
        List<List<Integer>> pascalList = pascalTriangle.generate(n);
        System.out.println(pascalList);
    }

    public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> result = new ArrayList<>();
       for(int row=1;row<=numRows;row++){
           result.add(generateRow(row));
       }
       return result;
    }

    public List<Integer> generateRow(int row){
        List<Integer> rowResult = new ArrayList<>();
        rowResult.add(1);
        int ans = 1;
        for(int i=1;i<row;i++){
            ans= ans*(row-i);
            ans= ans/i;
            rowResult.add(ans);
        }
        return rowResult;
    }
}
