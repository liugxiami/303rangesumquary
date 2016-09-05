package com.ccsi;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] a={1,2,3,4,5,4,5,6,7,8,9,0,2};
        NumArray nums=new NumArray(a);
        int res=nums.sumRange(7,11);
        System.out.println(res);
    }


}
//Given an integer array nums,find the sum of the elements between indeces i and (i<=j),inclusive
//暴力
class NumArray1{
    private int[] array;
    public NumArray1(int[] nums){
        if(nums==null||nums.length==0) return;
        this.array=nums;
    }
    public int sumRange(int i,int j){
        if(i<0||j>this.array.length-1){
            return -1;}
        int sum=0;
        for (int k = i; k <=j; k++) {
            sum+=this.array[k];
        }
        return sum;
    }
}
class NumArray{
    private int[] nums;
    private int[] sums;

    public NumArray(int[] nums){
        if(nums==null||nums.length==0)return;
        this.nums=nums;
        this.sums=new int[nums.length];
        sums[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i]=sums[i-1]+nums[i];
        }
    }
    public int sumRange(int i,int j){
        if(nums==null||nums.length==0) return 0;
        int min=i<j?i:j;
        int max=i<j?j:i;
        return sums[max]-sums[min]+nums[min];
    }
}
