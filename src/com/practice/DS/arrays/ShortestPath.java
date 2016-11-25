package com.practice.DS.arrays;

public class ShortestPath {

	public static void main(String[] args) {
		String str = "COZY";
		printPath(str);
	}
	
	private static void printPath(String str){
		char[] ar = str.toCharArray();
		int i=0;
		int curX = 0, curY=0;
		
		while(i<str.length()){
			int nextY = (ar[i]-'A')/5;
			int nextX = (ar[i]-'A')%5;
			
			while(curX<nextX){
				System.out.println("Move Right!");
				curX++;
			}
			
			while(curX>nextX){
				System.out.println("Move Left!");
				curX--;
			}
			
			while(curY<nextY){
				System.out.println("Move Up!");
				curY++;
			}
			
			while(curY>nextY){
				System.out.println("Move Down!");
				curY--;
			}
			
			System.out.println("Press OK!");
			i++;
		}
	}

}
