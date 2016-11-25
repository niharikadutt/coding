package com.practice.DS.linkedlist;

public class InplaceMerge {

	public static void main(String[] args) {
		LinkNode a = new LinkNode(2);
		a.setNext(new LinkNode(4));
		a.getNext().setNext(new LinkNode(7));
		a.getNext().getNext().setNext(new LinkNode(8));
		a.getNext().getNext().getNext().setNext(new LinkNode(10));
		
		LinkNode b = new LinkNode(1);
		b.setNext(new LinkNode(3));
		b.getNext().setNext(new LinkNode(12));
		
		mergeLists(a,b);
		
		
		print(a);
		print(b);
	}
	/*
	 * 1. Loop Both list
	 * 2. If a[i]>b[i], swap them
	 * 3. Sort b
	 */
	private static void mergeLists(LinkNode a, LinkNode b){
		while (a != null && b != null) {
			if (a.getData() > b.getData()) {
				int temp = a.getData();
				a.setData(b.getData());
				b.setData(temp);

				LinkNode tempB = b;
				LinkNode ptr = b;

				if (b.getNext() != null && b.getData() > b.getNext().getData()) {
					while (ptr.getNext() != null && tempB.getData() > ptr.getNext().getData()) {
						ptr = ptr.getNext();

					}
					int tmp = tempB.getData();
					tempB.setData(ptr.getData());
					ptr.setData(tmp);
				}

			}
			a = a.getNext();
		}

	}
	
	private static void print(LinkNode node){
		while(node!=null){
			System.out.print(node.getData());
			node = node.getNext();
		}
	}

}
