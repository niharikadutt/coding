package com.practice.DS.DP;

public class CountNumbersWithSum {
	
	private static int[][] lookup = new int[2][5];

	public static void main(String[] args) {
		int n=2, sum=5;
		System.out.println(finalCount(n, sum));
		
	}
	
	private static int finalCount(int n, int sum){
		int ans = 0;
		for(int i=0;i<2;i++){
			for(int j=0;j<5;j++){
				lookup[i][j] = -1;
			}
		}
		
		for(int i=1;i<=9;i++){
			if(sum-i>=0){
				ans+= finalCountRec(n-1, (sum-i));
			}
		}
		return ans;
	}
	
	private static int finalCountRec(int n, int sum){
		if(n==0){
			return sum==0?1:0;
		}
		
		if(lookup[n][sum]!=-1){
			return lookup[n][sum];
		}
		
		int ans =0;
		for(int i=0;i<=9;i++){
			if(sum-i>=0){
				ans+= finalCountRec(n-1, (sum-i));
			}
		}
		
		return (lookup[n][sum]=ans);
	}

}
