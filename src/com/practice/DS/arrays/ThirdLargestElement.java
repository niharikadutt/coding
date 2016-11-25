package com.practice.DS.arrays;

public class ThirdLargestElement {

	public static void main(String[] args) {
		int ar[] = {12, 13, 1, 10, 34, 16, 34};
		System.out.println(getThirdLargestElement(ar));
	}
	
	private static int getThirdLargestElement(int ar[]){
		if(ar.length<3){
			System.out.println("Solution not possible!");
			return 0;
		}
		
		int first = ar[0], second=Integer.MIN_VALUE, third = Integer.MIN_VALUE;
	    for(int i=0;i<ar.length;i++){
	    	if(ar[i]==first || ar[i]==second || ar[i]==third){
	    		continue;
	    	}
	    	if(ar[i]>first){
	    		third = second;
	    		second = first;
	    		first = ar[i];
	    	}
	    	
	    	else if(ar[i]>second){
	    		third = second;
	    		second = ar[i];
	    	}
	    	else if(ar[i]>third){
	    		third = ar[i];
	    	}
	    }
	    
	    return third;
	}

}
