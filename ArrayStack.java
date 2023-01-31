
public class ArrayStack<E> implements Stack<E>{
	private E[] data;
	private static final int CAPACITY = 1000;
	private int t = -1;
	
	public ArrayStack() {
		this(CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int cap) {
		data = (E[]) new Object[cap];
	}
	
	@Override
	public int size() {
		return t + 1;
	}

	@Override
	public boolean isEmpty() {
		return t == -1;
	}

	@Override
	public E pop() {
		if (isEmpty()) return null;
		E ans = data[t];
		data[t] = null;
		t--;
		return ans;
		
	}

	@Override
	public void push(E e) throws IllegalStateException{
		if (size() == data.length) {
			throw new IllegalStateException();
		}
		t++;
		data[t] = e;
	}

	@Override
	public E top() {
		if (isEmpty()) return null;
		return data[t];
	}
	
	/** Demonstrates sample usage of a stack. */
	  public static void main(String[] args) {
	    Stack<Integer> S = new ArrayStack<>();  // contents: ()
	    S.push(5);                              // contents: (5)
	    S.push(3);                              // contents: (5, 3)
	    System.out.println(S.size());           // contents: (5, 3)     outputs 2
	    System.out.println(S.pop());            // contents: (5)        outputs 3
	    System.out.println(S.isEmpty());        // contents: (5)        outputs false
	    System.out.println(S.pop());            // contents: ()         outputs 5
	    System.out.println(S.isEmpty());        // contents: ()         outputs true
	    System.out.println(S.pop());            // contents: ()         outputs null
	    S.push(7);                              // contents: (7)
	    S.push(9);                              // contents: (7, 9)
	    System.out.println(S.top());            // contents: (7, 9)     outputs 9
	    S.push(4);                              // contents: (7, 9, 4)
	    System.out.println(S.size());           // contents: (7, 9, 4)  outputs 3
	    System.out.println(S.pop());            // contents: (7, 9)     outputs 4
	    S.push(6);                              // contents: (7, 9, 6)
	    S.push(8);                              // contents: (7, 9, 6, 8)
	    System.out.println(S.pop());            // contents: (7, 9, 6)  outputs 8
	  }
}
