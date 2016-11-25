package com.practice.DS.matrix;

public class CountZeros {
	

	public static void main(String[] args) {
		int[][] mat = {
		        { 0, 0, 0, 0, 1 },
		        { 0, 0, 0, 1, 1 },
		        { 0, 1, 1, 1, 1 },
		        { 1, 1, 1, 1, 1 },
		        { 1, 1, 1, 1, 1 }
		    };
		
		System.out.println(countZeros(mat, mat.length,mat[0].length));
	}

	private static int countZeros(int[][] mat, int n, int m) {
		int i=n-1, j=0;
		int count=0;
		
		while(i>0 && j<m){
			while(mat[i][j]==1){
				if(--i<0){
					return count;
				}
			}
			count+=(i+1);
			j++;
			
		}
		
		return count;
	}

}
