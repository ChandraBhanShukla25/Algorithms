package com.stack;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class NextGreaterElement503 {

    public static void main(String[] args) {
       int[] nums = {1,2,1};
       NextGreaterElement503 nextGreaterElement503 = new NextGreaterElement503();
       int[] nge = nextGreaterElement503.nextGreaterElements(nums);
        for(int i=0;i<nge.length;i++){
            System.out.println(nge[i]);
        }
    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nge = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=2*n-1; i>=0;i--){
            while(!stack.isEmpty() && nums[i%n]>=stack.peek()){
                stack.pop();
            }
            if(!stack.isEmpty()){
                nge[i%n]= stack.peek();
            }else{
                nge[i%n]=-1;
            }
            stack.push(nums[i%n]);
        }
        return nge;
    }
}
