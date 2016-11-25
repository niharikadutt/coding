package com.practice.DS.DP;

public class MinCost {

	public static void main(String[] args) {
		int[][] cost = {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};
		
		System.out.println(minCost(cost));
	}
	
	private static int minCost(int[][] cost){
		int[][] t = new int[3][3];
		
		t[0][0] = cost[0][0];
		for(int i=1;i<=2;i++){
			t[i][0] = t[i-1][0] + cost[i][0];
		}
		
		for(int j=1;j<=2;j++){
			t[0][j] = t[0][j-1] + cost[0][j];
		}
		
		for(int i=1;i<=2;i++){
			for(int j=1;j<=2;j++){
				t[i][j] = Math.min(t[i-1][j], Math.min(t[i][j-1], t[i-1][j-1]))+cost[i][j];
			}
		}
		
		return t[2][2];
		
	}

}
