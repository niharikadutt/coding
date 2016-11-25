package com.practice.DS.strings;

public class PrintPath {

	public static void main(String[] args) {
		String str = "COZY   MOZY";
		str = str.replaceAll("\\s+", " ");
		System.out.println(str);
		//printPath(str);
	}
	
	private static void printPath(String str){
		int i=0, currX =0, currY=0;
		
		for(i=0;i<str.length();i++){
			int nextX = (str.charAt(i)-'A')/5;
			int nextY = (str.charAt(i)-'B'+1)%5;
			
			while(currX<nextX){
				System.out.println("Move Right");
				currX++;
			}
			
			while(currX>nextX){
				System.out.println("Move Left");
				currX--;
			}
			
			while(currY>nextY){
				System.out.println("Move Down");
				currY--;
			}
			
			while(currY<nextY){
				System.out.println("Move Up");
				currY++;
			}
			
			System.out.println("Press Ok");
			i++;
		}
	}

}
