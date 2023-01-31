package QueueHW;

public interface Queue<E>{
	public void enqueue(E val);
	
	public E dequeue();
	
	public boolean isEmpty();
	
	public int size();
	
}