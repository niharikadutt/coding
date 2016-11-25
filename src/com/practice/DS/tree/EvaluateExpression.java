package com.practice.DS.tree;

public class EvaluateExpression {

	public static void main(String[] args) {
		TNode root = new TNode('+');
		root.left = new TNode('*');
		root.right = new TNode('-');
		root.left.left = new TNode('5');
		root.left.right = new TNode('4');
		root.right.left = new TNode('6');
		root.right.right = new TNode('7');
		
		System.out.println(evaluateExpression(root));
		
		
	}

	private static int evaluateExpression(TNode root) {
		if(root==null)
			return 0;
		
		if(root.left==null && root.right==null)
			return Character.getNumericValue(root.data);
		
		int lVal = evaluateExpression(root.left);
		int rVal = evaluateExpression(root.right);
		
		if(root.data == '+'){
			return lVal+rVal;
		}
		else if(root.data == '*')
			return lVal*rVal;
		
		return lVal-rVal;
	}

}

class TNode{
	TNode left;
	TNode right;
	char data;
	
	TNode(char data){
		this.data = data;
	}
	
}
