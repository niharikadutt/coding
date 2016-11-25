package com.practice.DS.DP;

public class WordSplitProblem {

	public static void main(String[] args) {
		int l[] = {3, 2, 2, 5};
		int n=l.length;
		int m=6;
		
		solveWordWrapProblem(l, n, m);
	}	
	private static void solveWordWrapProblem(int[] l, int n, int m){
		int extras[][] = new int[n+1][n+1];		
		int lc[][] = new int[n+1][n+1];
		int c[] = new int[n+1];
		int p[] = new int[n+1];

		
		for(int i=1;i<=n;i++){
			extras[i][i] = m-l[i-1];
			for(int j=i+1;j<=n;j++){
				extras[i][j] = extras[i][j-1]-l[j-1]-1;
			}
		}
		
		for(int i=1;i<=n;i++){
			for(int j=i;j<=n;j++){
				if(extras[i][j]<0){
					lc[i][j] = Integer.MAX_VALUE;
				}
				 else if (j == n && extras[i][j] >= 0)
		                lc[i][j] = 0;
		        else
		                lc[i][j] = extras[i][j]*extras[i][j];
				
			}
		}
		
		c[0]=0;
		for(int j=1;j<=n;j++){
			c[j] = Integer.MAX_VALUE;
			for(int i=1;i<=j;i++){
				if (c[i-1] != Integer.MAX_VALUE && lc[i][j] != Integer.MAX_VALUE && (c[i-1] + lc[i][j] < c[j]))
	            {
	                c[j] = c[i-1] + lc[i][j];
	                p[j] = i;
	            }
			}
		}
		
		printSolution(p, n);
		
	}
	private static int printSolution (int p[], int n)
	{
	    int k;
	    if (p[n] == 1)
	        k = 1;
	    else
	        k = printSolution (p, p[n]-1) + 1;
	    System.out.println("Line number: "+k+": From word no."+p[n]+" to "+n+" \n");
	    return k;
	}
}
