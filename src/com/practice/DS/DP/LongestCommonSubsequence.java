package com.practice.DS.DP;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		char[] X = "ABCD".toCharArray();
		char[] Y = "BDE".toCharArray();
		
		System.out.println(lcs(X,Y,X.length, Y.length));
	}

	private static int lcs(char[] x, char[] y, int l1, int l2) {
		int[][] lcs = new int[l1+1][l2+1];
		
		for(int i=0;i<=l1;i++){
			for(int j=0;j<=l2;j++){
				if(i==0 || j==0)
					lcs[i][j]=0;
				else if(x[i-1]==y[j-1])
					lcs[i][j] = lcs[i-1][j-1]+1;
				else
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
			}
		}
		
		return lcs[l1][l2];
	}

}
