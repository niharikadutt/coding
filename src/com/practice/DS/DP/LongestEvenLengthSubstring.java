package com.practice.DS.DP;

public class LongestEvenLengthSubstring {

	public static void main(String[] args) {
		char[] str = "153803".toCharArray();
		System.out.println(getLongestSubstring(str));
	}

	private static int getLongestSubstring(char[] str) {
		int n = str.length;
		int[][] dp = new int[n][n];
		
		int maxLen = Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++){
			dp[i][i] = str[i]-'0';
		}
		
		for(int len=2;len<=n;len++){
			for(int i=0;i<n-len+1;i++){
				int j=i+len-1;
				int k=len/2;
				
				dp[i][j] = dp[i][j-k]+dp[j-k+1][j];
				
				
				if(len%2==0 && dp[i][j-k]==dp[j-k+1][j] && len>maxLen){
					maxLen = len;
				}
			}
		}
		
		return maxLen;
	}

}
