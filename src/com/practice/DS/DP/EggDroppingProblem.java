package com.practice.DS.DP;

public class EggDroppingProblem {

	public static void main(String[] args) {
		int n=2,k=10;
		System.out.println("Minimum Number of trials : "+getMinimumTrials(n,k));
		
	}	
	private static int getMinimumTrials(int n,int k){
		int[][] eggDrop = new int[n+1][k+1];
		
		for(int i=1;i<=n;i++){
			eggDrop[i][1] = 1;
			eggDrop[i][0] = 0;
			
		}
		
		for(int i=1;i<=k;i++){
			eggDrop[1][i] = i;
		}
		
		for(int i=2;i<=n;i++){
			for(int j=2;j<=k;j++){
				eggDrop[i][j] = Integer.MAX_VALUE;
				for(int x=1;x<=j;x++){
					eggDrop[i][j] = Integer.max(eggDrop[i-1][x-1], eggDrop[i][j-x]);
				}
			}
		}
		
		return eggDrop[n][k];
	}

}
