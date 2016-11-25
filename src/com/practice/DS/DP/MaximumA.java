package com.practice.DS.DP;

public class MaximumA {

	public static void main(String[] args) {
		System.out.println(findOptimal(11));
		//System.out.println(findOptimalDP(11));
	}
	
	private static int findOptimalDP(int n) {
		int dp[] = new int[n];
		
		for(int i=0;i<7;i++){
			dp[i] = i;
		}
		
		for(int i=7;i<=n;i++){
			for(int b=i-3;b>=1;b--){
				int curr = (i-b-1)*dp[b-1];
				if(curr>dp[n-1]){
					dp[n-1] = curr;
				}
			}
		}
		
		return dp[n-1];
	}

	private static int findOptimal(int num){
		if(num<7)
			return num;
		
		int max = 0;
		int b;
		for(b=num-3;b>=1;b--){
			int curr = (num-b-1)*findOptimal(b);
			if(curr>max)
				max=curr;	
		}
		
		return max;
	}

}
