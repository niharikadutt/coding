package com.practice.DS.arrays;

import java.util.LinkedList;
import java.util.Queue;

public class RottenProblem {
	
	private static int R = 0;
	private static int C = 0;
	

	public static void main(String[] args) {
		int[][] ar = { {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};
		
		int ans = rotOranges(ar);
		if(ans==-1){
			System.out.println("All oranges cannot be rotten");
		}
		else{
			System.out.println("Oranges can be rotten in time "+ ans);
		}
	}
	
	private static int rotOranges(int[][] ar){
		Queue<Element> queue = new LinkedList<>();
		Element temp = new Element();
		int ans = 0;
		R = ar.length;
		C = ar[0].length;
		
		for(int i=0;i<R;i++){
			for (int j=0; j<C; j++)
		       {
		            if (ar[i][j] == 2)
		            {
		                temp.x = i;
		                temp.y = j;
		                queue.add(temp);
		            }
		        }
		}
		
		queue.add(null);
		
		while(!queue.isEmpty()){
			boolean flag = false;
			temp = queue.poll();
			    if(temp==null){
			    	queue.add(null);
			    	if(queue.peek()==null){
			    		break;
			    	}
			    	continue;
			    }			
				if(isValid(temp.x+1, temp.y) && ar[temp.x+1][temp.y]==1){
					if(!flag) ans++; flag = true;
					
					ar[temp.x+1][temp.y]=2;
					temp.x++;
					queue.add(temp);
					
					temp.x--;
				}
				
				if(isValid(temp.x, temp.y+1) && ar[temp.x][temp.y+1]==1){
					if(!flag) ans++; flag = true;
					
					ar[temp.x][temp.y+1]=2;
					temp.y++;
					queue.add(temp);
					
					temp.y--;
				}
				
				if(isValid(temp.x-1, temp.y) && ar[temp.x-1][temp.y]==1){
					if(!flag) ans++; flag = true;
					
					ar[temp.x-1][temp.y]=2;
					temp.x--;
					queue.add(temp);
					
					temp.x++;
				}
				
				if(isValid(temp.x, temp.y-1) && ar[temp.x][temp.y-1]==1){
					if(!flag) ans++; flag = true;
					
					ar[temp.x][temp.y-1]=2;
					temp.y--;
					queue.add(temp);
					
					temp.y++;
				}			
		}
		return checkAll(ar)?-1:ans;
	}
	
	private static  boolean checkAll(int[][] ar){
		for(int i=0;i<R;i++){
			for(int j=0;j<C;j++){
				if(ar[i][j]==1)
					return true;
			}		
		}
		return false;
	}
	
	private static boolean isValid(int x, int y){
		if(x>=0 && x<R && y>=0 && y<C)
			return true;
		
		return false;
	}
	
	private static boolean isDelim(Element temp){
		if(temp.x==-1 && temp.y==-1)
			return true;
		
		return false;
	}

}

class Element{
	int x, y;
}
