package com.practice.DS.tree;

public class ParentArrayToBT {

	public static void main(String[] args) {
		int[] parent = {-1, 0, 0, 1, 1, 3, 5};
		
		TreeNode root = createTree(parent, parent.length);
		print(root);
		
	}

	private static TreeNode createTree(int[] parent, int n) {
		TreeNode[] nodes = new TreeNode[n];
		TreeNode root=null;
		for(int i=0;i<n;i++){
			nodes[i] = new TreeNode(i);
		}
		
		for(int i=0;i<n;i++){
			if(parent[i]!=-1){
				if(nodes[parent[i]].getLeft()==null)
					nodes[parent[i]].setLeft(nodes[i]);
				else{
					nodes[parent[i]].setRight(nodes[i]);
				}
			}
			else{
				root = nodes[i];
			}
		}
		
		return root;
	}
	
	private static void print(TreeNode root){
		if(root==null)
			return;
		print(root.getLeft());
		System.out.println(root.getData());
		print(root.getRight());
		}

}
