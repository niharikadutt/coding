package com.practice.DS.matrix;

public class Rotate90Degree {

	public static void main(String[] args) {
		int[][] mat = {
		        {1, 2, 3, 4},
		        {5, 6, 7, 8},
		        {9, 10, 11, 12},
		        {13, 14, 15, 16}
		    };
		
		rotateMatrix(mat);
	}

	private static void rotateMatrix(int[][] mat) {
		int n = mat.length;
		for(int i=0;i<n;i++){
			for(int j=i;j<n;j++){
				int temp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = temp;
			}
		}
		
		
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}

}
