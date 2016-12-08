package geeksforgeeks;

import java.util.*;

public class MergeSortedLinkedLists{

	static class Node{
		int data;
		Node next;

		public Node() {
			// TODO Auto-generated constructor stub
		}
		public Node(int d){
			this.data = d;
			this.next = null;
		}
	}
	
	public static Node head1;
	public static Node head2;
	public static Node head3;
	public static void main(String[] args){

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		while(t-- >0){
			head1 = null;
			head2 = null;

			int n = in.nextInt();
			
			Node newNode = new Node(in.nextInt());
			head1 = newNode;
			Node prev = head1;
			for(int i=1;i<n;i++){
				int d = in.nextInt();
				newNode = new Node(d);
				prev.next = newNode;
				prev = newNode;
			}

			n = in.nextInt();
			newNode = new Node(in.nextInt());
			head2 = newNode;
			prev = head2;
			for(int i=1;i<n;i++){
				int d = in.nextInt();
				newNode = new Node(d);
				prev.next = newNode;
				prev = newNode;
			}

			Node dummy = new Node(0);
//			Node tmp = new Node();
//			head3.next = tmp;
			sortedMerge(dummy,head1,head2);
			System.out.println("After merging");
			Node curr = dummy.next;
			//System.out.println(head3.next+" head3");
			while(curr!=null){
				System.out.println(curr.data);
				curr = curr.next;
			}


		}


	}

	public static void sortedMerge(Node cur, Node a, Node b){
		if(a==null){
			cur.next = b;
			return;
		}
		if(b==null){
			cur.next = a;
			return;

		}

		//System.out.println("ere");
		if(a.data < b.data){
			
			cur.next = a;
			//System.out.println(cur.data);
			sortedMerge(cur.next, a.next, b);

		}else{
			cur.next = b;
			//System.out.println(cur.data);
			sortedMerge(cur.next,a,b.next);

		}
		//System.out.println(cur);
	}


}