package com.string.important;

public class LC944DeleteColumns {

    public static void main(String[] args) {
        String[] strs = {"a"};
        LC944DeleteColumns deleteColumns = new LC944DeleteColumns();
        int count = deleteColumns.minDeletionSize(strs);
        System.out.println(count);
    }
    public int minDeletionSize(String[] strs) {
        int count =0;
        if(strs==null || strs.length==0 || strs.length==1){
            return 0;
        }
        for(int i=0;i< strs[0].length();i++){
            char ch = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(strs[j].charAt(i)<ch){
                    count++;
                    break;
                }else{
                    ch=strs[j].charAt(i);
                }
            }
        }
        return count;
    }

}
