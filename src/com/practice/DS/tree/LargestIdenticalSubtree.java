package com.practice.DS.tree;

class TreNode {
        int data;
        TreNode left, right;
        
        public TreNode (int data) {
            this.data=data;
        }
    }
    
    class MaxNode {
        TreNode max_node;
    }
    class Max{
        int max=0;
    }
    public class LargestIdenticalSubtree {
        TreNode root;
        public int isIdentical (TreNode node , StringBuilder s,  Max m, MaxNode maxNode) {
            if(node==null)
                return 0;
            
            StringBuilder sl = new StringBuilder();
            StringBuilder sr = new StringBuilder();
            
            int l= isIdentical (node.left ,  sl,  m, maxNode);
            int r= isIdentical (node.right ,  sr,  m, maxNode);
            
            
            int size= l+r+1;
            //System.out.println("sl = " + sl.toString() +" Sr = " + sr.toString());
            if(sl.toString().equals(sr.toString())) {
                if(size>m.max) {
                    maxNode.max_node=node;
                    m.max=size;
                    //System.out.println("current max Size is :-" + m.max);
                }
            }
            
            s.append("|").append(sl).append("|");
            s.append("|").append(node.data).append("|");
            s.append("|").append(sr).append("|");
            
            return size;
        }
        
        public int largestSubtree(TreNode node,MaxNode maxNode) {
            if(node==null)
                return 0;
            StringBuilder s=new StringBuilder();
            Max m =new Max();
            isIdentical(node, s, m, maxNode);
            return m.max;
            
        }
    	public static void main (String[] args) {
    	    LargestIdenticalSubtree tree = new LargestIdenticalSubtree();
    	    tree.root = new TreNode(50);
    		
      
        tree.root.left = new TreNode(10);
        tree.root.right = new TreNode(60);
        tree.root.left.left = new TreNode(5);
        tree.root.left.right = new TreNode(20);
        tree.root.right.left = new TreNode(70);
        tree.root.right.left.left = new TreNode(65);
        tree.root.right.left.right = new TreNode(80);
        tree.root.right.right = new TreNode(70);
        tree.root.right.right.left = new TreNode(65);
        tree.root.right.right.right = new TreNode(80);
     
        MaxNode maxNode = new MaxNode();
        int maxSize = tree.largestSubtree(tree.root, maxNode);
     
        System.out.println("Largest Subtree is rooted at node "
             + maxNode.max_node.data + "\nand its size is "
             + maxSize);
    	}
    }