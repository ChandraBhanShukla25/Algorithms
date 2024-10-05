package com.array;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int arr[] = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        RemoveDuplicatesFromSortedArray removeDuplicatesFromArr = new RemoveDuplicatesFromSortedArray();
        int x = removeDuplicatesFromArr.removeDuplicates(arr);
        System.out.println(x);
        System.out.println(arr);
    }

    public int removeDuplicates(int[] nums) {
        int[] expect = new int[nums.length];
        int count = 1;
        expect[0] = nums[0];
        int expectIdx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != expect[expectIdx]) {
                expect[++expectIdx] = nums[i];
                count++;
            }
        }
        for(int i=0;i<=expectIdx;i++){
            nums[i]=expect[i];
        }
        return count;
    }
}
