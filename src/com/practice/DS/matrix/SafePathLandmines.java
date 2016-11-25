package com.practice.DS.matrix;

import java.util.Arrays;

public class SafePathLandmines {
	
	private static int n = 12;
	private static int m = 10;
	
	private static int min = Integer.MAX_VALUE;
	private static boolean visited[][] = new boolean[n][m];
	
	private static int[] ROW = { -1, 0, 0, 1 };
	private static int[] COL = { 0, -1, 1, 0 };

	public static void main(String[] args) {
		int mat[][] = {
		        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		        { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
		        { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
		        { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
		        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		        { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
		        { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
		        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		        { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
		        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		        { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 }
		    };
		
		findShortestPath(mat);
	}

	private static void findShortestPath(int[][] mat) {		
		for(int i=0;i<n;i++){
			Arrays.fill(visited[i], false);
		}
		
		mat = markAdjCellUnsafe(mat);
		
		for(int i=0;i<n;i++){
			if(mat[i][0]==1){
				visited[i][0] = true;
				findShotestPathUtil(mat, visited, i, 0, min, 0);
			}
		}
		
		
		
		if(min!=Integer.MAX_VALUE){
			System.out.println(min);
		}
		else{
			System.out.println("Path not available!");
		}
		
	}

	private static void findShotestPathUtil(int[][] mat, boolean[][] visited, int i, int j, int min, int dis) {
		if(j==m-1){
			if(dis<min){
				min = dis;
			}
			return;
		}
		
		if(dis>min)
			return;
		
		visited[i][j] = true;
		
		for(int k=0;k<4;k++){
			if(isValid(i+ROW[k], j+COL[k]) && isSafe(i+ROW[k], j+COL[k], mat, visited)){
				findShotestPathUtil(mat, visited, i+ROW[k], j+COL[k], min, dis+1);
			}
		}
		
		visited[i][j]=false;
	}

	private static boolean isSafe(int i, int j, int[][] mat, boolean[][] visited) {
		if(mat[i][j]==0 || visited[i][j]){
			return false;
		}
		return true;
	}

	private static boolean isValid(int i, int j) {
		if(i<0||j<0||i>=n||j>=m){
			return false;
		}
		return true;
	}

	private static int[][] markAdjCellUnsafe(int[][] mat) {
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(mat[i][j]==0){
					for(int k=0;k<4;k++){
						if(isValid(i+ROW[k], j+COL[k])){
						mat[i+ROW[k]][j+COL[k]] = -1;
						}
					}
				}
			}
		}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(mat[i][j]==-1){
					mat[i][j] = 0;
				}				
			}
		}
		return mat;
	}

}
