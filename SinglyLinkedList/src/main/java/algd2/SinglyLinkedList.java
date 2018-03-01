package algd2;

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> {

	Element<E> head = null, r;
	int size = 0;

	/**
	 * Default-Konstruktor (erzeugt leere Liste)
	 */
	SinglyLinkedList() {
		head = null;
		size = 0;
	}

	/**
	 * Kopierkonstruktor (Struktur tief kopieren)
	 * 
	 * @param orig
	 */
	SinglyLinkedList(SinglyLinkedList<E> orig) {

		for (int i = orig.size()-1; i >= 0; i--) {
			insertFirst(orig.get(i));
		}

	}

	/**
	 * Einfügen am Kopf (Anker)
	 * 
	 * @param e
	 */
	void insertFirst(E e) {
		if (head == null) {
			head = new Element<>(e, null);
		} else {
			head = new Element<>(e, head);
		}
		++size;
	}

	/**
	 * Einfügen nach Element i
	 * 
	 * @param e
	 * @param index
	 */
	void insertAfter(E e, int index) {
		checkIndex(index);

		Element<E> current = head;

		if (index == 0) {
			insertFirst(e);
		} else {
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			current.next = new Element<>(e, current.next);
			++size;
		}
	}

	/**
	 * Löschen des ersten Elements
	 */
	void removeFirst() {

		if (head == null) {
			throw new NoSuchElementException();
		}

		head = head.next;
		--size;
	}

	/**
	 * Löschen des Elements mit Nummer index
	 * 
	 * @param index
	 */
	void remove(int index) {

		checkIndex(index);

		Element<E> current = head;
		Element<E> prev = null;

		for (int i = 0; i < index; i++) {
			prev = current;
			current = current.next;
		}

		prev.next = current.next;
		--size;
	}

	/**
	 * Liste leeren
	 */
	void removeAll() {
		head = null;
		size = 0;
	}

	/**
	 * erstes Element abfragen (ohne Löschen)
	 * 
	 * @return
	 */
	E getFirst() {

		if (head == null) {
			throw new NoSuchElementException();
		}

		return head.data;
	}

	/**
	 * desgleichen mit Element Nr. index
	 * 
	 * @param index
	 * @return
	 */
	E get(int index) {

		checkIndex(index);

		Element<E> current = head;

		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.data;
	}

	int size() {
		return size;
	}

	@Override
	public String toString() {
		return "SinglyLinkedList [head=" + head + ", r=" + r + ", size=" + size + "]";
	}

	void checkIndex(int index) {
		if (index >= size) {
			throw new IndexOutOfBoundsException();
		}
	}

}

class Element<T> {

	T data;
	Element<T> next;

	Element(T data, Element<T> next) {
		this.data = data;
		this.next = next;
	}

}
