package com.stack;

import java.util.Arrays;
import java.util.Stack;

public class LC735AsteriodCollission {

    public static void main(String[] args) {
        int[] asteroids = {5,10,-5};
        LC735AsteriodCollission asteriodCollission = new LC735AsteriodCollission();
        int[] arr = asteriodCollission.asteroidCollision(asteroids);
        Arrays.stream(arr).forEach(System.out::println);
    }


    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]>0){
                stack.push(asteroids[i]);
            }else{
                while(!stack.isEmpty() && stack.peek()>0 && stack.peek()<-asteroids[i]){
                    stack.pop();
                }
                if(!stack.isEmpty() && stack.pop()==-asteroids[i]){
                    stack.pop();
                }else{
                   if(stack.isEmpty() || stack.peek()<0){
                       stack.push(asteroids[i]);
                   }
                }
            }
        }

        return stack.stream().mapToInt(Integer::valueOf).toArray();
    }
}
