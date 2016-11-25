package com.practice.DS.matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GuardBank {
	
	private static int[] ROW = {-1, 0, 1, 0};
	private static int[] COL = {0, 1, 0, -1};

	public static void main(String[] args) {
		char mat[][] = {
		        {'O', 'O', 'O', 'O', 'G'},
		        {'O', 'W', 'W', 'O', 'O'},
		        {'O', 'O', 'O', 'W', 'O'},
		        {'G', 'W', 'W', 'W', 'O'},
		        {'O', 'O', 'O', 'O', 'G'}
		    };
		
		findDistance(mat);
	}

	private static void findDistance(char[][] mat) {
		int n = mat.length;
		int m = mat[0].length;
		Queue<Block> q = new LinkedList<>();
		int[][] output = new int[n][m];
		
		for(int i=0;i<n;i++){
			Arrays.fill(output[i], -1);
		}
		
		
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(mat[i][j]=='G'){
					q.add(new Block(i, j, 0));
					output[i][j] = 0;
				}
			}
		}
		
		while(!q.isEmpty()){
			Block block = q.poll();
			int x = block.getI();
			int y = block.getJ();
			int dis = block.getData();
		
			for(int k=0;k<4;k++){
				if(isValid(x+ROW[k], y+COL[k], n, m) && isSafe(x+ROW[k], y+COL[k], mat, output)){
					output[x+ROW[k]][y+COL[k]] = dis+1;
					q.add(new Block(x+ROW[k], y+COL[k], dis+1));
				}
			}		
		}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				System.out.print(output[i][j]+" ");
			}
			System.out.println();}
	}

	private static boolean isSafe(int i, int j, char[][] mat, int[][] output) {
		if(mat[i][j]!='O' || output[i][j]!=-1){
			return false;
		}
		return true;
	}

	private static boolean isValid(int i, int j, int n, int m) {
		if(i<0||j<0||i>=n||j>=m){
			return false;
		}
		return true;
	}
	
	

}

class Block{
	int i;
	int j;
	int data;
	
	public Block(int i, int j, int data) {
		super();
		this.i = i;
		this.j = j;
		this.data = data;
	}
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
	
}
