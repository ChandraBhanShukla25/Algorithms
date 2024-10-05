package com.stack;

import java.util.Stack;

public class CountNGE {

    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 7, 5, 8, 10, 6};
        int N = arr.length;
        int queries = 2;
        int[] indices = {0, 5};
        CountNGE countNGE = new CountNGE();
        int[] res = countNGE.count_NGEs(N, arr, queries, indices);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }

    public  int[] count_NGEs(int N, int arr[], int queries, int indices[]) {

        int[] ans = new int[queries];

        for(int i=0;i<queries;i++){
           Stack<Integer> stack = new Stack<>();
           int r = N-1;
           int curr = arr[indices[i]];
           while(r>indices[i]){
               if(curr<arr[i]){
                   stack.push(arr[i]);
               }
               r--;
           }
           ans[i] =stack.size();
        }
        return ans;
    }
}
