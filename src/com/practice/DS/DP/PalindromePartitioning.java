package com.practice.DS.DP;

public class PalindromePartitioning {

	public static void main(String[] args) {
		char[] ar = "abcbm".toCharArray();
		System.out.println("Minimum Cuts : "+minimumCuts(ar, ar.length));
	}

	
	private static int minimumCuts(char[] ar, int n){
		boolean[][] p = new boolean[n][n];
		int[][] c = new int[n][n];		
		for(int i=0;i<n;i++){
			p[i][i] = true;
			c[i][i] = 0;
		}
		
		for(int L=2;L<=n;L++){
			for(int i=0;i<n-L+1;i++){
				int j = i+L-1;
				
				if(L==2){
					p[i][j] = (ar[i]==ar[j]);
				}
				else{
					p[i][j] = (ar[i]==ar[j]) && p[i+1][j-1];
				}
				
				if(p[i][j]){
					c[i][j] = 0;
				}
				else{
					c[i][j]=Integer.MAX_VALUE;
					for(int k=i;k<j;k++){
						c[i][j] = Math.min(c[i][k]+c[k+1][j]+1, c[i][j]);
					}
				}
			}
			
		}
		return c[0][n-1];
	}

}
