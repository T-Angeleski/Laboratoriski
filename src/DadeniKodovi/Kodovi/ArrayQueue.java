package DadeniKodovi.Kodovi;

import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E> {
	E[] elems;
	int length, front, rear;

	@SuppressWarnings("unchecked")
	public ArrayQueue(int maxLength) {
		elems = (E[]) new Object[maxLength];
		clear();
	}

	@Override
	public boolean isEmpty() {
		return length == 0;
	}

	@Override
	public int size() {
		return length;
	}

	@Override
	public E peek() {
		if (length > 0)
			return elems[front];
		else
			throw new NoSuchElementException();
	}

	@Override
	public void clear() {
		length = front = rear = 0;
	}

	@Override
	public void enqueue(E x) {
		elems[rear++] = x;
		if (rear == elems.length) rear = 0;
		length++;
	}

	@Override
	public E dequeue() {
		if (length > 0) {
			E frontmost = elems[front];
			elems[front++] = null;
			if (front == elems.length) front = 0;
			length--;
			return frontmost;
		} else
			throw new NoSuchElementException();
	}
}
