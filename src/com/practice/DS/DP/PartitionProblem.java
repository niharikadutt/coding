package com.practice.DS.DP;

public class PartitionProblem {

	public static void main(String[] args) {
		int[] ar = {3, 1, 1, 2, 2, 1};
		int n=ar.length;
		
		System.out.println(findPartition(ar, n));
	}

	private static boolean findPartition(int ar[], int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += ar[i];
		}

		if (sum % 2 != 0)
			return false;
		
		boolean[][] partition = new boolean[sum / 2 + 1][n + 1];

		// initialize top row as true
		for (int i = 0; i <= n; i++)
			partition[0][i] = true;

		// initialize leftmost column, except part[0][0], as 0
		for (int i = 1; i <= sum / 2; i++)
			partition[i][0] = false;
		
		
		for(int i=1;i<=sum/2;i++){
			for(int j=1;j<=n;j++){
				partition[i][j] = partition[i][j-1];
				if(i>=ar[j-1]){
					partition[i][j] = partition[i][j] ||
							partition[i - ar[j-1]][j-1];
				}
			}
		}
		
		for(int i=0;i<=sum/2;i++){
			for(int j=0;j<=n;j++){
				System.out.print(partition[i][j]+" ");
			}
			System.out.println();
		}
		return partition[sum/2][n];
	}

}
