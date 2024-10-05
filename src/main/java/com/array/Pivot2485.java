package com.array;

public class Pivot2485 {

    public static void main(String[] args) {
        Pivot2485 pivot2485 = new Pivot2485();
        int x=pivot2485.pivotInteger(8);
        System.out.println(x);
    }

    public int pivotInteger(int n) {

        int leftSum = 1;
        int rightSum = n;
        int i = 1;
        int j = n;
        while(i<=j){

            if(leftSum==rightSum && i==j){
                return i;
            }
            if(leftSum<rightSum){
                i++;
                leftSum=leftSum+i;
            }else if(rightSum<leftSum){
                j--;
                rightSum = rightSum+j;
            }else{
                i++;
                leftSum=leftSum+i;
                j--;
                rightSum = rightSum+j;
            }

        }
        return -1;
    }
}
