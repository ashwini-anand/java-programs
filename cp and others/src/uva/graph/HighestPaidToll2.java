package uva.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HighestPaidToll2 {

	static class Edge {
		int src;
		int sink;
		int wt;

		public Edge() {
			// TODO Auto-generated constructor stub
		}

		public Edge(int src, int sink, int wt) {
			super();
			this.src = src;
			this.sink = sink;
			this.wt = wt;
		}

	}

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

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int t = s.nextInt();
		while (t-- > 0) {
			int numOfnodes = s.nextInt();
			graph g = new graph(numOfnodes);
			graph revGraph = new graph(numOfnodes);

			for (int i = 0; i < numOfnodes; i++) {
				g.nodes[i] = new nodes();
				g.nodes[i].index = i;
				revGraph.nodes[i] = new nodes();
				revGraph.nodes[i].index = i;
			}

			int numOfEdges = s.nextInt();
			int start = s.nextInt() - 1;
			int end = s.nextInt() - 1;
			int p = s.nextInt();
			Edge edges[] = new Edge[numOfEdges];

			for (int i = 0; i < numOfEdges; i++) {
				int u = s.nextInt() - 1;
				int v = s.nextInt() - 1;
				int wt = s.nextInt();

				edges[i] = new Edge(u, v, wt);
				AdjListNode anode = new AdjListNode(g.nodes[v], wt);
				AdjListNode revNode = new AdjListNode(g.nodes[u], wt);
				g.nodes[u].adj.add(anode);
				revGraph.nodes[v].adj.add(revNode);
			}

			int[] dist = dijkstra(g, g.nodes[start]);
			int[] revDist = dijkstra(revGraph, revGraph.nodes[end]);

			int res = -1;
			for (int i = 0; i < numOfEdges; i++) {
				int u = edges[i].src;
				int v = edges[i].sink;
				if (dist[u] != Integer.MAX_VALUE
						&& revDist[v] != Integer.MAX_VALUE
						&& dist[u] + revDist[v] + edges[i].wt <= p
						&& edges[i].wt > res) {
					res = edges[i].wt;
				}
			}
			System.out.println(res);
			// System.out.println(numOfnodes+" "+numOfEdges+" "+start+" "+end+" "+p);
		}

	}

	private static int[] dijkstra(graph g, nodes node) {
		int V = g.nodes.length;
		int[] dist = new int[V];

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
		return dist;

	}
}
