package com.graph;

import java.util.*;

public class CourseSchedule2 {

    public static void main(String[] args) {
        int [][] prerequisites = {{1,0}};
        int  numCourses = 2;

        CourseSchedule2 courseSchedule2 = new CourseSchedule2();
        int x[] =courseSchedule2.findOrder(numCourses,prerequisites);

        for(int i=0;i<x.length;i++){
            System.out.print(x[i]);
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[numCourses];
        List<Integer> indegree = new ArrayList<>(Collections.nCopies(numCourses,0));
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adjList.add(i,new ArrayList<Integer>());
        }

        for(int i=0;i<prerequisites.length;i++){
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree.set(prerequisites[i][0], indegree.get(prerequisites[i][0])+1);
        }

        for(int i=0;i<indegree.size();i++){
            if(indegree.get(i)==0){
                queue.add(i);
            }
        }
        int i=0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            result[i]=node;
            i++;
            for(int n: adjList.get(node)){
                indegree.set(n, indegree.get(n)-1);
                if(indegree.get(n)==0){
                    queue.add(n);
                }
            }
        }

        return result;
    }
}
