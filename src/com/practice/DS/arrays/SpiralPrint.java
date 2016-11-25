package com.practice.DS.arrays;

public class SpiralPrint {
	
	private static int R = 3;
	private static int C = 6;

	public static void main(String[] args) {
		int[][] a = { {1,  2,  3,  4,  5,  6},
		        {7,  8,  9,  10, 11, 12},
		        {13, 14, 15, 16, 17, 18}
		    };
		
		printSpiral(a);
	}
	
	private static void printSpiral(int[][] a){
		int i,k=0,l=0,m=R, n=C;
		
		while(k<m && l<n){
			for(i=l;i<n;i++){
				System.out.print(a[k][i]);
			}
			
			k++;
			
			for(i=k;i<m;i++){
				System.out.print(a[k][i]);
			}	
			n--;
			
			if(k<m){
				for(i=n-1;i>=l;i--){
					System.out.print(a[k][i]);
				}
				
				m--;
			}
			
			if(l<n){
				for(i=m-1;i>=k;i--){
					System.out.print(a[k][i]);
				}
				
				l++;
			}
			
			
		}
	}

}
