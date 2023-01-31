
public class BinarySearchTreeWeiss {
	private static class BinaryNode {
		private Comparable o;
		private BinaryNode left;
		private BinaryNode right;
		
		public BinaryNode(Comparable e) {
			this(e, null, null);
		}
		
		public BinaryNode(Comparable e, BinaryNode l, BinaryNode r) {
			o = e;
			left = l;
			right = r;
		}
	
	}

	private BinaryNode root;
	
	public BinarySearchTreeWeiss() {
		root = null;
	}
	
	public void insert(Comparable x) {
		root = insert(x, root);
	}
	private BinaryNode insert(Comparable x, BinaryNode n) {
		if (x == null) root = new BinaryNode(x, null, null);
		
		else if (x.compareTo(n.o) < 0) {
			n.left = insert(x, n.left);
		}
		
		else if (x.compareTo(n.o) > 0) {
			n.right = insert(x, n.right);
		}
		else ;
		return n;
	}
	
	public void insertBad(Comparable x) {
		root = insertBad(x, root);
	}
	
	private BinaryNode insertBad(Comparable x, BinaryNode t) {
		if (t == null) {
			t = new BinaryNode(x, null, null);
		}
		else {
			t.left = insert(x, t.left);
			
		}
		return t;
	}
	
	public void remove(Comparable x) {
		root = remove(x, root);
	}
	
	private BinaryNode remove(Comparable x, BinaryNode t) {
		if (t == null) return t;
		if (x.compareTo(t.o) < 0) {
			t.left = remove(x, t.left);
		}
		else if (x.compareTo(t.o) > 0) {
			t.right = remove(x, t.right);
		}
		else if (t.left != null && t.right != null) {
			t.o = findMin(t.right).o;
			t.right = remove(t.o, t.right);
		}
		else {
			t = (t.left != null) ? t.left: t.right;
		}
		return t;
		
	}
	
	public Comparable findMin() {
		return elementAt(findMin(root));
	}
	
	private BinaryNode findMin(BinaryNode t) {
		if (t == null) return null;
		else if (t.left == null) return t;
		return findMin(t.left);
	}
	
	public Comparable findMax() {
		return elementAt(findMax(root));
	}
	
	private BinaryNode findMax(BinaryNode t) {
		if (t != null) {
			while (t.right != null) {
				t = t.right;
			}
		}
		return t;
	}
	
	public void makeEmpty() {
		root = null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public BinaryNode find(Comparable x, BinaryNode t) {
		if (t == null) return null;
		if (x.compareTo(t.o) < 0) {
			return find(x, t.left);
		}
		
		else if (x.compareTo(t.o) >0) {
			return find(x, t.right);
		}
		
		else return t;
	}
	
	public void printTree() {
		if(isEmpty()) System.out.println("Empty tree");
		else {
			printTree(root);
		}
	}
	
	private void printTree(BinaryNode t) {
		if (t != null) {
			printTree(t.left);
			System.out.println(t.o);
			printTree(t.right);
		}
	}
	
	public boolean equals(Object o) {
		if (!(o instanceof BinarySearchTreeWeiss )) {
			return false;
		}
		BinarySearchTreeWeiss other = (BinarySearchTreeWeiss) o;
		return equals(this.root, other.root);
	}
	
	private boolean equals(BinaryNode th, BinaryNode other) {
		if (th == null && other == null) return true;
		
		else if(th == null || other == null) return false;
	
		else if(!(th.o.equals(other.o))) {
			return false;
		}
		else {
			return (equals(th.left, other.left) && equals(th.right, other.right));
		}
	}
	public boolean testTreeProperty() {
		if (root == null) return true;
		return (testTreeProperty (root.left, null, root.o) && testTreeProperty(root.right, root.o, null));
	}
	private boolean testTreeProperty(BinaryNode th, Comparable low, Comparable high) {
		if (th == null) return true;
		
		boolean current;
		
		if (low == null) {
			current = (th.o.compareTo(high)<0);
		}
		
		else if (high == null) {
			current = (th.o.compareTo(low) > 0);
		}
		else {
			current = (th.o.compareTo(low) > 0) && (th.o.compareTo(high) <0);
		}
		return (current && testTreeProperty(th.left, low, th.o) && testTreeProperty(th.right, th.o, high));
	
	}
	
	public BinarySearchTreeWeiss copyTree() {
		BinarySearchTreeWeiss result = new BinarySearchTreeWeiss();
		result.root = copyTree(this.root);
		return result;
	}
	
	private BinaryNode copyTree(BinaryNode t) {
		if (t == null) return null;
		
		BinaryNode left = copyTree(t.left);
		BinaryNode right = copyTree(t.right);
		return new BinaryNode(t.o, left, right);
	}
	
	public boolean isSimilar(BinarySearchTreeWeiss o) {
		if (o == null) return false;
		return isSimilar(this.root, o.root);
	}
	
	private boolean isSimilar(BinaryNode th, BinaryNode other) {
		if (th == null && other == null)  return true;
		else if (th == null || other == null) return false;
		else {
			return (isSimilar(th.left, other.left) && isSimilar(th.right, other.right));
		}
	}
	
}	
