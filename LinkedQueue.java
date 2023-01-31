
public class LinkedQueue<E> implements Queue<E> {
	private SinglyLinkedList1<E> list = new SinglyLinkedList1<E>();
	
	public LinkedQueue() {
		
	}
	
	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public E dequeue() {
		if (isEmpty()) return null;
		
		return list.removeFirst();
	}

	@Override
	public void enqueue(E e) {
		list.addLast(e);
	}

	@Override
	public E first() {
		if (isEmpty()) return null;
		return list.first();
	}

}
