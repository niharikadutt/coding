package com.practice.DS.DP;

public class CommonSupersequence {

	public static void main(String[] args) {
		String str1="geek", str2="eke";
		
	//	printLCS(str1, str2);
		
		System.out.println(shortestSuperquence(str1, str2));
	}
	
	private static void printLCS(String str1, String str2){
		int m=str1.length();
		int n=str2.length();
		int[][] L=new int[m+1][n+1];
		int i,j;
		
		for(i=0;i<m;i++){
			for(j=0;j<n;j++){
				if(i==0 || j==0)
					L[i][j]=0;
				
				else if(str1.charAt(i-1)==str2.charAt(j-1)){
					L[i][j]=1+L[i-1][j-1];
				}
				else{
					L[i][j] = Integer.max(L[i-1][j], L[i][j-1]);
				}				
			}
		}
		
		int index=L[m][n];
		char[] ar=new char[index];
		
		i=m;j=n;
		while(i>0&&j>0){
			if(str1.charAt(i-1)== str2.charAt(j-1)){
				ar[index-1]=str1.charAt(i-1);
				i--;j--; index--;
			}
			else if(L[i-1][j]>L[i][j-1]){
				i--;
			}
			else
				j--;
		}
		
		for(int x=0;x<index;x++){
			System.out.print(ar[x]);
		}
		
	}
	
	private static int shortestSuperquence(String str1, String str2){
		int m=str1.length();
		int n=str2.length();
		
		int l = lcs(str1,str2,m,n);
		
		return (m+n-l);
	}
	
	private static int lcs(String str1, String str2, int n, int m){
		int[][] L=new int[m+1][n+1];
		int i,j;
		
		for(i=0;i<m;i++){
			for(j=0;j<n;j++){
				if(i==0 || j==0)
					L[i][j]=0;
				
				else if(str1.charAt(i-1)==str2.charAt(j-1)){
					L[i][j]=1+L[i-1][j-1];
				}
				else{
					L[i][j] = Integer.max(L[i-1][j], L[i][j-1]);
				}				
			}
		}
		return L[m][n];
	}

}
