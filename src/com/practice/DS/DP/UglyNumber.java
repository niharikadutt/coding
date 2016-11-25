package com.practice.DS.DP;

import java.util.ArrayList;
import java.util.List;

public class UglyNumber {

	public static void main(String[] args) {
		System.out.println(getNthUglyNumber(150));
	}
	
	private static int getNthUglyNumber(int n){
		int i2=0,i3=0,i5=0;
		int next2Multiple = 2, next3Multiple = 3, next5Multiple = 5;
		int nextUglyNo = 1;
		List<Integer> list = new ArrayList<>();
		list.add(1);
		
		for(int i=1;i<n;i++){
			nextUglyNo = Integer.min(next2Multiple, Integer.min(next3Multiple, next5Multiple));
			list.set(i, nextUglyNo);
			if(nextUglyNo==next2Multiple){
				i2=i2+1;
				next2Multiple = list.get(i2)*2;
			}
			
			if(nextUglyNo==next3Multiple){
				i3=i3+1;
				next2Multiple = list.get(i3)*3;
			}
			
			if(nextUglyNo==next5Multiple){
				i5=i5+1;
				next2Multiple = list.get(i5)*5;
			}
		}	
		return nextUglyNo;
	}
}
