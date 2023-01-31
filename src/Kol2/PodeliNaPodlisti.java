package Kol2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Element {
	private int id;

	public Element(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.valueOf(id);
	}
}

class SLLNodeK<E> {
	protected E element;
	protected SLLNodeK<E> succ;

	public SLLNodeK(E elem, SLLNodeK<E> succ) {
		this.element = elem;
		this.succ = succ;
	}

	@Override
	public String toString() {
		return element.toString();
	}
}

class SLL<E> {
	private SLLNodeK<E> first;

	public SLL() {
		this.first = null;
	}

	public void deleteList() {
		first = null;
	}

	public int length() {
		int ret;
		if (first != null) {
			SLLNodeK<E> tmp = first;
			ret = 1;
			while (tmp.succ != null) {
				tmp = tmp.succ;
				ret++;
			}
			return ret;
		} else
			return 0;

	}

	@Override
	public String toString() {
		String ret = new String();
		if (first != null) {
			SLLNodeK<E> tmp = first;
			ret += tmp;
			while (tmp.succ != null) {
				tmp = tmp.succ;
				ret += " -> " + tmp;
			}
		} else
			ret = "Prazna lista!!!";
		return ret;
	}

	public void insertFirst(E o) {
		SLLNodeK<E> ins = new SLLNodeK<E>(o, first);
		first = ins;
	}

	public void insertAfter(E o, SLLNodeK<E> node) {
		if (node != null) {
			SLLNodeK<E> ins = new SLLNodeK<E>(o, node.succ);
			node.succ = ins;
		} else {
			System.out.println("Dadenot jazol e null");
		}
	}

	public void insertBefore(E o, SLLNodeK<E> before) {
		if (first != null) {
			SLLNodeK<E> tmp = first;
			if (first == before) {
				this.insertFirst(o);
				return;
			}
			while (tmp.succ != before)
				tmp = tmp.succ;
			if (tmp.succ == before) {
				SLLNodeK<E> ins = new SLLNodeK<E>(o, before);
				tmp.succ = ins;
			} else {
				System.out.println("Elementot ne postoi vo listata");
			}
		} else {
			System.out.println("Listata e prazna");
		}
	}

	public void insertLast(E o) {
		if (first != null) {
			SLLNodeK<E> tmp = first;
			while (tmp.succ != null)
				tmp = tmp.succ;
			SLLNodeK<E> ins = new SLLNodeK<E>(o, null);
			tmp.succ = ins;
		} else {
			insertFirst(o);
		}
	}

	public E deleteFirst() {
		if (first != null) {
			SLLNodeK<E> tmp = first;
			first = first.succ;
			return tmp.element;
		} else {
			System.out.println("Listata e prazna");
			return null;
		}
	}

	public E delete(SLLNodeK<E> node) {
		if (first != null) {
			SLLNodeK<E> tmp = first;
			if (first == node) {
				return this.deleteFirst();
			}
			while (tmp.succ != node && tmp.succ.succ != null)
				tmp = tmp.succ;
			if (tmp.succ == node) {
				tmp.succ = tmp.succ.succ;
				return node.element;
			} else {
				System.out.println("Elementot ne postoi vo listata");
				return null;
			}
		} else {
			System.out.println("Listata e prazna");
			return null;
		}
	}

	public SLLNodeK<E> getFirst() {
		return first;
	}

	public void setFirst(SLLNodeK<E> node) {
		first = node;
	}

	public SLLNodeK<E> find(E o) {
		if (first != null) {
			SLLNodeK<E> tmp = first;
			while (tmp.element != o && tmp.succ != null)
				tmp = tmp.succ;
			if (tmp.element == o) {
				return tmp;
			} else {
				System.out.println("Elementot ne postoi vo listata");
			}
		} else {
			System.out.println("Listata e prazna");
		}
		return first;
	}
}

public class PodeliNaPodlisti {

	private static void listTransform(SLL<Element> original) {
		// dolzina / 10   ->   1.4   Prvi 4 po 2 elementi, naredni po 1 element
		// 4.2  -> Prvi 2 po 5 elementi, naredni 8 po 4

		int dolzina = original.length();
		int brojPovekje = dolzina % 10;
		int poKolkuPovekje = (dolzina / 10) + 1;
		int poKolkuOstanati = dolzina / 10;

		//14 elem -> 4 * 2, 6 * 1
		List<SLL<Element>> result = new ArrayList<>();
		SLLNodeK<Element> tmp = original.getFirst();
		for (int i = 0; i < 10; i++) {
			SLL<Element> nova = new SLL<>();
			if (i < brojPovekje) {
				int count = poKolkuPovekje;
				while (count != 0) {
					nova.insertLast(tmp.element);
					tmp = tmp.succ;
					--count;
				}
			} else {
				int count = poKolkuOstanati;
				while (count != 0) {
					nova.insertLast(tmp.element);
					tmp = tmp.succ;
					--count;
				}
			}
			result.add(nova);
		}

		System.out.println(result);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = Integer.parseInt(scanner.nextLine());
		SLL<Element> list = new SLL<Element>();

		for (int i = 0; i < num; i++) {
			int n = scanner.nextInt();
			list.insertLast(new Element(n));
		}

		listTransform(list);
	}
}
