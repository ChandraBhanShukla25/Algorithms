package com.graph;

import java.util.*;

public class LC207 {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
       int[] indegree = new int[numCourses];
       Queue<Integer> queue = new LinkedList<>();
       int count = 0;
       List<List<Integer>> adjList = new ArrayList<>();
       for(int i=0;i<numCourses;i++){
           adjList.add(i, new ArrayList<>());
       }
       for(int[] arr: prerequisites){
           adjList.get(arr[1]).add(arr[0]);
           indegree[arr[0]]++;
       }

       for(int i=0;i<indegree.length;i++){
           if(indegree[i]==0){
               queue.add(i);
           }
       }

       while(!queue.isEmpty()){
           int node = queue.poll();
           count++;
           queue.remove(node);
           for(int it: adjList.get(node)){
               indegree[it]--;
               if(indegree[it]==0)
                   queue.add(it);
           }
       }
       return count==numCourses;
    }

    public static void main(String[] args) {
        int numCourses = 2; int[][] prerequisites = {{1,0}};
        boolean x = canFinish(numCourses, prerequisites);
        System.out.println(x);
    }
}
