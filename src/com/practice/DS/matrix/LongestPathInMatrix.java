package com.practice.DS.matrix;

import java.util.Arrays;

public class LongestPathInMatrix {
	
	private static int[] ROW = {-1, 0, 1, 0};
	private static int[] COL = {0, 1, 0, -1};
	
	private static int n = 3;
	private static int m = 3;
	
	private static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		int mat[][] =
		    {
		        { 1, 1, 1, 1},
		        { 1, 0, 0, 1},
		        { 1, 1, 1, 1}
		    };
		 
		Pointt source = new Pointt(0,0);
		Pointt dest = new Pointt(0,1);
		
		findShortestPath(mat, source, dest);
	}

	private static void findShortestPath(int[][] mat, Pointt source, Pointt dest) {
		boolean visited[][] = new boolean[n][m];
		for(int i=0;i<n;i++){
			Arrays.fill(visited[i], false);
		}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
					visited[i][j] = true;
					findShortestPathUtil(mat, visited, i, j,dest, 0);
			}
		}
		
		if(max!=Integer.MIN_VALUE){
			System.out.println(max);
		}
		else{
			System.out.println("Not exixts");
		}
		
	}

	private static void findShortestPathUtil(int[][] mat, boolean[][] visited, int i, int j, Pointt dest, int currDis) {
		if(i==dest.getX() && j==dest.getY()){
			if(currDis>max){
				max=currDis;
			}
			return;
		}
		
		visited[i][j] = true;
		
		for(int k=0;k<4;k++){
			if(isValid(i+ROW[k], j+COL[k]) && isSafe(mat, visited, i+ROW[k], j+COL[k])){
				findShortestPathUtil(mat, visited, i+ROW[k], j+COL[k], dest, currDis+1);
			}
		}
		visited[i][j] = false;
		
	}
	
	private static boolean isSafe(int[][] mat, boolean[][] visited, int i, int j) {
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

}

class Pointt{
	int x;
	int y;
	
	public Pointt(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}

