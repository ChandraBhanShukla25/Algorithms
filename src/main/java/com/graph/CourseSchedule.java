package com.graph;

import java.util.*;

public class CourseSchedule {


    public static void main(String[] args) {
        int[][] prerequisite = {{1,0},{0,1}};
        int numCourses = 2;
        CourseSchedule courseSchedule = new CourseSchedule();
        boolean x = courseSchedule.canFinish(numCourses, prerequisite);
        System.out.println(x);

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> indegree = new ArrayList<>(Collections.nCopies(numCourses,0));
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(i,new ArrayList<Integer>());
        }

        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree.set(prerequisites[i][0], indegree.get(prerequisites[i][0])+1);
        }

        for(int i=0;i<numCourses;i++){
            if(indegree.get(i)==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            ans.add(node);
            for(int it: adj.get(node)){
                indegree.set(it, indegree.get(it)-1);
                if(indegree.get(it)==0){
                    queue.add(it);
                }
            }
        }
       for(int i=0;i<indegree.size();i++){
           if(indegree.get(i)!=0){
               return false;
           }
       }
       return true;
    }
}
