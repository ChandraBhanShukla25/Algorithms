package com.graph;

import java.util.*;

public class GraphDisappear {

    public static void main(String[] args) {
        int n = 7;
        int A[] = {0,1,2,1,4,4};
        int B[] = {1,2,0,4,5,6};

        GraphDisappear graphDisappear = new GraphDisappear();
        int x= graphDisappear.solution(n,A,B);
        System.out.println(x);

    }


    public int solution(int N, int[] A, int[] B){
        int timeTakenInSeconds =0;
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            map.put(i, new HashSet<>());
        }

        for (int i = 0; i < A.length; i++) {
            map.get(A[i]).add(B[i]);
            map.get(B[i]).add(A[i]);
        }

        while (true) {
            List<Integer> lst = new ArrayList<>();
            for (int vertex : map.keySet()) {
                if (map.get(vertex).size() <= 1) {
                    lst.add(vertex);
                }
            }
            if (lst.isEmpty()) {
                break;
            }
            for (int vertex : lst) {
                for (int neighbor : map.get(vertex)) {
                    map.get(neighbor).remove(vertex);
                }
                map.remove(vertex);
            }
            timeTakenInSeconds++;
        }
        return timeTakenInSeconds;
    }
}
