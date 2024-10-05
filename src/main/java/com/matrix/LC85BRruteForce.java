package com.matrix;

public class LC85BRruteForce {

    public static void main(String[] args) {
        String [][] matrix = {{"1","0","1","0","0"},
                {"1","0","1","1","1"},
                {"1","1","1","1","1"},
                {"1","0","0","1","0"}};
        LC85BRruteForce lc85BRruteForce = new LC85BRruteForce();
        int area = lc85BRruteForce.maximalRectangle(matrix);
        System.out.println(area);
    }


    public int maximalRectangle(String[][] matrix) {
        int maxArea = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                if(matrix[i][j]=="1") {
                    int k = i;
                    int l = j;
                    int rowl = 0;
                    int coll = 0;
                    while (k < matrix.length && matrix[k][j].equals( "1")) {
                        rowl++;
                        k++;
                    }
                    while (l < matrix[0].length && matrix[i][l].equals("1") ) {
                        coll++;
                        l++;
                    }
                    maxArea = Integer.max(maxArea, Integer.max(rowl * coll, Integer.max(rowl, coll)));
                }
            }
        }
    return maxArea;
    }
}
