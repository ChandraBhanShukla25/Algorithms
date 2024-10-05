package com.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NearestSmallerElement {

    public static void main(String[] args) {
        ArrayList<Integer> lst  = new ArrayList<>();
        //[4, 5, 2, 10, 8]
        lst.add(4);
        lst.add(5);
        lst.add(2);
        lst.add(10);
        lst.add(8);

        NearestSmallerElement smallerElement = new NearestSmallerElement();
        List<Integer> result = smallerElement.prevSmaller(lst);
        System.out.println(result);
    }

    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<A.size();i++){
            while(!stack.isEmpty() && stack.peek()>A.get(i)){
                stack.pop();
            }
            if(stack.isEmpty()){
                result.add(-1);
            }else{
                result.add(stack.peek());
            }
            stack.push(A.get(i));
        }
        return result;
    }
}
