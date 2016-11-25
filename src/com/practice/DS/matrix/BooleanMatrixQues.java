package com.practice.DS.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class BooleanMatrixQues {

	public static void main(String[] args) {
		int[][] mat = { {1, 0, 0, 1},
		        {0, 0, 1, 0},
		        {0, 0, 0, 0},
		    };
		
		mat = getModifiedMatrix(mat, mat.length, mat[0].length);
		
		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat[0].length;j++){
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static int[][] getModifiedMatrix(int[][] mat, int n, int m) {
		Queue<QNode> q = new LinkedList<>();
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(mat[i][j]==1){
					q.add(new QNode(i, j));
				}
			}
		}
		
		while(!q.isEmpty()){
			QNode curr = q.poll();
			for(int i=0;i<n;i++){
				mat[i][curr.getY()] = 1;
			}
			
			for(int i=0;i<n;i++){
				mat[curr.getX()][i] = 1;
			}
		}
		
		return mat;
	}

}
class QNode{
	int x;
	int y;
	
	public QNode(int x, int y) {
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
