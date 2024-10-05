package com.binarysearch;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
       int n = 3;
       int[] arr1 = {2,4,6};
       int n2 = 3;
       int[] arr2 = {1,3,5};
       double median = median(arr1,arr2);
        System.out.println(median);
    }

    public static double median(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;
        int n = n1+n2;
        int ind2 = n/2;
        int ind1 = ind2-1;
        int cnt = 0;
        int i = 0;
        int j = 0;
        int ind1el = -1;
        int ind2el = -1;

        while(i<n1 && j<n2){
            if(a[i]<b[j]){
                if(cnt==ind1) ind1el = a[i];
                if(cnt==ind2) ind2el = a[i];
                cnt++;
                i++;
            }else{
                if(cnt==ind1) ind1el = b[j];
                if(cnt==ind2) ind2el = b[j];
                cnt++;
                j++;
            }
        }

        while(i<n1){
            if(cnt==ind1)
                ind1el = a[i];
            if(cnt==ind2) ind2el = a[i];
            i++;
            cnt++;
        }


        while(j<n2){
            if(cnt==ind1)
                ind1el = b[j];
            if(cnt==ind2) ind2el = b[j];
            j++;
            cnt++;
        }

        if(n%2==1){
            return (double) ind2el;
        }

        return (double) (ind1el+ind2el)/2;
    }
}
