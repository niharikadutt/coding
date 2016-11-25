package com.practice.DS.matrix;

public class ToeplitzMatrix {

	public static void main(String[] args) {
		int[][] mat =  {
		        { 6, 7, 8, 9 },
		        { 4, 6, 7, 8 },
		        { 1, 4, 6, 7 },
		        { 0, 1, 4, 6 },
		        { 2, 2, 1, 4 }
		    };
		
		System.out.println(checkIfToeplitz(mat, mat.length, mat[0].length));
	}

	private static boolean checkIfToeplitz(int[][] mat, int n, int m) {
		for(int i=0;i<n;i++){
			if(!checkDiagonal(mat, i, 0))
				return false;
		}
		
		for(int j=1;j<m;j++){
			if(!checkDiagonal(mat, 0, j))
				return false;
		}
		
		return true;
	}
	
	private static boolean checkDiagonal(int[][] mat, int i, int j){
		int res = mat[i][j];
		while(++i<mat.length-1 && ++j<mat.length-1){
			if(mat[i][j]!=res){
				return false;
			}
		}
		
		return true;
	}

}
