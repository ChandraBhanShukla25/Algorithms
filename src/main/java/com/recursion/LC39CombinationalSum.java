package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class LC39CombinationalSum {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        LC39CombinationalSum combinationalSum = new LC39CombinationalSum();
        combinationalSum.combinationSum(candidates, target);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int sum = target;
        List<List<Integer>> lst = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        getCombinationAsList(candidates, target, lst, result, 0);
        System.out.println(lst);
        return lst;
    }

    public void getCombinationAsList(int[] candidates, int target, List<List<Integer>> lst, List<Integer> result, int idx) {
        if (target == 0) {
            lst.add(new ArrayList<>(result));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if(candidates[i]>target)
                break;
            if(candidates[i]<=target) {
                result.add(candidates[i]);
                getCombinationAsList(candidates, target - candidates[i], lst, result, i );
                result.remove(result.size() - 1);
            }else {
                getCombinationAsList(candidates, target - candidates[i], lst, result, i + 1);

            }

        }
    }
}
