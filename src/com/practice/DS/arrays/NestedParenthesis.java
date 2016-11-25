package com.practice.DS.arrays;

public class NestedParenthesis {

	public static void main(String[] args) {
		String str = "( ((X)) (((Y))) ))";
		System.out.println(countMaxDepth(str));
	}
	
	private static int countMaxDepth(String str){
		int max_count=Integer.MIN_VALUE, curr_count=0;
		
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='('){
				curr_count+=1;
				if(curr_count>max_count){
					max_count = curr_count;
				}
			}
			else if(str.charAt(i)==')'){
				curr_count-=1;
			}
			
		}
		
		if(curr_count!=0){
			System.out.println("Wrong brackets");
			return -1;
		}
		
		return max_count;
	}

}
