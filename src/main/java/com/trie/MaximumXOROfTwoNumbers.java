package com.trie;

import java.util.ArrayList;

public class MaximumXOROfTwoNumbers {



    static  class Node{
        Node[] node = new Node[2];

        boolean containsKey(int bit){
            return node[bit]!=null;
        }

        void put( int bit, Node newNode){
            node[bit] = newNode;
        }

        Node get(int bit){
            return node[bit];
        }
    }

    static  class Trie{
        Node root;

        public Trie(){
            this.root = new Node();
        }

        public void insert(int num){
            Node node = root;

            for(int i=31;i>=0;i--){
                int bit = (num>>i) & 1;
                if(!node.containsKey(bit)){
                    node.put(bit, new Node());
                }
                node = node.get(bit);
            }
        }

       public int max(int num){
            Node node = root;
            int maximum = 0;
            for(int i=31;i>=0;i--){
                int bit = (num>>i) & 1;
                if(node.containsKey(1- bit)){
                    maximum |= 1<<i;
                    node= node.get(1-bit);
                }else{
                    node= node.get(bit);
                }
            }
            return maximum;
       }

    }

    static  int maxXOR(int n, int m , ArrayList<Integer> arr1, ArrayList<Integer> arr2){
        Trie trie = new Trie();
        for(int it1: arr1){
            trie.insert(it1);
        }

        int maxi = 0;

        for(int it2: arr2){
            maxi = Math.max(maxi, trie.max(it2));
        }
        return maxi;
    }

    static void printArr(ArrayList<Integer> arr) {
        for (int it : arr) {
            System.out.print(it + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>(java.util.Arrays.asList(3, 10, 5, 25, 2));
        ArrayList<Integer> arr2 = new ArrayList<>(java.util.Arrays.asList(8, 1, 2, 12, 7));
        int n = arr1.size();
        int m = arr2.size();

        System.out.print("Arr1: ");
        printArr(arr1);
        System.out.print("Arr2: ");
        printArr(arr2);

        int result = maxXOR(n, m, arr1, arr2);
        System.out.println("Maximum XOR value: " + result);
    }


}
