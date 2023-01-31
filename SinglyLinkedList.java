import SinglyLinkedList1.Node;

public class SinglyLinkedList<E> implements Cloneable{
	private class Node<E> {
		private Node<E> next;
		private E elem;
		
		public Node(E elem) {
			this.elem=elem;
		}
		
		public Node(E elem, Node<E> next) {
			this.elem = elem;
			this.next = next;
		}
		
		public void setNext(Node<E> n) {
			next = n;
		}
		
		public E getElement() {
			return elem;
		}
		
		public Node<E> getNext() {
			return next;
		}
		
		
	}

	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	
	public SinglyLinkedList() {
		
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public E first() {
		return head.getElement();
	}
	
	public E last() {
		return tail.getElement();
	}
	
	public void addFirst(E val) {
		head = new Node<>(val, head);
		if (isEmpty()) {
			tail = head;
		}
		size++;
	}
	
	public void addLast(E val) {
		Node<E> newest = new Node<>(val, null);
		if (isEmpty()) {
			head = newest;
		}
		else {
			tail.setNext(newest);
		}
		tail = newest;
		size++;
	}
	
	public E removeFirst() {
		if (isEmpty()) return null;
		
		E ans = head.getElement();
		head = head.getNext();
		size--;
		if (isEmpty()) tail = null;
		return ans;
	}
	
	public E removeLast() {
		if (isEmpty()) return null;
		if (size == 1) removeFirst();
		
		E ans = tail.getElement();
		Node<E> walk = head;
		while (walk.getNext() != null) {
			walk = walk.next;
		}
		tail = walk;
		size--;
		if (isEmpty()) head = null;
		return ans; 
	}
	
	public boolean equals(Object o) {
		if (o == null) return false;
		if (getClass() != o.getClass()) return false;
		
		SinglyLinkedList<E> other = (SinglyLinkedList) o;
		if (size != other.size) return false;
		
		Node<E> walkA = head;
		Node<E> walkB = other.head;
		
		while (walkA != null) {
			if (!(walkA.getElement().equals(walkB.getElement()))) return false;
			walkA = walkA.getNext();
			walkB = walkB.getNext();
		}
		
		return true;
	}
	public boolean find(E val) {
		Node<E> walk = head;
		while (walk!= null) {
			if (walk.getElement().equals(val)) {
				return true;
			}
			walk = walk.getNext();
		}
		return false;
	}
	
	public Node<E> locate(E val) {
		Node<E> walk = head;
		while (walk!= null) {
			if (walk.getElement().equals(val)) return walk;
			walk = walk.getNext();
		}
		return null;
	}
	
	public Node<E> locatePrior(E val) {
		if (isEmpty()) return null;
		Node<E> walk = head;
		while (walk.getNext()!= null) {
			if (walk.getNext().equals(val)) return walk.getNext();
			walk = walk.getNext();
		}
		return null;
	}
	
	public boolean insertAfter(E valafter, E newval) {
		Node<E> locate = locate(valafter);
		if (locate == null) return false;
		else {
			Node<E> newest = new Node<>(newval, locate.getNext());
			locate.setNext(newest);
			if (locate == tail) tail = newest;
			size++;
			return true;
		}
	}
	
	public boolean insertBefore(E valbefore, E newval) {
		Node<E> locate = locatePrior(valbefore);
		if (isEmpty()) return false;
		if(head.getElement().equals(valbefore)) {
			 Node<E> newest = new Node<>(newval, head);
			 tail = head.getNext();
			 size++;
			 return true;
		 }
		if (locate == null) return false;
		else {
			Node<E> newest = new Node<>(newval, locate.getNext());
			locate.setNext(newest);
			if (locate == head) head = newest;
			size++;
			return true;
		}
	}
	public void insert(int position, E val) {
		Node<E> newest = new Node<>(val, null);
		
		if (position == 1) {
			newest.next = head;
			head = newest;
		}
		else {
			Node<E> prev = head;
			int count = 1;
			while (count < position -1) {
				prev = prev.next;
				count++;
			}
			Node<E> current = prev.next;
			prev.next = newest;
			newest.next = current;
			
		}
	}
	
}