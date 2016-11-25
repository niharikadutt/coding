package com.practice.DS.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSorting {

	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addEdge(1,3);
		g.addEdge(1,5);
		g.addEdge(2,4);
		g.addEdge(4,3);
		g.addEdge(5,3);
		
		List<Integer> ar = topologicalSort(g);
		ar.forEach(System.out::println);
		
	}
	
	private static List<Integer> topologicalSort(Graph g){
		Queue<Integer> queue= new LinkedList<>();
		int vertexCount = g.getVertexCount();
		int[][] adjMatrix = g.getAdjMatrix();
		List<Integer> res=new ArrayList<>();
		int[] indegree = g.getIndegree();
		boolean[] visited = g.getVisited();
		int v, w;
		for(int i=1;i<=vertexCount;i++){
			if(indegree[i]==0){
				visited[i]=true;
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()){
			Arrays.fill(visited, false);
			v=queue.poll();
			res.add(v);
			while((w=getAdjVertex(v,adjMatrix, visited))!=-1){
				visited[w]=true;
				if(--indegree[w]==0){
				queue.add(w);
				}
			}
		}
		
		return res;
		
	}
	
	private static int getAdjVertex(int v, int[][] matrix,boolean[] visited){
		for(int i=1;i<matrix.length;i++){
			if(matrix[v][i]==1 && !visited[i]){
				return i;
			}
		}
		
		return -1;
	}

}


class Graph{
	private int vertexCount;
	private int adjMatrix[][];
	private int[] indegree;
	private boolean[] visited;
	
	public Graph(int vertexCount){
		this.vertexCount = vertexCount;
		adjMatrix = new int[vertexCount+1][vertexCount+1];
		indegree = new int[vertexCount+1];
		visited = new boolean[vertexCount+1];
	}

	public boolean[] getVisited() {
		return visited;
	}

	public void setVisited(boolean[] visited) {
		this.visited = visited;
	}

	public int getVertexCount() {
		return vertexCount;
	}

	public void setVertexCount(int vertexCount) {
		this.vertexCount = vertexCount;
	}

	public int[][] getAdjMatrix() {
		return adjMatrix;
	}

	public void setAdjMatrix(int[][] adjMatrix) {
		this.adjMatrix = adjMatrix;
	}

	public int[] getIndegree() {
		return indegree;
	}

	public void setIndegree(int[] indegree) {
		this.indegree = indegree;
	}
	
	public void addEdge(int i, int j){
		if(i>=0 && i<=vertexCount && j>=0 && j<=vertexCount){
			adjMatrix[i][j] =1;
		//	adjMatrix[j][i] =1;
			indegree[j] = indegree[j]+1;
		}
	}
	
	public void removeEdge(int i, int j){
		if(i>=0 && i<=vertexCount && j>=0 && j<=vertexCount){
			adjMatrix[i][j] =0;
		}
	}
}

