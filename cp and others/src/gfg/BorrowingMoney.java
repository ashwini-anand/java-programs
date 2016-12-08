package gfg;

import java.util.Arrays;
import java.util.Scanner;

public class BorrowingMoney {

	/**
	 * @param args
	 */
	static class Node implements Comparable<Node>{
		int index;
		int money;
		int ownesto;
		int req ;
		public Node(int index, int money, int ownesto) {
			super();
			this.index = index;
			this.money = money;
			this.ownesto = ownesto;
			this.req = money;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.money - o.money;
		}
		
	}
	
	static class MinHeap {
		int size = 0;
		int capacity;
		int[] pos;
		Node[] minHeapArray;
	}
	
	static boolean isInMinHeap(MinHeap minHeap, int v) {

		if (minHeap.pos[v] < minHeap.size)
			return true;
		return false;
	}
	
	static boolean isEmpty(MinHeap minHeap) {

		return minHeap.size == 0;
	}
	
	static void extractMin(MinHeap minHeap) {
		if (isEmpty(minHeap))
			return ;

		Node root = minHeap.minHeapArray[0];

		Node lastNode = minHeap.minHeapArray[minHeap.size - 1];
		minHeap.minHeapArray[0] = lastNode;
		minHeap.minHeapArray[minHeap.size - 1] = root;

		minHeap.pos[root.index] = minHeap.size - 1;
		minHeap.pos[lastNode.index] = 0;

		minHeap.size = minHeap.size - 1;
//		for (int i = 0; i < minHeap.pos.length; i++) {
//			System.out.println(minHeap.pos[i]+" "+minHeap.minHeapArray[minHeap.pos[i]].index);
//		}
//		System.out.println(minHeap.size);
		//if(minHeap.size == 1) return;
		minHeapify(minHeap, 0);
		return;
	}
	
	static void minHeapify(MinHeap minHeap, int idx){

		int smallest = idx;
		int left = 2 * idx + 1;
		int right = 2 * idx + 2;

		if (left < minHeap.size
				&& minHeap.minHeapArray[left].req < minHeap.minHeapArray[smallest].req)
			smallest = left;

		if (right < minHeap.size
				&& minHeap.minHeapArray[right].req < minHeap.minHeapArray[smallest].req)
			smallest = right;

		if (smallest != idx) {
			Node smallestNode = minHeap.minHeapArray[smallest];
			Node idxNode = minHeap.minHeapArray[idx];

			minHeap.pos[smallestNode.index] = idx;
			minHeap.pos[idxNode.index] = smallest;

			swapMinHeapNodes(minHeap.minHeapArray, smallest, idx);

			minHeapify(minHeap, smallest);
		}
	}
	
	static void decreaseKey(MinHeap minHeap, int v, int dec) {

		int i = minHeap.pos[v];

		//if(!isInMinHeap(minHeap, i)) return;
		//System.out.println(i+"aa "+minHeap.minHeapArray[i].index+" "+minHeap.minHeapArray[i].money);
		minHeap.minHeapArray[i].req = minHeap.minHeapArray[i].req - dec;

		while (i != 0
				&& minHeap.minHeapArray[i].req < minHeap.minHeapArray[(i - 1) / 2].req) {
			minHeap.pos[minHeap.minHeapArray[i].index] = (i - 1) / 2;
			minHeap.pos[minHeap.minHeapArray[(i - 1) / 2].index] = i;
			swapMinHeapNodes(minHeap.minHeapArray, i, (i - 1) / 2);

			i = (i - 1) / 2;
		}
	}
	static void swapMinHeapNodes(Node[] arr, int i, int j) {
		Node tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		MinHeap mh  = new MinHeap();
		int n = s.nextInt();
		mh.capacity = n;
		mh.minHeapArray = new Node[n];
		mh.pos = new int[n];
		mh.size = n;
		
		for (int i = 0; i < n; i++) {
			int ai = s.nextInt()-1;
			int bi = s.nextInt();
			Node nn = new Node(i,bi,ai);
			mh.minHeapArray[i] = nn;
		}
		
		Arrays.sort(mh.minHeapArray);
		for (int i = 0; i < mh.minHeapArray.length; i++) {
			mh.pos[mh.minHeapArray[i].index] = i;
		}
		
		int sum =0;
		
		while(!isEmpty(mh)){
			Node nd = mh.minHeapArray[0];
			//System.out.println(sum+" "+mh.minHeapArray[0].req+" "+mh.minHeapArray[0].index);
			if(mh.minHeapArray[0].req >0){
				//System.out.println(sum+" "+mh.minHeapArray[0].req+" "+mh.minHeapArray[0].index);
				int tmp = mh.minHeapArray[0].req;
				int k = mh.minHeapArray[0].ownesto;
//				if(!isInMinHeap(mh, k) && (mh.minHeapArray[mh.pos[k]].money < mh.minHeapArray[0].money)){
//					tmp = tmp - mh.minHeapArray[mh.pos[k]].money;
//				}
				
				sum += tmp;
			}
			
//			for (int i = 0; i < mh.pos.length; i++) {
//				System.out.println(mh.pos[i]+" "+mh.minHeapArray[mh.pos[i]].index);
//			}
			//System.out.println(min);
			extractMin(mh);
//			System.out.println(nd.ownesto);
			//if(!isInMinHeap(mh, mh.pos[nd.ownesto])) continue;
			decreaseKey(mh, nd.ownesto, nd.money);
		}
		System.out.println(sum);
	}

}
