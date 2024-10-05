package com.misc;

public class Lc2073 {

    public static void main(String[] args) {
        int[] tickets = {84,49,5,24,70,77,87,8};
        int k = 3;
        Lc2073 lc = new Lc2073();
        int time = lc.timeRequiredToBuy(tickets, k);
        System.out.println(time);
    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        if(tickets.length==0 || tickets[k]==0){
            return 0;
        }
        int time = 0;
      while(tickets[k]!=0){
          int i=0;
          while(i<tickets.length){
              if(tickets[i]!=0){
                  tickets[i]=tickets[i]-1;
                  time++;
              }
              if(tickets[k]==0){
                  return time;
              }
              i++;
          }
      }
      return time;
    }
}
