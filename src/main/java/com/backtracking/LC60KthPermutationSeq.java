package com.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC60KthPermutationSeq {

    public static void main(String[] args) {
       int n = 3;
       int k = 5;
       LC60KthPermutationSeq kthPermutationSeq = new LC60KthPermutationSeq();
       String result = kthPermutationSeq.getPermutation(n,k);
        System.out.println(result);
    }

    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        if(k<=0){
            return "";
        }
        for(int i=0;i<n;i++){
            sb.append(i+1);
        }
        List<String> lst = new ArrayList<>();
        getAllPermutations(sb, 0, lst, 1 );
        Collections.sort(lst);
        return lst.get(k-1);
    }

    private void getAllPermutations(StringBuilder sb, int idx, List<String> lst, int count) {
        if(idx==sb.length()){
            lst.add(new String(sb));
        }
        for(int i=idx;i<sb.length();i++){
            swap(sb,i,idx);
            getAllPermutations(sb,idx+1,lst,count);
            swap(sb,i,idx);
        }
    }

    public void swap(StringBuilder sb , int i, int j){
        char ch = sb.charAt(i);
        char ch1 = sb.charAt(j);
        sb.setCharAt(i,ch1);
        sb.setCharAt(j,ch);
    }
}
