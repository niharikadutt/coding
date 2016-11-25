package com.practice.DS.arrays;

public class KthSmallest {

	public static void main(String[] args) {
		int ar[] = {12, 3, 5, 7, 4, 19, 26};
		System.out.println(findKthSmallest(ar, 0, ar.length-1, 3));
	}
	
	private static int findKthSmallest(int[] ar, int l, int r, int k){
		if(k>0 || k<=r-l+1){
			int pos=randomPartition(ar, l, r);
			
			if(pos-l==k-1){
				return ar[pos];
			}
			if(pos-l>k-1){
				findKthSmallest(ar, l, pos-1, k);
			}
			else{
				findKthSmallest(ar, pos+1, r,  k-pos+l-1);
			}
		}
		return Integer.MAX_VALUE;
		
	}
	
	private static int randomPartition(int ar[], int l, int r){
		int n=r-l+1;
		int pivot = (int)Math.random()%n;
		swap(ar, l+pivot, r);
		return partition(ar, l, r);
	}
	
	private static int partition(int[] ar, int l, int r){
		int x=ar[r], i=l;
		for(int j=l;j<=r;j++){
			if(ar[j]<=x){
				swap(ar, i, j);
				i++;
			}
		}
		swap(ar, i, r);
		return i;
	}
	
	private static void swap(int[] ar, int pivot, int r){
		int temp = ar[pivot];
		ar[pivot] = ar[r];
		ar[r] = temp;
	}
	
	

}
