package com.practice.DS.arrays;

public class RobotProblem {

	public static void main(String[] args) {
		char[] path = "GLGLGLG".toCharArray();
		if(isCircular(path)){
			System.out.println("Circular");
		}
		else{
			System.out.println("Not Circular");
		}
	}
	
	private static boolean isCircular(char[] path){
		int x=0,y=0;
		int dir = Direction.N.ordinal();
		for(int i=0;i<path.length;i++){
			if(path[i]=='R'){
				dir = (dir+1)%4;
			}
			else if(path[i]=='L'){
				dir = (4+dir-1)%4;
			}
			else{
				if(dir==0) y++;
				else if(dir==1) x++;
				else if(dir==2) y--;
				else if(dir==3) x--;
			}
		}
		
		return (x==0 && y==0);
		
	}

}

enum Direction{
	N,E,S,W;
}
