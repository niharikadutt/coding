package com.practice.DS.matrix;

public class MaximumSnakeLength {
	
	private static int maxLen = Integer.MIN_VALUE;
	private static int maxR = 0;
	private static int maxC = 0;
	

	public static void main(String[] args) {
		int[][] mat = {
		        {9, 6, 5, 2},
		        {8, 7, 6, 5},
		        {7, 3, 1, 6},
		        {1, 1, 1, 7},
		    };
		
		findMaximumSnakeLength(mat, mat.length, mat[0].length);			
	}

	private static void findMaximumSnakeLength(int[][] mat, int n, int m) {
		int[][] dp = new int[n][m];

		dp[0][0] = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i > 0) {
					if (Math.abs(mat[i][j]-mat[i - 1][j]) == 1) {
						dp[i][j] = dp[i - 1][j] + 1;
					}
					if (maxLen < dp[i][j]) {
						maxLen = dp[i][j];
						maxR = i;
						maxC = j;
					}
				}
				if (j > 0) {
					if (Math.abs(mat[i][j]-mat[i][j - 1])== 1) {
						dp[i][j] = dp[i][j - 1] + 1;
					}
					if (maxLen < dp[i][j]) {
						maxLen = dp[i][j];
						maxR = i;
						maxC = j;
					}
				}

			}
		}
		
		
		System.out.println("Maximum Length--"+maxLen);
		
		
	}
}
