package com.practice.DS.arrays;

import java.util.Arrays;

public class NutsAndBolts {

	public static void main(String[] args) {
		char nuts[] = {'@', '#', '$', '%', '^', '&'};
        char bolts[] = {'$', '%', '&', '^', '@', '#'};
        
        Arrays.sort(nuts);
        Arrays.sort(bolts);
        
       for(int i=0;i<nuts.length;i++){
    	   System.out.println(nuts[i]+"-"+bolts[i]);
       }
	}

}
