package com.practice.DS.matrix;

public class MaximumSizeSubmatrix {

	public static void main(String[] args) {
		int[][] mat = {{0, 1, 1, 0, 1}, 
                {1, 1, 0, 1, 0}, 
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};
		
		System.out.println(maximumSizeSubmatrix(mat));
	}

	private static int maximumSizeSubmatrix(int[][] mat) {
		int n = mat.length;
		int m = mat[0].length;
		int[][] dp = new int[n][m];
		
		dp[0][0] = mat[0][0];
		for(int i=1;i<n;i++){
			if(dp[i][0]==1){
				dp[i][0] = mat[i][0]+dp[i-1][0];
			}
			else{
				dp[i][0]=0;
			}
		}
		
		for(int j=1;j<m;j++){
			if(dp[0][j]==1){
				dp[0][j] = mat[0][j]+dp[0][j-1];
			}
			else{
				dp[0][j]=0;
			}
		}
		
		for(int i=1;i<n;i++){
			for(int j=1;j<m;j++){
				if(mat[i][j]==1){
				dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+mat[i][j];
				}
				else
					dp[i][j] = 0;
			}
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(dp[i][j]>max)
					max = dp[i][j];
			}
		}
		
		return max;
	}

}
