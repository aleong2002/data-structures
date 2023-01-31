
public class TreeTraversal {
	private static class Node {
		private Node left;
		private Node right;
		private Object element;
		
		public Node(Object e) {
			this(e, null, null);
		}
		
		public Node(Object element, Node left, Node right) {
			this.element = element;
			this.left = left;
			this.right = right;
		}
		
		public String toString() {
			return "" + element;
		}
	}
	
	private Node root;
	
	public TreeTraversal() {
		root = null;
	}
	
	public void leftChild(Node t, Object e) {
		t.left = new Node(e);
		
	}
	
	public void rightChild(Node t, Object e) {
		t.right = new Node(e);
	}
	
	public void build() {
		root = new Node('a');
		leftChild(root,'b');
		rightChild(root, 'c');
		leftChild(root.left, 'd');
		rightChild(root.left, 'e');
	}
	
	public void postfix() {
		postfix(root);
		System.out.println();
	}
	
	private void postfix(Node t) {
		if (t != null) {
			postfix(t.left);
			postfix(t.right);
			System.out.println(t);
		}
		
	}
	
	public void prefix() {
		prefix(root);
		System.out.println();
	}
	
	private void prefix(Node t) {
		if (t != null) {
			System.out.println(t);
			prefix(t.left);
			prefix(t.right);
		}
	}
	
	public void infix() {
		infix(root);
		System.out.println();
	}
	
	private void infix(Node t) {
		if (t != null) {
			infix(t.left);
			System.out.println(t);
			infix(t.right);
		}
	}
	public static void main(String [] args)
	{
		TreeTraversal t = new TreeTraversal();
		t.build();
		System.out.println("preorder traversal");
		t.prefix();
		System.out.println("inorder traversal");
		t.infix();
		System.out.println("postorder traversal");
		t.postfix();
	}
}
