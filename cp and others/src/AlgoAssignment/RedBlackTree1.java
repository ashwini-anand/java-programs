package AlgoAssignment;

import java.util.Scanner;

class RBTree1 {
	public static final short BLACK = 0;
	public static final short RED = 1;
	short color;
	RBTree left, right, parent;
	Integer key;
	String value;
	int stsize;

	final RBTree rotateLeft(RBTree root) {
		RBTree temp = right;
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
//		temp.stsize = this.stsize;
//		this.stsize = this.left.stsize + this.right.stsize + 1;
		return root;
	}

	final RBTree rotateRight(RBTree root) {
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
//		temp.stsize = this.stsize;
//		this.stsize = this.left.stsize + this.right.stsize + 1;
		return root;
	}

	final RBTree successorGet() {
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

public class RedBlackTree1 {
	public RBTree tree;
	public int size;
	public boolean keyFound;
	public Object prevValue;

	public RedBlackTree1() {
		tree = null;
		size = 0;
	}

	public synchronized Object put(int key, String value) {
		RBTree node = new RBTree();
		node.key = key;
		node.value = value;
		keyFound = false;
		tree = insert(node, tree);
		if (keyFound)
			return prevValue;
		else {
			size++;
			return null;
		}
	}

	public synchronized Object get(Integer key) {
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

	public int OsRank(Integer key) {
		RBTree t = tree;
		int comp,r=0;

		while (t != null && (comp = key.compareTo(t.key)) != 0) {
			if (comp < 0)
				t = t.left;
			else
				t = t.right;
		}
		
//		if(t!=null){
//			r=t.left.stsize +1;
//			RBTree z=t;
//			while(z!=null){
//				if(z==z.parent.right) r =r + z.parent.left.stsize +1;
//				z=z.parent;
//			}
//		}
		return r;
		
	}
	
	public synchronized Object remove(Integer key) {
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

	private RBTree insert(RBTree node, RBTree tree) {
		RBTree father = null, son = tree;
		while (son != null) {
			//son.stsize += 1;
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
		node.parent = father;
		if (father == null)
			tree = node;
		else if (node.key.compareTo(father.key) < 0)
			father.left = node;
		else
			father.right = node;
		node.color = RBTree.RED;
		while (node != tree && node.parent.color == RBTree.RED) {
			if (node.parent == node.parent.parent.left) {
				son = node.parent.parent.right;
				if (son != null && son.color == RBTree.RED) {
					node.parent.color = RBTree.BLACK;
					son.color = RBTree.BLACK;
					node = node.parent.parent;
					node.color = RBTree.RED;
				} else {
					if (node == node.parent.right) {
						node = node.parent;
						tree = node.rotateLeft(tree);
					}
					node.parent.color = RBTree.BLACK;
					node.parent.parent.color = RBTree.RED;
					tree = node.parent.parent.rotateRight(tree);
				}
			} else {
				son = node.parent.parent.left;
				if (son != null && son.color == RBTree.RED) {
					node.parent.color = RBTree.BLACK;
					son.color = RBTree.BLACK;
					node = node.parent.parent;
					node.color = RBTree.RED;
				} else {
					if (node == node.parent.left) {
						node = node.parent;
						tree = node.rotateRight(tree);
					}
					node.parent.color = RBTree.BLACK;
					node.parent.parent.color = RBTree.RED;
					tree = node.parent.parent.rotateLeft(tree);
				}
			}
		}
		tree.color = RBTree.BLACK;
		return tree;
	}

	private RBTree delete(RBTree node, RBTree tree) {
		System.out.println("Here");
		RBTree x, y;
		if (node.left == null || node.right == null)
			y = node;
		else {
			y = node.successorGet();
			RBTree z = y;
//			while (z != null) {
//				z.stsize = z.stsize - 1;
//				z = z.parent;
//			}
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
			RBTree father = y.parent;
			while (x != tree && (x == null || x.color == RBTree.BLACK)) {
				if (x == father.left) {
					RBTree w = father.right;
					if (w == null)
						x = tree;
					else {
						if (w.color == RBTree.RED) {
							w.color = RBTree.BLACK;
							father.color = RBTree.RED;
							tree = father.rotateLeft(tree);
							continue;
						}
						if ((w.left == null || w.left.color == RBTree.BLACK)
								&& (w.right == null || w.right.color == RBTree.BLACK)) {
							w.color = RBTree.RED;
							x = father;
							father = x.parent;
						} else {
							if (w.right == null
									|| w.right.color == RBTree.BLACK) {
								if (w.left != null) {
									w.left.color = RBTree.BLACK;
									w.color = RBTree.RED;
									tree = w.rotateRight(tree);
									w = father.right;
								}
							}
							w.color = father.color;
							father.color = RBTree.BLACK;
							if (w.right != null)
								w.right.color = RBTree.BLACK;
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
							w.color = RBTree.BLACK;
							father.color = RBTree.RED;
							tree = father.rotateRight(tree);
							continue;
						}
						if ((w.right == null || w.right.color == RBTree.BLACK)
								&& (w.left == null || w.left.color == RBTree.BLACK)) {
							w.color = RBTree.RED;
							x = father;
							father = x.parent;
						} else {
							if (w.left == null || w.left.color == RBTree.BLACK) {
								if (w.right != null) {
									w.right.color = RBTree.BLACK;
									w.color = RBTree.RED;
									tree = w.rotateLeft(tree);
									w = father.left;
								}
							}
							w.color = father.color;
							father.color = RBTree.BLACK;
							if (w.left != null)
								w.left.color = RBTree.BLACK;
							tree = father.rotateRight(tree);
							x = tree;
						}
					}
				}
			}
			if (x != null)
				x.color = RBTree.BLACK;
		}

		return tree;
	}

	public static void main(String[] args) {
		RedBlackTree1 rbt = new RedBlackTree1();
		Scanner s = new Scanner(System.in);
		int ops = 1;
		while (ops != -1) {
			ops = s.nextInt();
			int input = s.nextInt();
			if (ops == 1) {
				rbt.put(input, "ABCD");
			} else if (ops == 0) {
				String t = (String) rbt.get(input);
				System.out.println(t);
				if (t != null)
					System.out.println("Element found="+input);
				else
					System.out.println("Element not found="+input);
			} else if (ops == 2) {
				rbt.remove(input);
			}else if(ops==3){
				//int k = rbt.OsRank(input);
				System.out.println("TBD ");
			}
		}
	}

}
