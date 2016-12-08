package algoAssignment2;

import java.io.*;
import java.util.Scanner;

class RBTree {
	public static final int BLACK = 0;
	public static final int RED = 1;
	int color;
	RBTree left, right, parent;
	Integer key;
	String value;
	int subtreeSize;
	int redSubtreeSize;

	public RBTree rotateLeft(RBTree root) {
//		boolean flag1 = false;
//		boolean flag2 = false;
//		boolean flag3 = false;
		
		RBTree temp = right;
		
//		if(root.color==RED && temp.color == RED) flag3 = true;
//		else if(root.color==RED && temp.color == BLACK) flag2 = true;
//		else if(root.color==BLACK && temp.color == RED) flag1 = true;
		
		right = temp.left;
		if (temp.left != null)
			temp.left.parent = this;
		temp.parent = parent;
		if (parent == null)
			root = temp;
		else if (this == parent.left)
			parent.left = temp;
		else
			parent.right = temp;
		temp.left = this;
		parent = temp;
		temp.subtreeSize = this.subtreeSize;
		int cl = this.left == null ? 0 : this.left.subtreeSize;
		int cr = this.right == null ? 0 : this.right.subtreeSize;
		this.subtreeSize = cl + cr + 1;
		
		temp.redSubtreeSize = this.redSubtreeSize;
		int countlr = this.left == null ? 0 : this.left.redSubtreeSize;
		int countrr = this.right == null ? 0 : this.right.redSubtreeSize;
		this.redSubtreeSize = countlr + countrr + 1;
		
		return root;
	}

	public RBTree rotateRight(RBTree root) {
		RBTree temp = left;
		left = temp.right;
		if (temp.right != null)
			temp.right.parent = this;
		temp.parent = parent;
		if (parent == null)
			root = temp;
		else if (this == parent.right)
			parent.right = temp;
		else
			parent.left = temp;
		temp.right = this;
		parent = temp;
		temp.subtreeSize = this.subtreeSize;
		int cl = this.left == null ? 0 : this.left.subtreeSize;
		int cr = this.right == null ? 0 : this.right.subtreeSize;
		this.subtreeSize = cl + cr + 1;
		
		temp.redSubtreeSize = this.redSubtreeSize;
		int countlr = this.left == null ? 0 : this.left.redSubtreeSize;
		int countrr = this.right == null ? 0 : this.right.redSubtreeSize;
		this.redSubtreeSize = countlr + countrr + 1;
		
		return root;
	}

	public RBTree getSuccessor() {
		RBTree temp, p;
		if (right != null) {
			temp = right;
			while (temp.left != null)
				temp = temp.left;
		} else {
			temp = this;
			p = parent;
			while (p != null && temp == p.right) {
				temp = p;
				p = p.parent;
			}
		}
		return temp;
	}
}

public class RedBlackTreeV2 {
	public RBTree tree;
	public int size;
	public int blackSize;
	public boolean keyFound;
	public String prevValue;

	public RedBlackTreeV2() {
		tree = null;
		size = 0;
		blackSize =0;
	}

	public void put(int key, String value) {
		RBTree node = new RBTree();
		node.key = key;
		node.value = value;
		node.subtreeSize = 1;
		keyFound = false;
		tree = insert(node, tree);
		if (keyFound) {
			// System.out.println("Duplicate");
		} else {
			size++;
		}
	}

	public String get(Integer key) {
		RBTree t = tree;
		int comp;

		while (t != null && (comp = key.compareTo(t.key)) != 0) {
			if (comp < 0)
				t = t.left;
			else
				t = t.right;
		}
		return t != null ? t.value : null;
	}

	public String remove(Integer key) {
		RBTree node = tree;
		while (node != null) {
			int comp = key.compareTo(node.key);
			if (comp < 0)
				node = node.left;
			else if (comp > 0)
				node = node.right;
			else {
				prevValue = node.value;
				tree = delete(node, tree);
				size--;
				return prevValue;
			}
		}
		return null;
	}

	public int size() {
		return size;
	}

	public int OsRank(Integer key) {
		RBTree t = tree;
		int comp, r = 0;

		while (t != null && (comp = key.compareTo(t.key)) != 0) {
			if (comp < 0)
				t = t.left;
			else
				t = t.right;
		}
		// System.out.println(t.color);
		// System.out.println(t.parent.key);
		if (t != null) {
			int cl = t.left == null ? 0 : t.left.subtreeSize;
			r = cl + 1;
			// System.out.println(t.left.stsize);
			RBTree z = t;
			while (z.parent != null) {
				if (z == z.parent.right) {
					int cr = z.parent.left == null ? 0
							: z.parent.left.subtreeSize;
					r = r + cr + 1;
				}
				z = z.parent;
			}
		}
		// System.out.println(r);
		return r;

	}
	
	public int OsRedRank(Integer key) {
		RBTree t = tree;
		int comp, r = 0;

		while (t != null && (comp = key.compareTo(t.key)) != 0) {
			if (comp < 0)
				t = t.left;
			else
				t = t.right;
		}
		// System.out.println(t.color);
		// System.out.println(t.parent.key);
		if (t != null) {
			System.out.println(t.key);
			int cl = t.left == null ? 0 : t.left.redSubtreeSize;
			r = cl + 1;
//			if(t.left !=null){
//				r = cl + (t.left.color==RBTree.RED? 1:0);
//			}else{
//				r = cl;
//			}
			// System.out.println(t.left.stsize);
			System.out.println("r 1="+r);
			RBTree z = t;
			while (z.parent != null) {
				if (z == z.parent.right) {
					int cr = z.parent.left == null ? 0
							: z.parent.left.redSubtreeSize;
//					if(z.right!=null){
//						System.out.println();
//					}
					r = r + cr + 1;
					System.out.println("r="+r);
				}
				z = z.parent;
			}
		}
		// System.out.println(r);
		return r;

	}

	public int findRank(int i) {
		return OsSelect(tree, i);
	}

	public int OsSelect(RBTree x, int i) {
		// if(x==null) return 0;
		int r = 0;
		// try{
		int cl = x.left == null ? 0 : x.left.subtreeSize;
		r = cl + 1;
		// System.out.println("Here x.key="+x.key+" r"+r+" i"+i);
		// }
		// catch(NullPointerException ne){
		// System.out.println("x="+x+" i="+i);
		// System.out.println(ne.toString());
		// }
		if (i == r)
			return x.key;
		// else if(x.right == null && i-r==1) return x.key;
		else if (i < r)
			return OsSelect(x.left, i);
		else
			return OsSelect(x.right, i - r);

	}

	public int findRankIfElementMissing(int i) {

		RBTree father = null, son = tree;
		while (son != null) {
			father = son;
			int comp = i < son.key ? -1 : 1;
			if (comp < 0)
				son = son.left;
			else
				son = son.right;
		}

		if (father == null) {
			return 0;
		}
		int k = OsRank(father.key);
		if (i < father.key) {
			return (size() - k + 1);

		} else {
			return (size() - k + 1) - 1;
		}
	}

	private RBTree insert(RBTree node, RBTree tree) {
		RBTree father = null, son = tree, uncle;
		int lastcolor=-1;
		while (son != null) {
			// son.stsize += 1;
			father = son;
			int comp = node.key.compareTo(son.key);
			if (comp < 0)
				son = son.left;
			else if (comp > 0)
				son = son.right;
			else {
				keyFound = true;
				prevValue = son.value;
				son.value = node.value;
				return tree;
			}
		}

		RBTree z = father;
		while (z != null) {
			z.subtreeSize = z.subtreeSize + 1;
			z = z.parent;
		}

		node.parent = father;
		if (father == null)
			tree = node;
		else if (node.key.compareTo(father.key) < 0)
			father.left = node;
		else
			father.right = node;
		lastcolor = node.color;
		node.color = RBTree.RED;
		updateRedIfBlack(node,lastcolor);
		while (node != tree && node.parent.color == RBTree.RED) {
			if (node.parent == node.parent.parent.left) {
				uncle = node.parent.parent.right;
				if (uncle != null && uncle.color == RBTree.RED) {
					lastcolor = node.parent.color;
					node.parent.color = RBTree.BLACK;
					updateRedIfRed(node.parent,lastcolor);
					
					lastcolor = uncle.color;
					uncle.color = RBTree.BLACK;
					updateRedIfRed(uncle,lastcolor);
					
					node = node.parent.parent;
					
					lastcolor = node.color;
					node.color = RBTree.RED;
					updateRedIfBlack(node,lastcolor);
				} else {
					if (node == node.parent.right) {
						node = node.parent;
						tree = node.rotateLeft(tree);
					}
					
					lastcolor = node.parent.color;
					node.parent.color = RBTree.BLACK;
					updateRedIfRed(node.parent, lastcolor);
					
					lastcolor = node.parent.parent.color;
					node.parent.parent.color = RBTree.RED;
					updateRedIfBlack(node.parent.parent, lastcolor);
					
					tree = node.parent.parent.rotateRight(tree);
				}
			} else {
				uncle = node.parent.parent.left;
				if (uncle != null && uncle.color == RBTree.RED) {
					
					lastcolor = node.parent.color;
					node.parent.color = RBTree.BLACK;
					updateRedIfRed(node.parent, lastcolor);
					
					lastcolor = uncle.color;
					uncle.color = RBTree.BLACK;
					updateRedIfRed(uncle, lastcolor);
					
					node = node.parent.parent;
					
					lastcolor = node.color;
					node.color = RBTree.RED;
					updateRedIfBlack(node, lastcolor);
				} else {
					if (node == node.parent.left) {
						node = node.parent;
						tree = node.rotateRight(tree);
					}
					
					lastcolor = node.parent.color;
					node.parent.color = RBTree.BLACK;
					updateRedIfRed(node.parent, lastcolor);
					
					lastcolor = node.parent.parent.color;
					node.parent.parent.color = RBTree.RED;
					updateRedIfBlack(node.parent.parent, lastcolor);
					
					tree = node.parent.parent.rotateLeft(tree);
				}
			}
		}
		
		lastcolor = tree.color;
		tree.color = RBTree.BLACK;
		updateRedIfRed(tree, lastcolor);
		
		return tree;
	}

	private RBTree delete(RBTree node, RBTree tree) {
		RBTree x, y;
		if (node.left == null || node.right == null)
			y = node;
		else {
			y = node.getSuccessor();
		}

		RBTree z = y;
		while (z != null) {
			z.subtreeSize = z.subtreeSize - 1;
			z = z.parent;
		}

		if (y.left != null)
			x = y.left;
		else
			x = y.right;
		if (x != null)
			x.parent = y.parent;
		if (y.parent == null)
			tree = x;
		else if (y == y.parent.left)
			y.parent.left = x;
		else
			y.parent.right = x;
		if (y != node) {
			node.key = y.key;
			node.value = y.value;
		}

		if (y.color == RBTree.BLACK) {
			deleteFixUp(x, y);
		}

		return tree;
	}

	public void deleteFixUp(RBTree x, RBTree y) {

		RBTree father = y.parent;
		int lastcolor = -1;
		while (x != tree && (x == null || x.color == RBTree.BLACK)) {
			if (x == father.left) {
				RBTree w = father.right;
				if (w == null)
					x = tree;
				else {
					if (w.color == RBTree.RED) {
						
						lastcolor = w.color;
						w.color = RBTree.BLACK;
						updateRedIfRed(w, lastcolor);
						
						lastcolor = father.color;
						father.color = RBTree.RED;
						updateRedIfBlack(father, lastcolor);
						
						tree = father.rotateLeft(tree);
						continue;
					}
					if ((w.left == null || w.left.color == RBTree.BLACK)
							&& (w.right == null || w.right.color == RBTree.BLACK)) {
						
						lastcolor = w.color;
						w.color = RBTree.RED;
						updateRedIfBlack(w, lastcolor);
						
						x = father;
						father = x.parent;
					} else {
						if (w.right == null || w.right.color == RBTree.BLACK) {
							if (w.left != null) {
								
								lastcolor = w.left.color;
								w.left.color = RBTree.BLACK;
								updateRedIfRed(w.left, lastcolor);
								
								lastcolor = w.color;
								w.color = RBTree.RED;
								updateRedIfBlack(w, lastcolor);
								
								tree = w.rotateRight(tree);
								w = father.right;
							}
						}
						lastcolor = w.color;
						w.color = father.color;
						if(father.color == RBTree.BLACK){
							updateRedIfRed(w, lastcolor);
						}else{
							updateRedIfBlack(w, lastcolor);
						}
						
						lastcolor = father.color;
						father.color = RBTree.BLACK;
						updateRedIfRed(father, lastcolor);
						if (w.right != null){
							lastcolor = w.right.color;
							w.right.color = RBTree.BLACK;
							updateRedIfRed(w.right, lastcolor);
						}
						tree = father.rotateLeft(tree);
						x = tree;
					}
				}
			} else {
				RBTree w = father.left;
				if (w == null)
					x = tree;
				else {
					if (w.color == RBTree.RED) {
						
						lastcolor = w.color;
						w.color = RBTree.BLACK;
						updateRedIfRed(w, lastcolor);
						
						lastcolor = father.color;
						father.color = RBTree.RED;
						updateRedIfBlack(father, lastcolor);
						tree = father.rotateRight(tree);
						continue;
					}
					if ((w.right == null || w.right.color == RBTree.BLACK)
							&& (w.left == null || w.left.color == RBTree.BLACK)) {
						
						lastcolor = w.color;
						w.color = RBTree.RED;
						updateRedIfBlack(w, lastcolor);
						x = father;
						father = x.parent;
					} else {
						if (w.left == null || w.left.color == RBTree.BLACK) {
							if (w.right != null) {
								
								lastcolor = w.right.color;
								w.right.color = RBTree.BLACK;
								updateRedIfRed(w.right, lastcolor);
								
								lastcolor = w.color;
								w.color = RBTree.RED;
								updateRedIfBlack(w, lastcolor);
								
								tree = w.rotateLeft(tree);
								w = father.left;
							}
						}
						
						lastcolor = w.color;
						w.color = father.color;
						if(father.color == RBTree.BLACK){
							updateRedIfRed(w, lastcolor);
						}else{
							updateRedIfBlack(w, lastcolor);
						}
						
						lastcolor = father.color;
						father.color = RBTree.BLACK;
						updateRedIfRed(father, lastcolor);
						if (w.left != null){
							
							lastcolor = w.left.color;
							w.left.color = RBTree.BLACK;
							updateRedIfRed(w.left, lastcolor);
						}
						tree = father.rotateRight(tree);
						x = tree;
					}
				}
			}
		}
		if (x != null){
			lastcolor = x.color;
			x.color = RBTree.BLACK;
			updateRedIfRed(x, lastcolor);
		}

	}

	//called when we are assigning BLACK color to already RED node
	public void updateRedIfRed(RBTree node1, int lastcolor){ // called when doing x.color = RBTree.BLACK;
		//System.out.println("abcd1");
		RBTree node = node1;
		if(lastcolor == RBTree.RED){
			if(node.parent !=null){
				while(node.parent != null){
				  node.parent.redSubtreeSize -= 1;
				  node = node.parent;
				}
			}
		}
	}
	
	//called when we are assigning RED color to already BLACK node
    public void updateRedIfBlack(RBTree node1, int lastcolor){ // called when doing x.color = RBTree.RED
    	//System.out.println("abcd2");
    	RBTree node = node1;
    	if(lastcolor == RBTree.BLACK){
			if(node.parent !=null) {
				while(node.parent != null){
					//System.out.println("abcd3");
				    node.parent.redSubtreeSize += 1;
				    node = node.parent;
				}	
			}
		}
	}
	void inorder(RBTree tree) {
		if (tree == null)
			return;
		inorder(tree.left);
		System.out.println(" (" + tree.key + ", " + tree.redSubtreeSize + ") "+ tree.color);
		inorder(tree.right);
	}

	public static void main(String[] args) throws FileNotFoundException {
		RedBlackTreeV2 rbt = new RedBlackTreeV2();
		Scanner s = new Scanner(System.in);
		int count = s.nextInt();
		int ops = 1;

		// System.setOut(new PrintStream(new FileOutputStream("/home/ashwini/out")));

		while (count > 0) {
			count--;
			ops = s.nextInt();
			int input = s.nextInt();
			//System.out.println("input="+input);
			if (ops == 1) {
				rbt.put(input, "ABCD");
			} else if (ops == 0) {
				String t = (String) rbt.get(input);
				if (t != null) {
					System.out.println("Element found ");
				} else {
					System.out.println("Element not found ");
				}
			} else if (ops == 2) {
				rbt.remove(input);
			} else if (ops == 3) {
				int k = rbt.OsRank(input);
				// System.out.println("size is"+rbt.size());
				if ((rbt.size() - k + 1) > rbt.size()) {
					System.out.println("Rank of " + input + " is "
							+ rbt.findRankIfElementMissing(input));
				} else {
					System.out.println("Rank of " + input + " is "
							+ (rbt.size() - k + 1));
				}
			} else if (ops == 4) {
				int k = rbt.size() - input + 1;
				System.out.println("Rank " + input + " element is "
						+ rbt.findRank(k));
			}else if(ops==5){
				int k = rbt.OsRedRank(input);
				System.out.println(k);
				//System.out.println(rbt.tree.key);
				System.out.println(rbt.tree.redSubtreeSize-k+1);
			}
		}
	    rbt.inorder(rbt.tree);
		s.close();
	}

}
