package com.binarysearch;

public class NthRootUsingBinarySearch {

    public static void main(String[] args) {
        int m = 1953125; int  n = 9;
        NthRootUsingBinarySearch nthRoot = new NthRootUsingBinarySearch();
        int x = nthRoot.NthRoot(m,n);
        System.out.println(x);
    }

    public int NthRoot(int m, int n) {
        int low = 1;
        int high = m;

        while(low<=high){
            int mid = (low+high)/2;
            int nthNum= nthRoot(mid, n, m);
            if(nthNum==1){
                return mid;
            }
            else if(nthNum==0){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }

    int nthRoot(int mid, int n, int m){
        long nthRoot = 1;

        for(int i=0;i<n;i++){
            nthRoot*=mid;
            if(nthRoot>m){
                return 2;
            }
        }
        if(nthRoot==m){
            return 1;
        }
        return 0;
    }
}
