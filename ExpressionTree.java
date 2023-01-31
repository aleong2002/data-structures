
public class ExpressionTree {
	private static class Node {
		Node left;
		Node right;
		Object e;
		
		public Node(Object o) {
			e = o;
		}
		
		public Node(Object o, Node left, Node right) {
			e = o;
			left = left;
			right = right;
		}
		
		public String toString() {
			return "" + e;
		}
	}

	private Node root;
	
	public ExpressionTree() {
		root = null;
	}
	
	public void leftChild(Node t, Object e) {
		root.left = new Node(e);
	}
	
	public void rightChild(Node r, Object e) {
		root.right = new Node(e);
	}
	
	public void build() {
		root = new Node('+');
		leftChild(root, '*');
		rightChild(root, '5');
		leftChild(root.left, '3');
		rightChild(root.right, '4');
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
	
	public void infix() {
		infix(root);
		System.out.println();
	}
	
	private void infix(Node t) {
		if (t.left != null) {
			System.out.println("(");
			infix(t.left);
		}
		System.out.println(t);
		
		if(t.right != null) {
			infix(t.right);
			System.out.println(")");
		}
	}
	
	public int evaluate() {
		return evaluate(root);
	}
	
	private int evaluate(Node t) {
		if (t.left == null) return (((Character)t.e).charValue() - 0);
		
		else {
			int left = evaluate(t.left);
			int right = evaluate(t.right);
			
			switch (((Character)t.e).charValue()) {
			case '+': return left + right;
			
			case '-': return left - right;
			
			case '*': return left * right;
			
			case '/': return left / right;
			}
				
		}
		return 0;
	}
	
	public static void main(String [] args)
	{
		ExpressionTree expressionTree = new ExpressionTree();
		expressionTree.build();
		System.out.println("inorder traversal");
		expressionTree.infix();
		System.out.println("postorder traversal");
		expressionTree.postfix();
		System.out.println ("evaluates to: " + expressionTree.evaluate());
	}
}
