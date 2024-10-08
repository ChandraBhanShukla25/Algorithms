package com.puzzles;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Lock752 {


    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        HashSet<String> deads = new HashSet<>(Arrays.asList(deadends));
        HashSet<String> visited = new HashSet<>();
        queue.offer("0000");
        visited.add("0000");
        int level = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size>0){
                String curr = queue.poll();
                if(deads.contains(curr)){
                    size--;
                    continue;
                }
                if(curr.equals(target)){
                    return level;
                }

                StringBuilder sb = new StringBuilder(curr);

                for(int i=0;i<4;i++){
                    char ch = sb.charAt(i);
                    String s1 = sb.substring(0,i) + (ch=='9' ? 0 : ch-'0'+1)+sb.substring(i+1);

                    String s2 = sb.substring(0,i) + (ch=='0' ? 9 : ch-'0'-1)+sb.substring(i+1);

                    if(!visited.contains(s1) && !deads.contains(s1)){
                        queue.offer(s1);
                        visited.add(s1);
                    }
                    if(!visited.contains(s2) && !deads.contains(s2)){
                        queue.offer(s2);
                        visited.add(s2);
                    }
                }
                size--;
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {
       String [] deadends = {"0201","0101","0102","1212","2002"} ;
        String target = "0202";
        Lock752 lock752 = new Lock752();
        int turn = lock752.openLock(deadends,target);
        System.out.println(turn);
    }
}
