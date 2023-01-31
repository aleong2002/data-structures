
public class LinkedNodes<E>{
	private class Node<E> {
		private Node<E> next;
		private E element;
		
		public Node(E element) {
			next = null;
			element = element;
		}
		
		public Node(E element, Node<E> n) {
			element = element;
			next = n;
		}
		
		public void setNext(Node<E> n) {
			next = n;
		}
		
		public Node<E> getNext() {
			return next;
		}
		
		public E getElement() {
			return element;
		}
		
	}
		
	private Node<E> head = null;
	private int size = 0;
	
	public LinkedNodes() {
		
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
}

