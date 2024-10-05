package com.graph;

public class BipariteGraph {

    public static void main(String[] args) {
       int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
       BipariteGraph bipariteGraph = new BipariteGraph();
       boolean isBiparite = bipariteGraph.isBipartite(graph);
       System.out.println(isBiparite);
    }

    public boolean isBipartite(int[][] graph) {
      int noOfNodes = graph.length;
      int[] colorArr = new int[noOfNodes];

      for(int i=0;i<noOfNodes;i++){
          if(colorArr[i]==0 && !dfs(graph,colorArr, i,1 )){
              return false;
          }
      }
      return true;
    }

    public boolean dfs(int[][] graph, int[] colorArr, int currentNode, int color){
        colorArr[currentNode]=color;
        for(int adjNode: graph[currentNode]){
           if(colorArr[adjNode]==0){
               if(!dfs(graph, colorArr, adjNode, 3-color)){
                   return false;
               }
           }else if(colorArr[adjNode]==color){
               return false;
           }
        }
        return true;
    }
}
