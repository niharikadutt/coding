package com.practice.DS.tree;

import java.util.Map;
import java.util.TreeMap;

public class BottomView {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(11);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getRight().setLeft(new TreeNode(1));
		root.getRight().setRight(new TreeNode(5));
		root.getRight().getLeft().setLeft(new TreeNode(6));
		root.getRight().getRight().setRight(new TreeNode(7));
		
		getBottomView(root);
	}

	private static void getBottomView(TreeNode root) {
	    Map<Integer, TreeNode> map = new TreeMap<>();
	    getBottomViewUtil(root, map, 0);
	    
	    map.forEach((k,v)->System.out.println(v.getData()));
		
	}

	private static void getBottomViewUtil(TreeNode root, Map<Integer, TreeNode> map, int hd) {
		if(root==null)
			return;
		
		getBottomViewUtil(root.getLeft(), map, hd-1);
		map.put(hd, root);
		getBottomViewUtil(root.getRight(), map, hd+1);
	}

}
