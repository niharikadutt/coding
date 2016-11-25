package com.practice.DS.tree;

public class ConstructTreeFromPreandLevel {
	
	private static int levelIndex = 0;

	public static void main(String[] args) {
		int[] inorder= {4, 8, 10, 12, 14, 20, 22};
		int[] level = {20, 8, 22, 4, 12, 10, 14};
		
		TreeNode res = buildTree(inorder, level, 0, inorder.length-1);
		
		TreeUtil.printInorder(res);
	}

	private static TreeNode buildTree(int[] inorder, int[] level, int start, int end) {
		if(start>end)
			return null;
		
		if(levelIndex>level.length-1)
			return null;
		
		TreeNode node = new TreeNode(level[levelIndex++]);
		if(start==end){
			return node;
		}
		
		int inIndex = getIIndex(inorder, node.getData());
		node.setLeft(buildTree(inorder, level, start, inIndex-1));
		node.setRight(buildTree(inorder, level, inIndex+1, end));
		
		return node;
		
	}

	private static int getIIndex(int[] in, int val) {
		for(int i=0;i<in.length;i++){
			if(in[i]==val){
				return i;
			}
			
		}
		return -1;
	}

}

class InIndex{
	int index;
}
