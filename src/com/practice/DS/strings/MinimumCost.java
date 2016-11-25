package com.practice.DS.strings;

public class MinimumCost {

	public static void main(String[] args) {
		String str1 = "abcd";
		String str2 = "acdb";
		
		int cost1 = 10;
		int cost2 = 20;
		
		System.out.println(getMinimumCost(str1, str2, cost1, cost2));

	}

	private static int getMinimumCost(String str1, String str2, int cost1, int cost2) {
		int res = 0;
		int l1 = str1.length();
		int l2 = str2.length();
		int cost[][] = new int[l1][l2];
		
		for(int i=0;i<l1;i++){
			for(int j=0;j<l2;j++){
				if(i==0 || j==0){
					cost[i][j] = 0;
				}
				else if(str1.charAt(i)==str2.charAt(j)){
					cost[i][j] = cost[i-1][j-1]+1;
				}
				else{
					cost[i][j] = Math.max(cost[i-1][j], cost[i][j-1]);
				}
			}
		}
		
		res+=(l1-cost[l1-1][l2-1])*cost1+(l2-cost[l1-1][l2-1])*cost2;
		
		return res;
	}

}
