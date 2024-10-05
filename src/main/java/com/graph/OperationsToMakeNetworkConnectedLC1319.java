package com.graph;

import com.disjointset.DisjointSet;

public class OperationsToMakeNetworkConnectedLC1319 {


    public static void main(String[] args) {
        int n = 4;
        int[][] connections = {{0, 1}, {0, 2}, {1, 2}};
        int n1 = 6;
        int[][] conections1 = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}};

        int n2 = 6;
        int[][] connections2 = {{0, 1}, {0, 2}, {0, 3}, {1, 2}};
        OperationsToMakeNetworkConnectedLC1319 operations = new OperationsToMakeNetworkConnectedLC1319();
        int countOfConnection = operations.makeConnected(n, connections);
        int countOfConection1 = operations.makeConnected(n1, conections1);
        int countOfConection2 = operations.makeConnected(n2, connections2);
        System.out.println(countOfConnection);
        System.out.println(countOfConection1);
        System.out.println(countOfConection2);
    }

    public int makeConnected(int n, int[][] connections) {
        DisjointSet disjointSet = new DisjointSet(n);
        int extraedges = 0;
        for (int i = 0; i < connections.length; i++) {
            if (disjointSet.findParent(connections[i][0]) == disjointSet.findParent(connections[i][1])) {
                extraedges++;
            } else {
                disjointSet.unionByRank(connections[i][0], connections[i][1]);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (disjointSet.parent.get(i) == i) {
                count++;
            }
        }
        int answer = count - 1;
        if (extraedges >= answer) {
            return answer;
        }
        return -1;
    }
}
