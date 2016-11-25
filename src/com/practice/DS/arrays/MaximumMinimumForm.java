package com.practice.DS.arrays;

public class MaximumMinimumForm {

	public static void main(String[] args) {
		int ar[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		//rearrange1(ar, ar.length);
		
		rearrange2(ar, ar.length);
	}
	
	private static void rearrange2(int[] ar, int n){
		int max = n-1;
		int largest=ar[n-1]+1;
		int min = 0;
		
		for(int i=0;i<n;i++){
			if(i%2==0){
				ar[i] = (ar[max]%largest)*largest+ar[i];
				max--;
			}else{
		         ar[i]=(ar[min]%largest)*largest+ar[i];
		         min++;
		      }
			}
		
		
		for(int i=0;i<n;i++){
			ar[i]/=largest;
			System.out.println(ar[i]);
		}
		}
	
	private static void rearrange1(int[] ar, int n){
		for(int i=0;i<n;i++){
			int temp = ar[i];
			
			while(temp>0){
				int j = (i<n/2)?2*i+1:2*(n-1-i);
				
				if(i==j){
					ar[i] = -temp;
					break;
				}
				
				int t = temp;
				temp = ar[j];
				ar[j]=t;
				
				ar[j] = -ar[j];
				
				i=j;
			}
			
		}	
			for(int k=0;k<n;k++){
				System.out.println(-ar[k]);
			}
	}

}
