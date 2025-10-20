package LinkedList_final;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<E> extends PositionList<E> implements Iterable<E>{
	private static class Node<E> implements Position<E>{
		private E element;
		private Node<E> prev;
		private Node<E> next;
		public Node(E e, Node<E> p, Node<E> n) {
			element = e; prev = p; next = n;
		}
		public E getElement() { return element; }
		public void setElement(E element) { this.element = element; }
		public Node<E> getPrev() { return prev; }
		public Node<E> getNext() { return next; }
		public void setPrev(Node<E> p) { prev = p; }
		public void setNext(Node<E> n) { next = n; }
	}
	
	private Node<E> header;
	private Node<E> trailer;
	private int size = 0;
	
	public DoublyLinkedList( ) {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}

	public Position<E> first(){
		if(size>0)
			return header.next;
		else
			return null;
		}
	public Position<E> last(){
		if(size>0)
			return trailer.prev;
		else
			return null;
	}
	private Node<E> validate_position(Position<E> p){
		if(p instanceof Node<E>)
			return (Node<E>)p;
		else
			throw new IllegalArgumentException();
	}
	public Position<E> after(Position<E> p){
		Node<E> node = validate_position(p).next;
		if(node != trailer)
			return node;
		else
			return null;
		};
	public Position<E> before(Position<E> p){
		Node<E> node = validate_position(p).prev;
		if(node != header)
			return node;
		else
			return null;
		};
	public int size() { return size; }
	public boolean isEmpty() { return size == 0; }

	public void addFirst(E e) {
		addBetween(e, header, header.getNext());
	}
	public void addLast(E e) {
		addBetween(e, trailer.getPrev(), trailer);
	}
	public E removeFirst( ) {
		if (isEmpty()) return null;
		return remove(header.getNext());
	}
	public E removeLast( ) {
		if (isEmpty()) return null;
		return remove(trailer.getPrev());
	}

	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		Node<E> newest = new Node<>(e, predecessor, successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);
		size++;
	}
	private E remove(Node<E> node) {
		Node<E> predecessor = node.getPrev( );
		Node<E> successor = node.getNext( );
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		return node.getElement( );
	}
	
	public E getAtIndex(int index) {
		if (index >= size)
				return null;
		Node<E> current_node = header;
		for (int i=0; i<index+1; i++) {
			current_node = current_node.getNext();
		}
		return current_node.getElement();
	}

	// Iterator implementation
	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			private Node<E> current = header.getNext(); // skip header

			@Override
			public boolean hasNext() {
				return current != trailer;
			}

			@Override
			public E next() {
				if (!hasNext()) throw new NoSuchElementException();
				E val = current.getElement();
				current = current.getNext();
				return val;
		}
		};
	}

	public static void main(String [] args) {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		for (int i = 1; i <= 10; i++) {
			list.addLast(i);
		}

		Iterator<Integer> iter = list.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
