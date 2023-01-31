
public class DoublyLinkedList<E> {
	private static class Node<E> {

		private Node<E> next;
		private Node<E> prev;
		private E elem;
		
		public Node(E elem, Node<E> n, Node<E> p) {
			this.elem = elem;
			this.next = n;
			this.prev = p;
		}
		
		public void setNext(Node<E> e) {
			next = e;
		}
		
		public void setPrev(Node<E> e) {
			prev = e;
		}
		
		public Node<E> getNext() {
			return next;
		}
		
		public E getElement() {
			return elem;
		}
		
		public Node<E> getPrev() {
			return prev;
		}
		
	}

	private Node<E> head; //sentinel node header
	private Node<E> tail; //sentinel node trailer
	private int size = 0;
	
	public DoublyLinkedList() {
		head = new Node<>(null, null, null);
		tail = new Node<>(null, head, null);
		head.setNext(tail);
	}
	 
	public int size() {
		 return size;
	 }
	 
	 public boolean isEmpty() {
		 return size==0;
	 }
	 
	 public E first() {
		 if (isEmpty()) return null;
		 return head.getNext().getElement();
	 }
	 
	 public E last() {
		 if(isEmpty()) return null;
		 return tail.getNext().getElement();
	 }
	 
	 public void addFirst(E e) {
		 addBetween(e, head, head.getNext());
		 
	 }
	 
	 public void addLast(E e) {
		 addBetween(e, tail.getPrev(), tail);
	 }
	 
	 public E removeFirst() {
		 if (isEmpty()) return null;
		 		 
		 return remove(head.getNext());
	 }
	 
	 public E removeLast() {
		 if (isEmpty()) return null;
		 return remove(tail.getPrev());
	 }
	 
	 public void display() {
		 Node<E> walk = head;
		 while (walk != null) {
			 System.out.println(walk.getElement() + " --> ");
			 walk = walk.next;
		 }
		 System.out.println("null");
	 }
	 
	 public void reverse() {
		 Node<E> walk = tail;
		 
		 while (walk != null) {
			 System.out.println(walk.getElement() + " --> ");
			 walk = walk.getPrev();
		 }
		 System.out.println("null");
	 }
	 
	 private void addBetween(E e, Node<E> prev, Node<E> next) {
		Node<E> newest = new Node<> (e, prev, next);
		prev.setNext(newest);
		next.setPrev(newest);
		size++;
	 }
	 
	 private E remove(Node<E> node) {
		 if(isEmpty()) return null;
		 
		 Node<E> predecessor = node.getPrev();
		 Node<E> successor = node.getNext();
		 
		 predecessor.setNext(successor);
		 successor.setPrev(predecessor);
		 size--;
		 return node.getElement();
		 
	 }
	 
	 @SuppressWarnings("unchecked")
	public boolean equals(Object o) {
		 if (o == null) return false;
		 if (getClass() != o.getClass()) return false;
		 
		 DoublyLinkedList other = (DoublyLinkedList) o;
		 if (size() != other.size()) return false;
		 
		 Node<E> walkA = head;
		 Node<E> walkB = other.head;
		 
		 while (walkA.getNext() != null) {
			 if (!walkA.getElement().equals(walkB.getElement())) {
				 return false;
			 }
			 walkA = walkA.getNext();
			 walkB = walkB.getNext();
		 }
		 return true;
	 }
	
}
	 
	
	

