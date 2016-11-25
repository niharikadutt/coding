package com.practice.DS.DP;

public class CoinChangeProblem {

	public static void main(String[] args) {
		int S[]={2, 5, 3, 6};
		System.out.println(count(S, S.length, 10));
		//System.out.println(minCoins(S, S.length, 11));
	}
	
	
	private static int minCoins(int[] S, int l, int sum){
		if(sum==0)
			return 0;
		
		int res = Integer.MAX_VALUE;
		for(int i=0;i<l;i++){
			if(S[i]<=sum){
			int subRes = minCoins(S, l, sum-S[i]);
			
			if(subRes+1<res){
				res = subRes+1;
			}
			
			}
		}
		
		return res;
	}
	
	private static int count(int[] S, int m, int n){
		int[][] table = new int[n+1][m];
		for(int i=0;i<m;i++){
			table[0][i]=1;
		}
		
		for(int i=1;i<=n;i++){
			for(int j=0;j<m;j++){
				int x = (i-S[j]>=0)?table[i-S[j]][j]:0;
				int y = (j>0)?table[i][j-1]:0;
				
				table[i][j] = x+y;
			}
		}
		
		return table[n][m-1];
	}

}
