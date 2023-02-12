package DadeniKodovi.Kodovi;

interface Queue<E> {
	boolean isEmpty();

	int size();

	E peek();

	void clear();

	void enqueue(E x);

	E dequeue();
}
