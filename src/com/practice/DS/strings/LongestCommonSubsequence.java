package com.practice.DS.strings;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		char[] ar1 = "AGGTAB".toCharArray();
		char[] ar2 = "GXTXAYB".toCharArray();
		
		System.out.println(getLCS(ar1, ar2));
	}
	
	private static int getLCS(char[] ar1, char[] ar2){
		int n = ar1.length, m=ar2.length;
		int table[][] = new int[n+1][m+1];
		
		for(int i=0;i<=n;i++){
			for(int j=0;j<=m;j++){
				if(i==0 || j==0)
					table[i][j] = 0;
				
				else if (ar1[i-1]==ar2[j-1])
					table[i][j] = table[i-1][j-1]+1;
				
				else
					table[i][j]=Math.max(table[i-1][j], table[i][j-1]);	
			}
		}
		
		return table[n][m];
	}

}
