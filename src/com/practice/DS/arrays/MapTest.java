package com.practice.DS.arrays;

import java.io.*;
import java.util.*;

public class MapTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputSizes = sc.nextLine().split(" ");
        int i=0;
        List<Range> shotRanges = new ArrayList<>();
        for(i=0;i<Integer.parseInt(inputSizes[0]);i++){
            String[] shotInput = sc.nextLine().split(" ");
            shotRanges.add(new Range(Integer.parseInt(shotInput[0]), Integer.parseInt(shotInput[1])));
        }
       shotRanges.sort((list1, list2) -> {
			 return list1.end.compareTo(list2.end);
		});
           
        int count=0;
                          
        for(i=0;i<Integer.parseInt(inputSizes[1]);i++){
            String[] playerInput = sc.nextLine().split(" ");
            int k=0;
            while(k<shotRanges.size()){
            	if(Integer.parseInt(playerInput[0])<=shotRanges.get(k).end && Integer.parseInt(playerInput[1])>=shotRanges.get(k).start){
            		count++;
            	}
                k++;
            }
        }
        
       System.out.println(count);                  
}
}
class Range{
	Integer start;
	Integer end;
	
	Range(Integer start, Integer end){
		this.start = start;
		this.end = end;
	}
}
