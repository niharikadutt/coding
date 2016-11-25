package com.practice.DS.matrix;

public class TurnImage {

	public static void main(String[] args) {
		int[][] mat = {{1,2,3,4}, 
                      {5,6,7,8},
                      {9,10,11,12}};
		
		int n=mat.length;
		int m=mat[0].length;
		int[][] des = new int[m][n];
		rotateImage(mat, des, n, m);
	}

	private static void rotateImage(int[][] mat, int[][] des, int n, int m) {
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				des[j][n-i-1] = mat[i][j];
			}
		}
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				System.out.print(des[i][j]+" ");
			}
			System.out.println();
		}
	}

}
