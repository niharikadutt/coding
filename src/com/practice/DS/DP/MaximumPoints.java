package com.practice.DS.DP;

public class MaximumPoints {
	private static int R=5;
	private static int C=4;
	

	public static void main(String[] args) {
		int ar[][] = {{3, 6, 8, 2},
                {5, 2, 4, 3},
                {1, 1, 20, 10},
                {1, 1, 20, 10},
                {1, 1, 20, 10},
               };
		System.out.println(getMaxCollection(ar));
	}
	
	private static int getMaxCollection(int[][] ar){
		int table[][][]=new int[R][C][C];
		for(int i=0;i<R;i++){
			for(int j=0;j<C;j++){
				for(int k=0;k<C;k++){
					table[i][j][k]=-1;
				}
			}
		}
		return getMax(ar, table, 0,0,C-1);
	}
	
	private static int getMax(int[][] ar, int[][][] table, int x, int y1, int y2){
		if(!isValid(x, y1, y2))
			return Integer.MIN_VALUE;
		if(x==R-1 && y1==0 && y2==C-1)
			return ar[x][y1]+ar[x][y2];
		
		if(x==R-1)
			return Integer.MIN_VALUE;
		
		if(table[x][y1][y2]!=-1) return table[x][y1][y2];
		
		int ans = Integer.MIN_VALUE;
		
		int temp=(y1 == y2)? ar[x][y1]: ar[x][y1] + ar[x][y2];
		
		 ans = Integer.max(ans, temp + getMax(ar, table, x+1, y1, y2-1));
		    ans = Integer.max(ans, temp + getMax(ar, table, x+1, y1, y2+1));
		    ans = Integer.max(ans, temp + getMax(ar, table, x+1, y1, y2));
		 
		    ans = Integer.max(ans, temp + getMax(ar, table, x+1, y1-1, y2));
		    ans = Integer.max(ans, temp + getMax(ar, table, x+1, y1-1, y2-1));
		    ans = Integer.max(ans, temp + getMax(ar, table, x+1, y1-1, y2+1));
		 
		    ans = Integer.max(ans, temp + getMax(ar, table, x+1, y1+1, y2));
		    ans = Integer.max(ans, temp + getMax(ar, table, x+1, y1+1, y2-1));
		    ans = Integer.max(ans, temp + getMax(ar, table, x+1, y1+1, y2+1));
		
	  return (table[x][y1][y2]=ans);	
	}
	
	private static boolean isValid(int x, int y1, int y2){
		return (x>=0 && x <=R && y1>=0 && y2 >=0 && y1 <=C && y2<=C);
	}

}
