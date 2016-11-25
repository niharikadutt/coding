package com.practice.DS.DP;

public class CountWays {

	public static void main(String[] args) {
		int n=4, m=2;
		System.out.println(countWays(n,m));
	}
	
	private static int countWays(int n, int m){
		return countWaysUtil(n+1,m);
	}
	private static int countWaysUtil(int n, int m){
		if(n<=1)
			return n;
		
		int ans=0;
		for(int i=1;i<=m&&i<=n;i++){
			ans+=countWaysUtil(n-i,m);
		}
		return ans;
	}

}
