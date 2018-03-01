package algd2;

import java.util.NoSuchElementException;

public class Stack<E> extends SinglyLinkedList<E> {

	E top() {
		return getFirst();
	}

	void push(E data) {
		insertFirst(data);
	}

	E pop() {
		if (head == null) {
			throw new NoSuchElementException();
		}

		Element<E> old = head;
		head = head.next;
		--size;
		return old.data;
	}

	boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public String toString() {
		Element<E> current = head;
		StringBuilder sb = new StringBuilder();
		while (!isEmpty() && current != null) {
			sb.append(current.data);
			if(current.next!=null)
				sb.append("-");
			current = current.next;
		}
		return sb.toString();
	}

}
