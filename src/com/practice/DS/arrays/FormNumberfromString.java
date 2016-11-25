package com.practice.DS.arrays;

import java.util.ArrayList;
import java.util.List;

public class FormNumberfromString {

	public static void main(String[] args) {
		printLeast("DDIDDIID");

	}
	
	private static void printLeast(String str){
		char[] ar = str.toCharArray();
		int minAvail = 1, posOfI = 0;
		
		List<Integer> op = new ArrayList<>();
		
		//base case
		if(ar[0]=='I'){
			op.add(1);
			op.add(2);
			minAvail = 3;
			posOfI = 1;
		}else if(ar[0]=='D'){
			op.add(2);
			op.add(1);
			minAvail = 3;
			posOfI = 0;
		}
		
		for(int i=1;i<ar.length;i++){
			if(ar[i]=='I'){
				op.add(minAvail);
				minAvail++;
				posOfI = i+1;
			}
			else if(ar[i]=='D'){
				op.add(op.get(i));
				for(int j=posOfI;j<=i;j++){
					op.set(j, op.get(j)+1);
				}
				minAvail++;
			}
		}
		
		op.forEach(System.out::println);

	}

}
