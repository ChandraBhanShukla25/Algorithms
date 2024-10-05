package com.backtracking;

import java.util.Arrays;

public class LC886PossibleBiPartition {

//    public static void main(String[] args) {
//       int m = 4;
//       int[][] dislikes = {{1,2},{1,3},{2,4}};
//       LC886PossibleBiPartition partition = new LC886PossibleBiPartition();
//       if(partition.possibleBipartition(m, dislikes)){
//           System.out.println(true);
//       }else{
//           System.out.println(false);
//       }
//    }
//
//   public boolean possibleBipartition(int m, int[][] dislikes){
//        int V = dislikes.length;
//        int[] person = new int[V];
//       Arrays.fill(person,0);
//
//       if(!bipartition(m, dislikes, person, 0)){
//           return false;
//       }
//
//   }
//
//    private boolean bipartition(int m, int[][] dislikes, int[] person, int node) {
//        if(node==person.length){
//            return true;
//        }
//
//        for(int idx = 1;idx<=m;idx++){
//            if(isSafe(node, dislikes, person, idx)){
//                person[node] = idx;
//                if(bipartition(m, dislikes, person, node+1))
//                    return true;
//                person[node]=0;
//            }
//        }
//        return false;
//    }
//
//    private boolean isSafe(int m, int[][] dislikes, int[] person, int node) {
//        for(int i=0;i<dislikes.length;i++){
////            if(dislikes[m][i] && node == person[i]){
////                return false;
////            }
//        }
//        return true;
//    }
}
