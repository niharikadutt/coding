package com.practice.DS.linkedlist;

public class SubtractFromLinkedList {
	
	private static boolean borrow = false;

	public static void main(String[] args) {
		LinkNode node1 = new LinkNode(1);
		node1.setNext(new LinkNode(0));
		node1.getNext().setNext(new LinkNode(0));
		
		LinkNode node2 = new LinkNode(1);
		
		LinkNode result = subtract(node1, node2);
		
		printList(result);
	}
	
	private static void printList(LinkNode result){
		while(result!=null){
			System.out.print(result.getData());
			result = result.getNext();
		}
	}
	
	private static LinkNode subtract(LinkNode node1, LinkNode node2){
		int l1 = getLength(node1);
		int l2 = getLength(node2);
		LinkNode smallerNode = null;
		LinkNode largerNode = null;
		
		if(l1>l2){
			smallerNode = padZeros(node2, l1-l2);
			largerNode = node1;
		}
		else if(l2>l1){
			smallerNode = padZeros(node1, l2-l1);
			largerNode = node2;
		}
		
		LinkNode result = subtractUtil(largerNode, smallerNode);
		
		return result;
			
	}
	
	private static LinkNode subtractUtil(LinkNode node1, LinkNode node2){
		if(node1==null && node2==null && !borrow){
			return null;
		}
		
		LinkNode prev = subtractUtil(node1!=null?node1.getNext():null, node2!=null?node2.getNext():null);
		
		int d1 = node1.getData();
		int d2 = node2.getData();
		if(borrow){
			d1--;
			borrow=false;
		}
		
		if(d1<d2){
			borrow=true;
			d1=d1+10;
		}
		
		int sub = d1-d2;
		LinkNode curr = new LinkNode(sub);
		curr.setNext(prev);
		
		return curr;
		
	}
	
	private static LinkNode padZeros(LinkNode node, int l){
		while(l!=0){
			LinkNode newNode = new LinkNode(0);
			newNode.setNext(node);
			node = newNode;
			l--;
		}
		
		return node;
	}
	
	private static int getLength(LinkNode node){
		int len = 0;
		while(node!=null){
			len++;
			node = node.getNext();
		}
		
		return len;
	}
	

}

