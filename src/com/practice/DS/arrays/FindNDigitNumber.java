package com.practice.DS.arrays;

public class FindNDigitNumber {

	public static void main(String[] args) {
		int n=2, sum=3;
		findNDigit(n, sum);
	}
	
	private static void findNDigit(int n, int sum){
		int[] out=new int[n+1];
		for(int i=0;i<=9;i++){
			out[0]=i;
			findNDigitUtil(n,sum-i,out,1);
		}		
	}
	
	private static void findNDigitUtil(int n, int sum, int[] out, int index){
		if(index>n || sum<0)
			return;
		
		if(index==n){
			if(sum==0){
				for(int i=0;i<out.length-1;i++){
					System.out.print(out[i]);
				}
				System.out.println();
			}
			return;
		}
		
		for(int i=0;i<=9;i++){
			out[index]=i;
			findNDigitUtil(n, sum-i, out, index+1);
		}
	}

}
