package com.revision.string;

public class Lc1360 {

    public static void main(String[] args) {
        String date1 = "2019-06-29";
        String date2 = "2019-06-30";
        daysBetweenDates(date1, date2);
    }

    public static int daysBetweenDates(String date1, String date2) {
        String[] s1 = date1.split("-");
        String[] s2 = date2.split("-");
        boolean s1IsLeapYear = false;
        boolean s2IsLeapYear = false;
        int difference = 0;
        for(int i=0;i<s1.length;i++){
            if(Integer.parseInt(s1[0]) %4==0){
                s1IsLeapYear = true;
            }
            if(Integer.parseInt(s2[0]) %4==0){
                s2IsLeapYear = true;
            }
            int yearDifference = Integer.parseInt(s2[0])-Integer.parseInt(s1[0]);
            int monthDifference = Integer.parseInt(s2[1])-Integer.parseInt(s1[1]);
            int daysDifference = Integer.parseInt(s2[2])-Integer.parseInt(s1[2]);
        }

       return  0;
    }
}
