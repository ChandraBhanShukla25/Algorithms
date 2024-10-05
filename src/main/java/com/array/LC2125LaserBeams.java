package com.array;

public class LC2125LaserBeams {

    public static void main(String[] args) {
       String[] bank = {"011001","000000","010100","001000"};
       LC2125LaserBeams laserBeams = new LC2125LaserBeams();
       int noOfBeans = laserBeams.numberOfBeams(bank);
       System.out.println(noOfBeans);
    }


    public int numberOfBeams(String[] bank) {
      int count = 0;
      for(int i=0;i<bank.length;i++){
          long countOf1s = bank[i].chars().filter(ch-> ch=='1').count();
          for(int j=i+1;j<bank.length;j++){
              long countOf1sinJ = bank[j].chars().filter(ch-> ch=='1').count();
              count+= countOf1s*countOf1sinJ;
              if(countOf1sinJ>0){
                  break;
              }
          }
      }
      return count;
    }
}
