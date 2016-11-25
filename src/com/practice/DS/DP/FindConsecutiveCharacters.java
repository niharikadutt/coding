package com.practice.DS.DP;

public class FindConsecutiveCharacters {
	
	static int x[] = {0, 1, 1, -1, 1, 0, -1, -1};
    static int y[] = {1, 0, 1, 1, -1, -1, 0, -1};
    static int R = 3;
    static int C = 3;
    static int dp[][] = new int[R][C];

	public static void main(String[] args) {
		char[][] mat = { {'a','c','d'},
                { 'h','b','a'},
                { 'i','g','f'}};
		
		System.out.println(getLen(mat, 'a'));
	}
	
	private static int getLen(char[][] mat, char s){
		 for(int i = 0;i<R;++i)
	            for(int j = 0;j<C;++j)
	                dp[i][j] = -1;
		 
		 
		 int ans=0;
		 for(int i = 0;i<R;++i){
	            for(int j = 0;j<C;++j){
	            	if(mat[i][j]==s){
	            		
	            		for(int k=0;k<8;k++){
	            			ans = Math.max(ans , 1+getlenUtil(mat, i+x[k], j+y[k], s));
	            		}
	            	}
	            }
		 }
		 
		 return ans;
	}
	
	
	private static int getlenUtil(char[][] mat, int i, int j, char s){
		if(!isValid(i, j)|| !isConsecutive(s, mat[i][j])){
			return 0;
		}
		
		if(dp[i][j]!=-1)
			return dp[i][j];
		
		int ans=0;
		for (int k=0; k<8; k++)
		      ans = Math.max(ans, 1 + getlenUtil(mat, i + x[k],
		                                   j + y[k], mat[i][j]));
		 
		    return dp[i][j] = ans;
	}
	
	private static boolean isValid(int i, int j){
		 if (i < 0 || j < 0 || i >= R || j >= C)
		      return false;
		    return true;
	}
	
	private static boolean isConsecutive(char prev, char curr){
		return ((curr - prev) == 1);
	}

}
