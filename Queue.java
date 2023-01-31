
public interface Queue<E> {
	int size();
	
	boolean isEmpty();
	
	E dequeue();
	
	void enqueue(E e);
	
	E first();
}
