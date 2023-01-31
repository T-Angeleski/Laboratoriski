package DadeniKodovi.Heshiranje_Kodovi;

public class SLL<E> {
	public SLLNode<E> first;

	public SLL() {
		first = null;
	}

	public void insertFirst(E element) {
		SLLNode<E> nov = new SLLNode<>(element, first);
		first = nov;
	}

	public void insertLast(E element) {
		if (first == null) insertFirst(element);
		else {
			SLLNode<E> dvizi = first;
			while (dvizi.succ != null) {
				dvizi = dvizi.succ;
			}
			SLLNode<E> last = new SLLNode<>(element, null);
			dvizi.succ = last;
		}
	}

	public void insertAfter(E element, SLLNode<E> node) {
		if (node != null) {
			SLLNode<E> nov = new SLLNode<>(element, node.succ);
			node.succ = nov;
		}
	}

	public int getLength() {
		SLLNode<E> dvizi = first;
		int length = 0;
		while (dvizi != null) {
			length++;
			dvizi = dvizi.succ;
		}
		return length;
	}


	public String toString() {
		String s = new String();
		SLLNode<E> dvizi = first;
		while (dvizi != null) {
			s = s + dvizi.element + " ";
			dvizi = dvizi.succ;
		}
		return s;
	}

	public SLLNode<E> getFirst() {
		return first;
	}

}
