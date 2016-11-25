package com.practice.DS.arrays;

public class AlmostPrimeNumber {

	public static void main(String[] args) {
		int n = 10;
		int k = 2;
		printPrimeNumbers(n,k);
	}
	
	private static void printPrimeNumbers(int n, int k){
		for(int i=1,num=2;i<=n;num++){
			if(countPrimeFactors(num)==k){
				System.out.println(num);
				i++;
			}
		}
		
	}
	
	private static int countPrimeFactors(int num){
		int count = 0;
		while(num%2==0){
			num=num/2;
			count++;
		}
		
		for(int i=3;i<=Math.sqrt(num);i=i+2){
			while(num%i==0){
				num=num/i;
				count++;
			}
		}
		
		if(num>2)
			count++;
		
		return count;
	}

}
