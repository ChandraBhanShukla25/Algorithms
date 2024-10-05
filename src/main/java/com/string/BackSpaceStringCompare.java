package com.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BackSpaceStringCompare {

    public static void main(String[] args) {
        String s = "rjhbpvh";
        String t = "rjh#bpvh";
        BackSpaceStringCompare backSpaceStringCompare = new BackSpaceStringCompare();
        boolean isEqual = backSpaceStringCompare.backspaceCompare(s,t);
        System.out.println(isEqual);
    }

    public boolean backspaceCompare(String s, String t) {
        List<Character> s1 = new LinkedList<Character>();
        List<Character> s2 = new LinkedList<Character>();
        int i=0; int j=0;
        while(i<s.length()){
            if(s.charAt(i)!='#'){
                s1.add(s.charAt(i));
            }else {
               if(!s1.isEmpty()){
                   s1.remove(s1.size()-1);
               }
            }
            i++;
        }

        while(j<t.length()){
            if(t.charAt(j)!='#'){
                s2.add(t.charAt(j));
            }else {
                if(!s2.isEmpty()){
                    s2.remove(s2.size()-1);
                }
            }
            j++;
        }
        System.out.println(s1 + " " + s2);
        StringBuilder sb1 = new StringBuilder();
        for(int m=0;m<s1.size();m++){
          sb1.append(s1.get(m));
        }
        StringBuilder sb2 = new StringBuilder();
        for(int n=0;n<s2.size();n++){
            sb2.append(s1.get(n));
        }
        if(sb1.toString().equals(sb2.toString())){
            return true;
        }
        return false;
    }
}
