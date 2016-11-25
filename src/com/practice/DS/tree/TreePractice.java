package com.practice.DS.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class TreePractice {
	
	private static int COUNT = 10;
	private static int[][] mat = new int[8][8];
	
	public static void main(String str[]){
		/*
		 *            
		 */
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(4));
		root.getLeft().getLeft().setLeft(new TreeNode(9));
		root.getLeft().getRight().setLeft(new TreeNode(9));
		//root.getLeft().getLeft().setLeft(new TreeNode(8));
		root.getLeft().setRight(new TreeNode(5));
		//root.getLeft().getRight().setRight(new TreeNode(9));
		//root.getLeft().getRight().getRight().setRight(new TreeNode(10));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
		TreeNode maxMode = null;
		
		System.out.println(largestSubtree(root, maxMode));
		
	//	System.out.println(printTopView(root));
		
	//	System.out.println(findLCA(root, 4,6).getData());
		
	 //   System.out.println(findMinLeafDistance(root));
		//	System.out.println(removeEdge(root));
		
//		LLNode node = new LLNode(0);
//		verticalSumUsingDLL(root, node);
//		
//		while(node.prev!=null){
//			node = node.prev;
//		}
//		
//		while(node!=null){
//			System.out.println(node.data);
//			node = node.next;
//		}
		
//		Map<Integer, Integer> map = new HashMap<>();
//		verticalSum(root,0, map);
//		
//		System.out.println(map.entrySet());
		
//		int[] ar = {1, 5, 5, 2, 2, -1, 3};
//		contructBinaryTree(ar);
		
		//printAlternateNodes(root);
		
		specificLevelOrder(root);
		
		//convertIntoDLL(root);	
//		List<Integer> acs = new ArrayList<>();
//		constructMatrix(root, acs);
//		
//		for(int i=1;i<8;i++){
//			for(int j=1;j<8;j++){
//				System.out.print(mat[i][j]+" ");
//			}
//			System.out.println();
//		}

		//Map<Integer, List<Integer>> map = new HashMap<>();
		
//		printDiagonal(root, map, 0);
//		print(map);
		
		//printPath(root);		
		//spiralLevelOrder(root);
		//sinkOddNodes(root);
		//System.out.println(findDensity(root));
		
//		int[] in= {4, 8, 2, 5, 1, 6, 3, 7};
//		int[] post = {8, 4, 5, 2, 6, 7, 3, 1};
//		root = buildTree(in,post);
//		printInorder(root);
//		print2DArray(root, 0);		
		//System.out.println(isMirrorOfItself(root.getLeft(), root.getRight()));
//		Height h=new Height();
//		h.h=0;
//		System.out.println(getDiameter(root,h));
//		
	}
	
private	static int largestSubtreeUtil(TreeNode root, MyString str,
            int maxSize, TreeNode maxNode)
{
if (root == null)
return 0;

// string to store structure of left and
// right subtrees
MyString left = new MyString();
left.str=new StringBuffer();
MyString right = new MyString();
right.str=new StringBuffer();


// traverse left subtree and finds its size
int ls = largestSubtreeUtil(root.getLeft(), left,
                       maxSize, maxNode);

// traverse right subtree and finds its size
int rs = largestSubtreeUtil(root.getRight(), right,
                       maxSize, maxNode);

// if left and right subtrees are similar
// update maximum subtree if needed (Note that
// left subtree may have a bigger value than
// right and vice versa)
int size = ls + rs + 1;
if (left.str.toString().compareTo(right.str.toString()) == 0)
{
if (size > maxSize)
{
    maxSize  = size;
    maxNode = root;
}
}

// append left subtree data
str.str.append("|").append(left).append("|");

// append current node data
str.str.append("|").append(root.getData()).append("|");

// append right subtree data
str.str.append("|").append(right).append("|");

return size;
}

//function to find the largest subtree
//having identical left and right subtree
static int largestSubtree(TreeNode node, TreeNode maxNode)
{
int maxSize = 0;
MyString str = new MyString();
largestSubtreeUtil(node, str, maxSize, maxNode);

return maxSize;
}
	
	private static void printTopView(TreeNode root){
		Queue<TreeNode> queue = new LinkedList<>();
		Map<Integer, Integer> map = new HashMap<>();
		queue.add(root);
		map.put(root.getData(), 0);
		
		while(!queue.isEmpty()){
			TreeNode temp = queue.poll();
			//hd = 
			System.out.println(temp.getData());
			
		}
	}
	
	private static TreeNode findLCA(TreeNode root, int n1, int n2){
		
		if(root==null){
			return null;
		}
		if(root.getData()==n1 || root.getData()==n2){
			return root;
		}
		
		TreeNode leftLca = findLCA(root.getLeft(), n1, n2);
		TreeNode rightLca = findLCA(root.getRight(), n1, n2);
		
		if(leftLca!=null && rightLca!=null){
			return root;
		}
		
		return leftLca!=null?leftLca:rightLca;
		
	}
	
	private static boolean removeEdge(TreeNode root){
		int n = count(root);
		Res res = new Res();
		removeEdgeUtil(root, n, res);
		return res.res;
	}
	
	private static int removeEdgeUtil(TreeNode root, int n, Res res){
		if(root==null)
			return 0;
		int c = removeEdgeUtil(root.getLeft(),n,res)+removeEdgeUtil(root.getRight(),n,res)+1;
		if(n-c==c){
			res.res = true;
		}	
		return c;
		
	}
	
	private static int count(TreeNode root){
		if(root==null) return 0;
		return count(root.getLeft())+count(root.getRight())+1;
	}
	
	private static void verticalSumUsingDLL(TreeNode root, LLNode node){
		node.data = node.data+root.getData();
		if(root.getLeft()!=null){
			if(node.prev==null){
				node.prev = new LLNode(0);
				node.prev.next = node;
			}
			verticalSumUsingDLL(root.getLeft(), node.prev);
		}
		
		if(root.getRight()!=null){
			if(node.next==null){
				node.next = new LLNode(0);
				node.next.prev = node;
			}
			verticalSumUsingDLL(root.getRight(), node.next);
		}
	}
	
	private static void verticalSum(TreeNode root, int hd ,Map<Integer, Integer> map){
		if(root==null) return;	
		verticalSum(root.getLeft(), hd-1, map);
		int prevSum = map.get(hd)==null?0:map.get(hd);
		map.put(hd, prevSum+root.getData());
		verticalSum(root.getRight(), hd+1, map);
		
	}
	
	private static void contructBinaryTree(int[] ar){
		HashMap<Integer, Integer> map = new HashMap<>();
	}
	
	private static void printAlternateNodes(TreeNode root){
		boolean odd = false;
		TreeNode first = null;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()){
			TreeNode temp = queue.poll();
			if(temp==null){
				odd=!odd;
				if(!queue.isEmpty()){
					first=queue.peek();
					queue.add(null);
				}
				continue;
			}
			if(odd && first!=null){
				System.out.println(first.getData());
				first=null;
			}
			else if(!odd && queue.peek()==null){
				System.out.println(temp.getData());
			}
			
			if(temp.getLeft()!=null)
				queue.add(temp.getLeft());
			if(temp.getRight()!=null)
				queue.add(temp.getRight());
		
		}
	}
	
	private static void specificLevelOrder(TreeNode root){
		Queue<TreeNode> queue = new LinkedList<>();
		int level = 0;
		Map<Integer, List<TreeNode>> map = new HashMap<>();
		List<TreeNode> list = new ArrayList<>();
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()){
			TreeNode temp = queue.poll();
			if(temp==null){
				map.put(level++, list);
				list = new ArrayList<>();
				if(!queue.isEmpty())
				queue.add(null);
				continue;
			}
			
			list.add(temp);
			if(temp.getLeft()!=null)
				queue.add(temp.getLeft());
			if(temp.getRight()!=null)
				queue.add(temp.getRight());

		}
		
		for(int i=level-1;i>=0;i--){
				for(int j=0;j<(map.get(i).size())/2;j++){
					System.out.print(map.get(i).get(j).getData());
					System.out.print(map.get(i).get(map.get(i).size()-j-1).getData());
				}
		}
	}
	
	private static int constructMatrix(TreeNode root, List<Integer> acs){
		if(root==null)
			return 0;
		
		int data = root.getData();
		for(int i=0;i<acs.size();i++){
			mat[acs.get(i)][data] = 1;
		}
		
		acs.add(data);
		int l=constructMatrix(root.getLeft(),acs);
		int r=constructMatrix(root.getRight(),acs);
		
		acs.remove(acs.size()-1);
		return l+r+1;
	}
	
//	private static LinkNode convertIntoDLL(TreeNode root){
//		if(root==null)
//			return null;
//		convertIntoDLL(root.getLeft());
//		LinkNode node = new LinkNode(root.getData());
//		LinkNode head = node;
//	}
	
	private static void print(Map<Integer, List<Integer>> map){
		for (Map.Entry<Integer,List<Integer>> entry : map.entrySet())
		{
		    for(Integer value : entry.getValue()){
		    	System.out.print(value);
		    }
		    System.out.println();
		}
	}
	
	private static void printDiagonal(TreeNode root, Map<Integer, List<Integer>> map, int d){
		if(root==null)
			return;
		
		List<Integer> list;
		if(map.get(d)!=null){
			list = map.get(d);
		}
		else{
			list = new ArrayList<>();
		}
		list.add(root.getData());
		map.put(d, list);
		printDiagonal(root.getLeft(),map, d+1);
		printDiagonal(root.getRight(),map, d);
	}
	
	private static void printPath(TreeNode root){
		Stack<TreeNode> s = new Stack();
		Map<TreeNode, TreeNode> parent = new HashMap<>();
		
		s.push(root);
		while(!s.isEmpty()){
			TreeNode temp = s.pop();
			if(temp.getLeft()==null && temp.getRight()==null){
				printPathUtil(temp, parent);
			}
			
			if(temp.getLeft()!=null){
				parent.put(temp.getLeft(), temp);
				s.push(temp.getLeft());
			}
			if(temp.getRight()!=null){
				parent.put(temp.getRight(), temp);
				s.push(temp.getRight());
			}
			
		}
		
	}
	
	private static void printPathUtil(TreeNode curr, Map<TreeNode, TreeNode> parent){
		Stack<TreeNode> s = new Stack<>();
		while(curr!=null){
			s.push(curr);
			curr = parent.get(curr);
		}
		
		while(!s.isEmpty()){
			System.out.println(s.pop().getData());
		}
	}
	
	private static void spiralLevelOrder(TreeNode root){
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		
		s1.push(root);
		while(!s1.isEmpty() || !s2.isEmpty()){
			while(!s1.isEmpty()){
				TreeNode temp = s1.pop();
				System.out.println(temp.getData());
				if(temp.getRight()!=null)
					s2.push(temp.getRight());
				if(temp.getLeft()!=null)
					s2.push(temp.getLeft());
					
			}
			
			while(!s2.isEmpty()){
				TreeNode temp = s2.pop();
				System.out.println(temp.getData());
				if(temp.getLeft()!=null)
					s1.push(temp.getLeft());
				if(temp.getRight()!=null)
					s1.push(temp.getRight());
					
			}
		}
	}
	
	private static float findDensity(TreeNode root){
		if(root==null)
			return 0;
		int size=0;
		int height = findDensityUtil(root, size);
		
		return size/height;
	}
	
	private static int findDensityUtil(TreeNode root, int size){
		if(root==null)
			return 0;
		int l = findDensityUtil(root.getLeft(), size);
		int r = findDensityUtil(root.getRight(), size);
		
		size+=1;
		
		return (l>r)?l+1:r+1;
		
	}
	
	
	private static void sinkOddNodes(TreeNode root){
		if(root==null || (root!=null && root.getLeft()==null && root.getRight()==null))
			return;
		
		sinkOddNodes(root.getLeft());
		sinkOddNodes(root.getRight());
		
		if(root.getData()%2!=0){
			sink(root);
		}	
	}
	
	private static void sink(TreeNode root){
		if(root==null || (root!=null && root.getLeft()==null && root.getRight()==null))
			return;
		
		if(root.getLeft()!=null && root.getLeft().getData()%2==0){
			swap(root, root.getLeft());
			sink(root.getLeft());
		}
		
		else if(root.getRight()!=null && root.getRight().getData()%2==0){
			swap(root, root.getLeft());
			sink(root.getLeft());
		}
	}
	
	private static void swap(TreeNode root, TreeNode left){
		int temp = root.getData();
		root.setData(left.getData());
		left.setData(temp);
	}
	
	
	
	private static void print2DArray(TreeNode root, int space){
		if(root==null)
			return;
		
		space+=COUNT;
		print2DArray(root.getRight(), space);
		System.out.println();
		for(int i=COUNT;i<space;i++){
			System.out.print(" ");
		}
		System.out.print(root.getData());
		System.out.println();
		print2DArray(root.getLeft(), space);
	}
	
	private static boolean isMirrorOfItself(TreeNode root1, TreeNode root2){
		if(root1==null && root2==null)
			return true;
				
		if(root1==null || root2==null)
			return false;
		
		return (root1.getData()==root2.getData() && isMirrorOfItself(root1.getLeft(), root2.getRight()) && 
				isMirrorOfItself(root1.getRight(), root2.getLeft()));
	}
	
	private static void printInorder(TreeNode root){
		while(root!=null){
			printInorder(root.getLeft());
			System.out.println(root.getData());
			printInorder(root.getRight());
		}
	}
	
	private static TreeNode buildTree(int[] in, int[] post){
		int n=in.length;
		int pIndex = post.length-1;
		return buildTreeUtil(in, post, 0,n-1,pIndex);
	}
	
	private static TreeNode buildTreeUtil(int[] in, int post[], int inStart, int inEnd, int pIndex){
		if(inStart>inEnd)
			return null;
		
		TreeNode node = new TreeNode(post[pIndex]);
		pIndex--;
		
		if(inStart==inEnd)
			return node;
		
		int iIndex = search(in, inStart, inEnd, node.getData());
		
		node.setLeft(buildTreeUtil(in, post, inStart, iIndex-1,pIndex));
		node.setRight(buildTreeUtil(in, post, iIndex+1, inEnd, pIndex));
		
		return node;		
	} 
	
	private static int search(int[] in, int inStart, int inEnd, int data){
		int i;
		for(i=inStart;i<=inEnd;i++){
			if(in[i]==data){
				break;
			}
		}
		return i;
	}
	
	private static int maxIdenticalSubtree(TreeNode root, StringBuffer str, int maxSize, TreeNode maxNode){
		if(root==null){
			return 0;
		}
		
		String left="",right="";
		
		int lh=maxIdenticalSubtree(root.getLeft(),str,maxSize,maxNode);
		int rh=maxIdenticalSubtree(root.getRight(),str,maxSize,maxNode);
		
		int size = lh+rh+1;
		if(left.equals(right)){
			if(size>maxSize){
				maxSize=size;
				maxNode=root;
			}
		}
		
		str.append("|").append(left).append("|");
		str.append("|").append(root.getData()).append("|");
		str.append("|").append(right).append("|");
		
		return size;
	}
	

	
	private static boolean isIdenticalRecursive(TreeNode root, TreeNode root2){
		if(root==null && root2==null)
			return true;
		if(root==null || root2==null)
			return false;
		
		return (root.getData()==root2.getData() && isIdenticalRecursive(root.getLeft(), root2.getLeft()) && 
				isIdenticalRecursive(root.getRight(), root2.getRight()));
	}
	
	private static void printCousinNodes(TreeNode root, int data){
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode temp=null;
		queue.add(root);
		
		while(root!=null){
			temp = queue.poll();
			if(temp.getData()==data){
				while(!queue.isEmpty()){
					System.out.println(queue.poll().getData());
				}
				return;
			}
			if(temp.getLeft()!=null)
				queue.add(temp.getLeft());
			if(temp.getRight()!=null)
				queue.add(temp.getRight());
		}
		
	}
	
	private static int getDiameter(TreeNode root, Height height){
		
		Height lh = new Height();
		Height rh = new Height();
		
		if(root==null){
			height.h=0;
			return 0;
		}	
		
//		lh.h++; rh.h++;
		int lDiameter = getDiameter(root.getLeft(), lh);
		int rDiameter = getDiameter(root.getRight(), rh);
		
		height.h = Math.max(lh.h, rh.h)+1;
		
		return Math.max(lh.h+rh.h+1, Math.max(lDiameter, rDiameter));
	}

}

class Res 
{
    boolean res = false;
}
class Height{
	int h;
}
class LLNode
{
    int data;
    LLNode prev, next;
    public LLNode(int d) { data = d; }
}

class MyString{
	StringBuffer str=new StringBuffer();
}
