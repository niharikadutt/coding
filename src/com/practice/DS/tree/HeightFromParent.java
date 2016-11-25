package com.practice.DS.tree;

public class HeightFromParent {

	public static void main(String[] args) {
		int parent[] = {1,5,5,2,2,-1, 3};
		System.out.println(findHeight(parent));
		
	}

	private static int findHeight(int[] parent) {
		int[] depth = new int[parent.length];
		for(int i=0;i<parent.length;i++){
			findHeightUtil(parent, depth, i);
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0;i<depth.length;i++){
			if(depth[i]>max)
				max = depth[i];
		}
		
		return max;
	}

	private static void findHeightUtil(int[] parent, int[] depth, int i) {
		if(depth[i]!=0)
			return;
		
		if(parent[i]==-1){
			depth[i]=1;
			return;
		}
		else if(depth[parent[i]]==0){
			findHeightUtil(parent, depth, parent[i]);
		}
		
		depth[i] = depth[parent[i]]+1;
	}

}
