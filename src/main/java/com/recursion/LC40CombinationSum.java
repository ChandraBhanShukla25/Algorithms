package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC40CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        LC40CombinationSum combinationSum = new LC40CombinationSum();
        combinationSum.combinationSum2(candidates,target);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lst = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Arrays.sort(candidates);
        getAllSubsequence(candidates,target, 0, result, lst);
        List<List<Integer>> lst1 = new ArrayList<>();
        System.out.println(lst);
        List<Integer> result1 = new ArrayList<>();
        backtrack(0, target, lst1, candidates, result1);
        System.out.println(lst1);
        List<List<Integer>> lst2 = new ArrayList<>();
        List<Integer> result2 = new ArrayList<>();
        backtrack2( lst2,result2, candidates, target,0);
        System.out.println(lst2);
        return lst;
    }

    private void getAllSubsequence(int[] candidates, int target, int idx , List<Integer> result, List<List<Integer>> lst) {
        if(target==0){
            lst.add(new ArrayList<>(result));
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            if(i>idx && candidates[i]==candidates[i-1]){
                continue;
            }
            if(candidates[i]>target)
                break;
            result.add(candidates[i]);
            getAllSubsequence(candidates,target-candidates[i],i+1,result,lst);
            result.remove(result.size()-1);
        }
    }

    public static void backtrack(int index, int target, List<List<Integer>> anw, int[] candidates, List<Integer> tempList) {
        if (target < 0) { return; }
        else if (target == 0) {
            // Collections.sort(tempList);
            anw.add(new ArrayList<>(tempList));
        } else {
            for (int i = index; i < candidates.length && target >= candidates[i]; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                tempList.add(candidates[i]);
       // using index+1 here, its wrong
                backtrack(index + 1, target - candidates[i], anw, candidates, tempList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    private static void backtrack2(List<List<Integer>> answer,List<Integer> tempList, int[] candidates, int target, int index) {
        if (target < 0) return;
        else if (target == 0) { // Add to the answer array, if the sum is equal to target.
            answer.add(new ArrayList<>(tempList));
        } else {
            for (int i = index; i < candidates.length && target >= candidates[i]; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) continue;
                // Add it to tempList.
                tempList.add(candidates[i]);
                // Check for all possible scenarios.
                // using i+1 here
                backtrack2(answer, tempList, candidates, target - candidates[i], i + 1);
                // Backtrack the tempList.
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
