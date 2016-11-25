package com.practice.DS.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomTreeProblem {
	
	private static Map<Integer, List<Integer>> map;

	public static void main(String[] args) {
		map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(4);
		map.put(0, list);
		List<Integer> list1 = new ArrayList<>();
		list1.add(2);
		list1.add(3);		
		map.put(1, list1);
		
		boolean visited[] = new boolean[5];
		for(int i=0;i<5;i++){
			if(!visited[i]){
				dfs(i,1,visited);
			}
		}
	}

	private static void dfs(int src, int dep, boolean[] visited) {
		if(visited[src]){
			return;
		}
		
		visited[src] = true;
		System.out.println("--->"+(char)(src+'a'));
		if(map.get(src)!=null){
		int size = (map.get(src).size());
		for(int i=0;i<size;i++){
			if(!visited[map.get(src).get(i)]){
				for(int j=0;j<dep;j++){
					System.out.print("   |");
				}
			}
			
			dfs(map.get(src).get(i), dep+1, visited);
		}
		}
	}

}
