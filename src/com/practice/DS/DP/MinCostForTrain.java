package com.practice.DS.DP;

public class MinCostForTrain {

	public static void main(String[] args) {
		int[][] cost = { {0, 15, 80, 90},

                {Integer.MAX_VALUE, 0, 40, 50},

                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 70},

                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}

              };
		
		System.out.println(getMinCost(cost));
	}
	
	private static int getMinCost(int[][] cost){
		int n = cost.length;
		int[] dis = new int[n];
		dis[0] = 0;
		
		for(int i=1;i<n;i++)
			dis[i] = Integer.MAX_VALUE;
		
		
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				if(dis[j]>dis[i]+cost[i][j]){
					dis[j] = dis[i]+cost[i][j];
				}
			}
		}
		
		return dis[n-1];
	}

}
