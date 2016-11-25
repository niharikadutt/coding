package com.practice.DS.arrays;

import java.util.Scanner;

public class CountDisctinctOcurrences {
	
	private static int count = 0;

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int mat[][] = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j] = sc.nextInt();
            }
        }
        
        System.out.print(getNoOfCells(mat, n, m));
    }
    
    private static int getNoOfCells(int[][] mat, int n, int m){
        int max = 0;        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dfs(mat, i, j, n ,m);
                
                if(count>max){
                    max = count;
                }
                
                count=0;
            }
        }
        
        return max;
    }
    
    private static void dfs(int[][] mat,int i, int j,int n, int m){
        if(!isValid(mat, i, j, n, m)){
            return;
        }
        
        count++;
        mat[i][j] = -1;
        
        for(int k=-1;k<=1;k++){
            for(int l=-1;l<=1;l++){
                dfs(mat, i+k, j+l, n, m);
            }
        }
    }
    
    private static boolean isValid(int[][] mat,int i, int j,int n, int m){
    	if(i<0 || i>=n || j<0 || j>=m || mat[i][j]<1)
    		return false;
    	
    	return true;
    }

}
