
public class BSTNode<T extends Comparable<T>> {
	protected T info;
	protected BSTNode<T> left;
	protected BSTNode<T> right;
	
	public BSTNode(T info) {
		info = info;
		left = null;
		right = null;
	}
	
	public void setInfo(T info) {
		info = info;
	}
	
	public T getInfo() {
		return info;
	}
	
	public void setLeft(BSTNode<T> link) {
		left = link;
	}
	
	public void setRight(BSTNode<T> link) {
		right = link;
	}
	
	public BSTNode<T> getLeft() {
		return left;
	}
	public BSTNode<T> getRight() {
		return right;
	}
}
