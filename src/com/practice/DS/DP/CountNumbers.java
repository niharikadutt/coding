package com.practice.DS.DP;

import java.util.Arrays;

public class CountNumbers {
	
	private static int[][] lookup = new int[101][50001];

	public static void main(String[] args) {
		int n=2, sum=6;
		System.out.println(getCount(n, sum));
	}
	
	private static int getCount(int n, int sum){
		int ans = 0;
		for(int i=0;i<lookup.length;i++){
			Arrays.fill(lookup[i], -1);
		}
		for(int i=0;i<=9;i++){
			if(sum-i>0){
				ans+=getCountUtil(n-1, sum-i);
			}
		}
		return ans;
	}
	
	private static int getCountUtil(int n, int sum){
		if(n==0)
			return sum==0?1:0;
		
		if(lookup[n][sum]!=-1)
			return lookup[n][sum];
		
		int ans=0;
		for(int i=0;i<10;i++){
			if(sum-i>=0){
				ans+=getCountUtil(n-1, sum-i);
			}
		}		
		return lookup[n][sum]=ans;
	}
}
