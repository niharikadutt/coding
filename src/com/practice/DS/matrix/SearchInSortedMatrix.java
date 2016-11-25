package com.practice.DS.matrix;

public class SearchInSortedMatrix {

	public static void main(String[] args) {
		int[][] mat = { {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50},
              };
		
		search(mat, mat.length, mat[0].length, 29);
	}

	private static void search(int[][] mat, int n, int m, int k) {
		int i=0, j=m-1;
		
		while(i>=0 && j>=0 && i<n && j<m){
				if(mat[i][j]==k){
					System.out.println("Found!");
					return;
				}
				
				if(mat[i][j]>k){
					j--;
				}
				else{
					i++;
				}
		}
		
		System.out.println("Not Found!");
	}

}
