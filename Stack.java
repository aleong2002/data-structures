
public interface Stack<E> {
	// using ArrayList
	/*private ArrayList<E> contents = new ArrayList<E>();
	
	public void push(E elem) {
		contents.add(elem);
	}
	
	public E pop() {
		int top = contents.size() - 1;
		E ans = contents.get(top);
		contents.remove(top);
		return ans;
	} */
	
	int size();
	
	boolean isEmpty();
	
	E pop();  // removes and returns top element
	
	void push(E e);
	
	E top(); // returns only top element	

}
