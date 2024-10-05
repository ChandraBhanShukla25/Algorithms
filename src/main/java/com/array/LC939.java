package com.array;

import java.util.HashSet;
import java.util.Set;

public class LC939 {

    public static void main(String[] args) {
      int[][] points = {{1,1},{1,3},{3,1},{3,3},{4,1},{4,3}};
      int area = minAreaRect(points);
        System.out.println(area);
    }

    public static int minAreaRect(int[][] points) {
      int minArea = Integer.MAX_VALUE;
      Set<String> set = new HashSet<>();
      for(int[] point: points){
          String cordinate = point[0]+ ""+point[1];
          set.add(cordinate);
      }

      for(int i=0;i<points.length;i++){
          for(int j=0;j<points.length;j++){
              if(i!=j){
                  int x1= points[i][0];
                  int y1 = points[i][1];
                  int x2 = points[j][0];
                  int y2 = points[j][1];
                  if(x1!=x2 && y1!=y2){
                      String corner1 = x1+""+y2;
                      String corner2 = x2+""+y1;

                      if(set.contains(corner1) && set.contains(corner2)){
                          int area = Math.abs(x2-x1)*Math.abs(y2-y1);
                          minArea = Math.min(area,minArea);
                      }
                  }


              }
          }
      }
      return minArea;
    }
}
