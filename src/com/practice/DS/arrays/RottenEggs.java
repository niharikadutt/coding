package com.practice.DS.arrays;

import java.util.LinkedList;
import java.util.Queue;

public class RottenEggs {

	public static void main(String[] args) {
		int ar[][] = {{2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};
		
	System.out.println(findMinTime(ar));
	}
	
	private static int findMinTime(int[][] ar){
		Queue<Ele> queue = new LinkedList<>();
		int ans=0; 
		
		for(int i=0;i<ar.length;i++){
			for(int j=0;j<ar[0].length;j++){
				if(ar[i][j]==2){
					queue.add(new Ele(i, j));
				}
			}
		}		
		queue.add(null);
		while(!queue.isEmpty()){
			
			boolean flag = false;
			Ele temp = queue.poll();
			if(temp==null){
				queue.add(null);
				if(queue.peek()==null){
					break;
				}
				continue;
			}
			//check for left
			if(isValid(temp.x-1, temp.y) && ar[temp.x-1][temp.y]==1){
				if(!flag){
					ans++;
					flag=true;
				}
				
				ar[temp.x-1][temp.y] = 2;
				 temp.x--;
				queue.add(new Ele(temp.x-1,temp.y));
				 temp.x++;
			}
			
			if(isValid(temp.x+1, temp.y) && ar[temp.x+1][temp.y]==1){
				if(!flag){
					ans++;
					flag=true;
				}
				
				ar[temp.x+1][temp.y] = 2;
				temp.x++;
				queue.add(new Ele(temp.x+1,temp.y));
				temp.x--;
			}
			
			if(isValid(temp.x, temp.y-1) && ar[temp.x][temp.y-1]==1){
				if(!flag){
					ans++;
					flag=true;
				}
				
				ar[temp.x][temp.y-1] = 2;
				temp.y--;
				queue.add(new Ele(temp.x,temp.y-1));
				temp.y++;
			}
			
			if(isValid(temp.x, temp.y+1) && ar[temp.x][temp.y+1]==1){
				if(!flag){
					ans++;
					flag=true;
				}
				
				ar[temp.x][temp.y+1] = 2;
				temp.y++;
				queue.add(new Ele(temp.x,temp.y+1));
				temp.y--;
			}
		}
		return ans;
		
	}
	
	private static boolean isValid(int x, int y){
		if(x<0 || y<0 || x>=3 || y>=5){
			return false;
		}
		
		return true;
	}

}

class Ele{
	int x, y;
	
	Ele(int x, int y){
		this.x=x;
		this.y=y;
	}
}
