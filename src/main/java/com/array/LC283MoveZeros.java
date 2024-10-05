package com.array;

import java.util.Arrays;

public class LC283MoveZeros {

    public static void main(String[] args) {
        int[] nums= {0};
        LC283MoveZeros moveZeros = new LC283MoveZeros();
        moveZeros.moveZeroes(nums);
        Arrays.stream(nums).forEach(System.out::println);

    }

    public void moveZeroes(int[] nums) {
        int i=0;
        int j=-1;
        int count=0;
        while(i<nums.length) {
            if (nums[i] != 0) {
                j++;
                nums[j] = nums[i];
                i++;
            } else {
                i++;
                count++;
            }
        }

        while(j<nums.length && count>0){
            ++j;
            nums[j]=0;
            count--;
        }
    }
}
