package com.practice.DS.DP;

public class CountNumberOfWaysForScore {

	public static void main(String[] args) {
		System.out.println(countWays(20));
	}
	
	private static int countWays(int n){
		int table[] = new int[n+1];
		table[0]=1;
		int i=0;
		for (i=3; i<=n; i++)

		       table[i] += table[i-3];

		    for (i=5; i<=n; i++)

		       table[i] += table[i-5];

		    for (i=10; i<=n; i++)

		       table[i] += table[i-10];
		    
		return table[n];
	}

}
