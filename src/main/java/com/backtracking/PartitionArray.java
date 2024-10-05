package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PartitionArray {


    public static void main(String[] args) {
        int arr[] = {1,6,5,8,11,24};
        Arrays.sort(arr);
        List<List<Integer>> lst = new ArrayList<>();
        lst.add(0, new ArrayList<>());
        lst.add(1,new ArrayList<>());
        int diff = Integer.MAX_VALUE;
        lst.get(0).add(arr[0]);
        lst.get(1).add(arr[1]);
        findSubarray(lst, arr,1, arr.length-2, 0,0 );
        System.out.println(lst);
    }

    private static void findSubarray(List<List<Integer>> lst, int[] arr, int i, int j, int leftSum, int rightSum) {
        if (i == j) {
            return;
        }
        while (i < j) {
            if (leftSum + arr[i] < rightSum) {
                lst.get(0).add(arr[i]);
                leftSum = leftSum + arr[i];
                findSubarray(lst, arr, i + 1, j, leftSum, rightSum);
                leftSum = leftSum - arr[i];
                lst.get(0).remove(arr[i]);
            } else if (rightSum + arr[j] < leftSum) {
                lst.get(1).add(arr[j]);
                rightSum = rightSum + arr[j];
                findSubarray(lst, arr, i, j - 1, leftSum, rightSum);
                rightSum = rightSum - arr[j];
                lst.get(1).remove(arr[j]);
            } else {
                lst.get(1).add(arr[j]);
                lst.get(0).add(arr[i]);
                rightSum = rightSum + arr[j];
                leftSum = leftSum + arr[i];
                findSubarray(lst, arr, i + 1, j - 1, leftSum, rightSum);
                rightSum = rightSum - arr[j];
                leftSum = leftSum - arr[i];
                lst.get(1).remove(arr[j]);
                lst.get(0).remove(arr[i]);
            }

        }
    }

}


