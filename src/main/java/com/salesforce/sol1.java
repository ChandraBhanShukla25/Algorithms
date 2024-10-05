package com.salesforce;

import java.util.*;

class sol1 {

    private static int[] parent; // parent[i] is the parent of node i in the union-find data structure
    private static int[] componentSize; // componentSize[i] is the size of the component whose root is i

    public static int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        parent = new int[n];
        componentSize = new int[n];

        // Initialize the union-find data structure
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
            componentSize[i] = 1;
        }

        // Keep track of clean nodes (non-malware)
        boolean[] isClean = new boolean[n];
        Arrays.fill(isClean, true);
        for (int infectedNode : initial) {
            isClean[infectedNode] = false;
        }

        // Union clean nodes that are connected
        for (int i = 0; i < n; ++i) {
            if (!isClean[i]) {
                continue;
            }
            for (int j = i + 1; j < n; ++j) {
                if (isClean[j] && graph[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        // Count how many initial nodes affect each component
        int[] affectedCount = new int[n];
        Map<Integer, Set<Integer>> malwareSources = new HashMap<>();
        for (int infectedNode : initial) {
            Set<Integer> affectedComponents = new HashSet<>();
            for (int j = 0; j < n; ++j) {
                if (isClean[j] && graph[infectedNode][j] == 1) {
                    affectedComponents.add(find(j));
                }
            }
            for (int root : affectedComponents) {
                affectedCount[root] += 1;
            }
            malwareSources.put(infectedNode, affectedComponents);
        }

        int maxAffected = -1;
        int result = 0;

        // Choose the node removing which minimizes the spread of malware
        for (Map.Entry<Integer, Set<Integer>> entry : malwareSources.entrySet()) {
            int node = entry.getKey();
            int totalAffected = 0;
            for (int root : entry.getValue()) {
                if (affectedCount[root] == 1) { // Only affected by one malware
                    totalAffected += componentSize[root];
                }
            }
            if (maxAffected < totalAffected || (maxAffected == totalAffected && node < result)) {
                maxAffected = totalAffected;
                result = node;
            }
        }
        return result+1;
    }

    // Find the root of the component to which node x belongs
    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Union two components by size
    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            if (componentSize[rootA] < componentSize[rootB]) {
                parent[rootA] = rootB;
                componentSize[rootB] += componentSize[rootA];
            } else {
                parent[rootB] = rootA;
                componentSize[rootA] += componentSize[rootB];
            }
        }
    }

    public static void main(String args[]){
        //int gNodes = 9;
        int gNodes = 3;
//        int []g_from = {1,2,4,6,7};
//        int[] g_to ={2,3,5,7,8};
//        int []malware ={0,0,1,0,1,0,0,0,0};
        int []g_from = {1,2};
        int[] g_to ={2,3};
        int []malware ={1,1,0};

        List<Integer> ini = new ArrayList<Integer>();
        for(int i =0;i<malware.length;i++){
            if(malware[i]==1){
                ini.add(i);
            }
        }

        int[] initial =  ini.stream().mapToInt(i->i).toArray();
        int[][] matrix = new int[gNodes][gNodes];
        for(int i=0;i<g_from.length;i++){
            int f = g_from[i]-1;
            int t = g_to[i]-1;
            matrix[f][t]=1;
            matrix[t][f]=1;
        }
        System.out.println(minMalwareSpread(matrix, initial));
    }
}

