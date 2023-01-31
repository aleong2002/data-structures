
public interface BSTInterface<T extends Comparable<T>> {
	static final int inorder = 1;
	static final int preorder = 2;
	static final int postorder = 3;
	
	boolean isEmpty();
	
	int size();
	
	boolean contains(T elem);
	
	T get(T elem);
	
	boolean remove(T elem);
	
	void add(T elem);
	
	int reset(int order);
	
	T getNext(int order);
}
