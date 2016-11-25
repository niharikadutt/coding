package com.practice.DS.DP;

public class PossibleBuildings {

	public static void main(String[] args) {
		System.out.println(findPossibleWays(3));
	//	System.out.println(findPossibleWaysNlogN(3));
	}
	
//	private static int findPossibleWaysNlogN(int n){
//		
//	}
	
	private static int findPossibleWays(int n){
		if(n==1)
			return 4;
		
		int countB=1, countS=1, prevCountB, prevCountS;
		
		for(int i=2;i<=n;i++){
			prevCountB = countB;
			prevCountS = countS;
			countB = prevCountS;
			countS = prevCountB+prevCountS;
		}
		
		int result = countB+countS;
		
		return result*result;
	}

}
