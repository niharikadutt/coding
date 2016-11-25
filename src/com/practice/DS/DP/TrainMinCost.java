package com.practice.DS.DP;

public class TrainMinCost {
	
	private static int MAX_INT = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int[][] cost = {{0, 15, 80, 90},
                {MAX_INT, 0, 40, 50},
                {MAX_INT, MAX_INT, 0, 70},
                {MAX_INT, MAX_INT, MAX_INT, 0}};
		System.out.println(printMinPathCost(cost, 0, cost.length-1));
		//System.out.println(printMinCost(cost, 0, cost.length-1));
	}
	
	private static int printMinPathCost(int[][] cost, int s, int d){
		int[] dist = new int[cost.length];
		
		for(int i=0;i<cost.length;i++){
			dist[i] = Integer.MAX_VALUE;
		}
		dist[0]=0;
		
		for(int i=0;i<cost.length;i++){
			for(int j=i+1;j<cost.length;j++){
				if(dist[j]>dist[i]+cost[i][j]){
					dist[j]=dist[i]+cost[i][j];
				}
			}
		}		
		return dist[cost.length-1];
	}
	
	private static int printMinCost(int[][] cost, int s, int d){
		if(s==d || s+1==d){
			return cost[s][d];
		}
		
		int min = cost[s][d];
		
		for(int i=s+1;i<d;i++){
			int c = printMinCost(cost, s,i)+printMinCost(cost, i, d);
			if(c<min){
				min = c;
			}
		}
		
		return min;
	}

}
