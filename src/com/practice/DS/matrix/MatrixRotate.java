package com.practice.DS.matrix;

public class MatrixRotate {

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3, 4 }, 
				        { 5, 6, 7, 8 }, 
				        { 9, 10, 11, 12 }, 
				        { 13, 14, 15, 16 } };

		rotate(mat, mat.length, mat[0].length);

	}

	static void rotate(int matrix[][], int n, int m) {
		int i, j;

		for (i = 0; i < n - 1; ++i) {
			for (j = i + 1; j < m; ++j) {
				matrix[i][j] ^= matrix[j][i];
				matrix[j][i] ^= matrix[i][j];
				matrix[i][j] ^= matrix[j][i];
			}
		}
		
		for(i=0;i<n;i++){
			for(j=0;j<m;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

}
