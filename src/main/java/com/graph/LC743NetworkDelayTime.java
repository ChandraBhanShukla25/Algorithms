package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LC743NetworkDelayTime {

    public static void main(String[] args) {
       int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
       LC743NetworkDelayTime networkDelayTime = new LC743NetworkDelayTime();
        System.out.println(networkDelayTime.networkDelayTime(times, 4, 2));
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        List<List<int[]>> adjList = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->x[1]-y[1]);

        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] time: times){
           adjList.get(time[0]).add(new int[] {time[1],time[2]});
        }

        dist[k]=0;
        pq.add(new int[]{k,0});

        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            int src = arr[0];
            int cost = arr[1];
            for(int[] node : adjList.get(src)){
                int adjNode = node[0];
                int adjCost = node[1];
                if(cost+adjCost<dist[adjNode]){
                    dist[adjNode]= cost+adjCost;
                    pq.offer(new int[]{adjNode,cost+adjCost});
                }

            }
        }

        for(int x: dist){
            if(x==Integer.MAX_VALUE)
                return -1;
        }
      return Arrays.stream(dist).sum();
    }
}
