package com.practice.DS.matrix;

public class MinHeap {
	private static int size;
	private static int[] ar;
	private static int pos;
	
	public MinHeap(int size){
		this.size = size;
		ar = new int[size+1];
		pos = 0;
	}
	
	public void create(int arr[]){
		if(arr.length>0){
			for(int i=0;i<arr.length;i++){
				insert(arr[i]);
			}
		}
	}

	public void insert(int ele) {
		if(pos==0){
			ar[1] = ele;
			pos =2;
		}
		else{
			ar[pos++] = ele;
			percolateUp();
		}
	}
	
	public int extractMin(){
		int min= ar[1];
		ar[1] = ar[pos-1];
		percolateDown(1);
		
		return min;
	}

	private void percolateDown(int i) {
		int smallest = i;
		if(2*i<pos && ar[2*i]<ar[i]){
			smallest = 2*i;
		}
		
		if(2*i+1<pos && ar[2*i+1]<ar[i]){
			smallest = 2*i+1;
		}
		
		if(smallest!=i){
			int temp = ar[smallest];
			ar[smallest] = ar[i];
			ar[i] = temp;
			percolateDown(smallest);
		}
		
	}

	private void percolateUp() {
		int position = pos-1;
		while(position>0 && ar[position/2]>ar[position]){
			int temp = ar[position/2];
			ar[position/2] = ar[position];
			ar[position] = temp;
			
			position = position/2;
		}
		
	}

	public static void main(String[] args) {
		int arrA [] = {3,2,1,7,8,4,10,16,12};
		MinHeap heap = new MinHeap(arrA.length);
		
		heap.create(arrA);
		
		for(int i=0;i<arrA.length;i++){
			System.out.println(heap.extractMin());
		}
		
	}

}
