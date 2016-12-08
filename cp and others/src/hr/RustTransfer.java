package hr;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RustTransfer {

	/**
	 * @param args
	 */
	static class AdjListNode {
		nodes node;
		int wt;

		public AdjListNode(nodes node, int wt) {
			super();
			this.node = node;
			this.wt = wt;
		}
	}

	static class nodes {
		int index = -1;
		nodes parent = null;
		List<AdjListNode> adj = new LinkedList<AdjListNode>();
	}

	static class graph {
		nodes[] nodes;

		graph(int n) {
			nodes = new nodes[n];
		}
	}
	
	
	static class MinHeapNode {
		nodes node;
		int dist = Integer.MAX_VALUE;

		public MinHeapNode(nodes node, int dist) {
			super();
			this.node = node;
			this.dist = dist;
		}
	}

	static class MinHeap {
		int size = 0;
		int capacity;
		int[] pos;
		MinHeapNode[] minHeapArray;
	}

	static void swapMinHeapNodes(MinHeapNode[] arr, int i, int j) {
		MinHeapNode tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	static void minHeapify(MinHeap minHeap, int idx) {

		int smallest = idx;
		int left = 2 * idx + 1;
		int right = 2 * idx + 2;

		if (left < minHeap.size
				&& minHeap.minHeapArray[left].dist < minHeap.minHeapArray[smallest].dist)
			smallest = left;

		if (right < minHeap.size
				&& minHeap.minHeapArray[right].dist < minHeap.minHeapArray[smallest].dist)
			smallest = right;

		if (smallest != idx) {
			MinHeapNode smallestNode = minHeap.minHeapArray[smallest];
			MinHeapNode idxNode = minHeap.minHeapArray[idx];

			minHeap.pos[smallestNode.node.index] = idx;
			minHeap.pos[idxNode.node.index] = smallest;

			swapMinHeapNodes(minHeap.minHeapArray, smallest, idx);

			minHeapify(minHeap, smallest);
		}
	}

	static boolean isEmpty(MinHeap minHeap) {

		return minHeap.size == 0;
	}

	static MinHeapNode extractMin(MinHeap minHeap) {
		if (isEmpty(minHeap))
			return null;

		MinHeapNode root = minHeap.minHeapArray[0];

		MinHeapNode lastNode = minHeap.minHeapArray[minHeap.size - 1];
		minHeap.minHeapArray[0] = lastNode;

		minHeap.pos[root.node.index] = minHeap.size - 1;
		minHeap.pos[lastNode.node.index] = 0;

		minHeap.size = minHeap.size - 1;
		minHeapify(minHeap, 0);
		return root;
	}

	static void decreaseKey(MinHeap minHeap, int v, int dist) {

		int i = minHeap.pos[v];

		minHeap.minHeapArray[i].dist = dist;

		while (i != 0
				&& minHeap.minHeapArray[i].dist < minHeap.minHeapArray[(i - 1) / 2].dist) {
			minHeap.pos[minHeap.minHeapArray[i].node.index] = (i - 1) / 2;
			minHeap.pos[minHeap.minHeapArray[(i - 1) / 2].node.index] = i;
			swapMinHeapNodes(minHeap.minHeapArray, i, (i - 1) / 2);

			i = (i - 1) / 2;
		}
	}

	static boolean isInMinHeap(MinHeap minHeap, int v) {

		if (minHeap.pos[v] < minHeap.size)
			return true;
		return false;
	}
	
	//static int[][] edgewt;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t>0){
			t--;
			int n = s.nextInt();
			int m = s.nextInt();
			//edgewt = new int[n][n];
			graph g = new graph(n);
			for (int i = 0; i < n; i++) {
				g.nodes[i] = new nodes();
				g.nodes[i].index = i;
			}
			for (int i = 0; i < m; i++) {
				int u = s.nextInt()-1;
				int v = s.nextInt() -1;
				int rc = s.nextInt();
				int tc = s.nextInt();
				if(rc < tc){
					AdjListNode anode = new AdjListNode(g.nodes[v], rc);
					g.nodes[u].adj.add(anode);

					AdjListNode anode1 = new AdjListNode(g.nodes[u], rc);
					g.nodes[v].adj.add(anode1);
				}else{
					AdjListNode anode = new AdjListNode(g.nodes[v], tc);
					g.nodes[u].adj.add(anode);

					AdjListNode anode1 = new AdjListNode(g.nodes[u], tc);
					g.nodes[v].adj.add(anode1);
				}
				
			}
			int start = s.nextInt()-1;
			int dest = s.nextInt()-1;
			dijkstra(g, g.nodes[start]);
			if(dist[dest] != Integer.MAX_VALUE){
				System.out.println(dist[dest]);
			}else{
				System.out.println(-1);
			}
		}

	}
	
	static int[] dist;
	private static void dijkstra(graph g, nodes node) {
		int V = g.nodes.length;
		dist = new int[V];

		MinHeap minHeap = new MinHeap();
		minHeap.capacity = V;
		minHeap.minHeapArray = new MinHeapNode[V];
		minHeap.pos = new int[V];
		minHeap.size = V;

		for (int v = 0; v < V; ++v) {
			dist[v] = Integer.MAX_VALUE;
			// System.out.println(g.nodes[v].index);
			minHeap.minHeapArray[v] = new MinHeapNode(g.nodes[v], dist[v]);
			minHeap.pos[v] = v;
		}

		int src = node.index;
		dist[src] = 0;
		decreaseKey(minHeap, src, dist[src]);

		while (!isEmpty(minHeap)) {
			// for (int i = 0; i < minHeap.size; i++) {
			// System.out.println(minHeap.minHeapArray[i].node.index+" "+minHeap.minHeapArray[i].dist);
			// }
			MinHeapNode minHeapNode = extractMin(minHeap);
			int u = minHeapNode.node.index;
			// System.out.println(u);
			for (int i = 0; i < minHeapNode.node.adj.size(); i++) {

				int v = minHeapNode.node.adj.get(i).node.index;
				if (isInMinHeap(minHeap, v) && dist[u] != Integer.MAX_VALUE
						&& minHeapNode.node.adj.get(i).wt + dist[u] < dist[v]) {
					dist[v] = dist[u] + minHeapNode.node.adj.get(i).wt;
					decreaseKey(minHeap, v, dist[v]);
				}

			}

		}

//		System.out.println("Vertex distance from source");
//		for (int i = 0; i < dist.length; i++) {
//			System.out.println("Node " + i + " at distance " + dist[i]);
//		}

	}

}
