
public class LinkedStack <E> implements Stack<E>{
	private static class Node<E> {
		private E data;
		private Node<E> next;
		
		public Node() {
			
		}
		
		public Node(E data) {
			this.data = data;
		}
		
		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
		
		public E getElement() {
			return data;
		}
		
		public Node<E> getNext() {
			return next;
		}
		
		public void setNext(Node<E> n) {
			next = n;
		}
		
		public void setElement(E e) {
			data = e;
		}
	}

	private SinglyLinkedList1<E> list = new SinglyLinkedList1<E>();
	
	public LinkedStack() {
		
	}
	
	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.size() == 0;
	}

	@Override
	public E pop() {
		if (isEmpty()) return null;
		return list.removeFirst();
	}

	@Override
	public void push(E e) {
		list.addFirst(e);
	}

	@Override
	public E top() {
		// TODO Auto-generated method stub
		return list.first();
	}

}
