package com.practice.DS.arrays;

public class FindIslands {

	public static void main(String[] args) {
		int M[][]=  new int[][] {{1, 1, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {1, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1}};
            
            System.out.println(countIslands(M));
	}
		
		private static int countIslands(int[][] mat){
			boolean visited[][] = new boolean[mat.length][mat.length];
			int count=0;
			for(int i=0;i<mat.length;i++){
				for(int j=0;j<mat.length;j++){
					DFS(mat, i, j, visited);
					count++;
				}
			}
				return count;	
		}
		
		private static void DFS(int[][] mat, int row, int col, boolean[][] visited){
			int rNbr[] = {-1, -1, -1,  0, 0,  1, 1, 1};
			int cNbr[] = {-1,  0,  1, -1, 1, -1, 0, 1};
			visited[row][col] = true;
			
			for (int k = 0; k < 8; ++k){
	            if (isSafe(mat, row + rNbr[k], col + cNbr[k], visited) )
	                DFS(mat, row + rNbr[k], col + cNbr[k], visited);
			}
		}
		
		static boolean isSafe(int mat[][], int row, int col, boolean visited[][]){
			return (row >= 0) && (row < mat.length) &&
		               (col >= 0) && (col < mat.length) &&
		               (mat[row][col]==1 && !visited[row][col]);
		}

}
