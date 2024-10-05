package com.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphMatrix {

    static class Graph {
      ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
      int[][] adjacencyMatrix;
      public Graph(ArrayList<GraphNode> nodeList){
          this.nodeList=nodeList;
          adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
      }
        public ArrayList<GraphNode> getNeighbors(GraphNode node){
            ArrayList<GraphNode> neighbors = new ArrayList<>();
            int nodeIndex = node.index;
            for(int i=0;i<adjacencyMatrix.length;i++){
                if(adjacencyMatrix[node.index][i]==1){
                    neighbors.add(nodeList.get(i));
                }
            }
            return neighbors;
        }
    }

    static  class GraphNode{
        String name;
        int index;
        boolean isVisited;

        public ArrayList<GraphNode> neighbors = new ArrayList<>();

        public GraphNode(String name, int index){
            this.name = name;
            this.index = index;
            this.isVisited = false;
        }
    }

    public void bfs(GraphNode node){
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            GraphNode current = queue.poll();
            System.out.println();

        }
    }
}
