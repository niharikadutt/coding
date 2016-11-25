package com.practice.DS.arrays;

import java.util.Scanner;

public class SkyScrappers {

	public static void main(String[] args) {
		Scanner scc = new Scanner(System.in);
		int n = Integer.parseInt(scc.nextLine());
		String[] str = scc.nextLine().split(" ");
		int[] H = new int[n];
		for(int i=0;i<n;i++){
			H[i] = Integer.parseInt(str[i]);
		}
		
		int[] sx = new int[n];
		int[] sc = new int[n];
		int stp = 0;
		long ans = 0;
		for (int i = 0; i < n; ++i) {
		    int x = H[i];
		    while (stp > 0 && x > sx[stp - 1]) {
		        --stp;
		    }
		    if (stp > 0 && x == sx[stp - 1]) {
		        ans += sc[stp - 1];
		        sc[stp - 1]++;
		    } else {
		        sx[stp] = x;
		        sc[stp] = 1;
		        stp++;
		    }
		}
		System.out.println(2 * ans);
		
	}
	
//	private static int countPaths(int[] ar){
//		int i=0, j=1;
//		int n = ar.length;
//		int count=0;
//		while(i<n){
//			while(j<n && ar[j]<=ar[i]){
//				j++;
//			}
//			j--;
//			count++;
//			while(j>i && ar[--j]==ar[i]){
//				count++;
//			}
//			
//			i++;
//			
//		}
//		
//		return count*2;
		
		
//	}

}




































































