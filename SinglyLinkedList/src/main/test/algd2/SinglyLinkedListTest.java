package algd2;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class SinglyLinkedListTest {

	@Test
	void testInsertFirst() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		list.insertFirst(2);

		Assert.assertEquals(2, list.get(0).intValue());
		Assert.assertEquals(1, list.get(1).intValue());
	}

	@Test
	void testInsertAfter() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		list.insertFirst(1);
		list.insertAfter(2, 1);

		Assert.assertEquals(2, list.get(2).intValue());
		Assert.assertEquals(1, list.get(1).intValue());
		Assert.assertEquals(1, list.get(0).intValue());

	}

	@Test
	void testRemoveFirst() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		list.insertFirst(2);

		Assert.assertEquals(2, list.get(0).intValue());
		Assert.assertEquals(1, list.get(1).intValue());

		list.removeFirst();

		Assert.assertEquals(1, list.get(0).intValue());

	}

	@Test
	void testRemove() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		list.insertFirst(2);
		list.insertFirst(3);

		list.remove(1);

		Assert.assertEquals(2, list.size());
		Assert.assertEquals(3, list.get(0).intValue());
		Assert.assertEquals(1, list.get(1).intValue());

	}

	@Test
	void testRemoveAll() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		list.insertFirst(2);
		list.insertFirst(3);

		list.removeAll();

		Assert.assertEquals(0, list.size());
	}

	@Test
	void testGetFirst() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		list.insertFirst(2);
		list.insertFirst(3);

		Assert.assertEquals(3, list.getFirst().intValue());

	}

	@Test
	void testGet() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		list.insertFirst(2);
		list.insertFirst(3);

		Assert.assertEquals(3, list.get(0).intValue());
		Assert.assertEquals(2, list.get(1).intValue());
		Assert.assertEquals(1, list.get(2).intValue());

	}

	@Test
	void testSize() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		list.insertFirst(2);
		list.insertFirst(3);

		Assert.assertEquals(3, list.size());

		list.removeFirst();

		assertEquals(2, list.size());
	}

	@Test
	void testInsertAfterIOBE() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.insertAfter(2, 3);
		});
	}

	@Test
	void testRemoveIOBE() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.remove(2);
		});
	}

	@Test
	void testGetIOBE() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.get(2);
		});
	}

	@Test
	void testRemoveFirstNSEE() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		assertThrows(NoSuchElementException.class, () -> {
			list.removeFirst();
		});
	}

	@Test
	void testGetFirstNSEE() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		assertThrows(NoSuchElementException.class, () -> {
			list.getFirst();
		});
	}

	@Test
	void deepCopy() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertFirst(1);
		list.insertFirst(2);
		list.insertFirst(3);

		SinglyLinkedList<Integer> copy = new SinglyLinkedList<>(list);

		Assert.assertEquals(list.get(0).intValue(), copy.get(0).intValue());
		Assert.assertEquals(list.get(1).intValue(), copy.get(1).intValue());
		Assert.assertEquals(list.get(2).intValue(), copy.get(2).intValue());

		Assert.assertTrue(list.head != copy.head);
		Assert.assertTrue(list.head.next != copy.head.next);
		Assert.assertTrue(list.head.next.next != copy.head.next.next);
	}

}
