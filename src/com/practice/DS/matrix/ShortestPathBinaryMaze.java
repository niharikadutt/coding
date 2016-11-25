package com.practice.DS.matrix;

import java.util.Arrays;

public class ShortestPathBinaryMaze {
	
	private static int[] ROW = {-1, 0, 1, 0};
	private static int[] COL = {0, 1, 0, -1};
	
	private static int n = 9;
	private static int m = 10;
	
	private static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int[][] mat = {
		        { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
		        { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
		        { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
		        { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
		        { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
		        { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
		        { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
		        { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
		        { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }
		    };
		 
		Point source = new Point(0,0);
		Point dest = new Point(3,4);
		
		findShortestPath(mat, source, dest);
	}

	private static void findShortestPath(int[][] mat, Point source, Point dest) {
		boolean visited[][] = new boolean[n][m];
		for(int i=0;i<n;i++){
			Arrays.fill(visited[i], false);
		}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(i==source.getX() && j==source.getY()){
					visited[i][j] = true;
					findShortestPathUtil(mat, visited, i, j, dest, 0);
				}
			}
		}
		
		if(min!=Integer.MAX_VALUE){
			System.out.println(min);
		}
		else{
			System.out.println("Not exixts");
		}
		
	}

	private static void findShortestPathUtil(int[][] mat, boolean[][] visited, int i, int j, Point dest, int currDis) {
		if(i==dest.getX() && j==dest.getY()){
			if(currDis<min){
				min=currDis;
			}
			return;
		}
		
		if(currDis>min)
			return;
		
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

class Point{
	int x;
	int y;
	
	public Point(int x, int y) {
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
