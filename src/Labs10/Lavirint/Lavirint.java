package Labs10.Lavirint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

interface Stack<E> {
	// Elementi na stekot se objekti od proizvolen tip.

	// Metodi za pristap:

	public boolean isEmpty();
	// Vrakja true ako i samo ako stekot e prazen.

	public E peek();
	// Go vrakja elementot na vrvot od stekot.

	// Metodi za transformacija:

	public void clear();
	// Go prazni stekot.

	public void push(E x);
	// Go dodava x na vrvot na stekot.

	public E pop();
	// Go otstranuva i vrakja elementot shto e na vrvot na stekot.
}

interface Queue<E> {

	// Elementi na redicata se objekti od proizvolen tip.

	// Metodi za pristap:

	public boolean isEmpty();
	// Vrakja true ako i samo ako redicata e prazena.

	public int size();
	// Ja vrakja dolzinata na redicata.

	public E peek();
	// Go vrakja elementot na vrvot t.e. pocetokot od redicata.

	// Metodi za transformacija:

	public void clear();
	// Ja prazni redicata.

	public void enqueue(E x);
	// Go dodava x na kraj od redicata.

	public E dequeue();
	// Go otstranuva i vrakja pochetniot element na redicata.
}

class SLLNode<E> {
	protected E element;
	protected SLLNode<E> succ;

	public SLLNode(E elem, SLLNode<E> succ) {
		this.element = elem;
		this.succ = succ;
	}

	@Override
	public String toString() {
		return element.toString();
	}
}

class Point {
	public int i;
	public int j;
	public Point previous;

	public Point(int i, int j, Point previous) {
		this.i = i;
		this.j = j;
		this.previous = previous;
	}
}

class LinkedStack<E> implements Stack<E> {
	//Stekot e pretstaven na sledniot nacin: top e link do prviot jazol
	// na ednostrano-povrzanata lista koja sodrzi gi elementite na stekot .
	private SLLNode<E> top;

	public LinkedStack() {
		// Konstrukcija na nov, prazen stek.
		top = null;
	}

	public boolean isEmpty() {
		// Vrakja true ako i samo ako stekot e prazen.
		return (top == null);
	}

	public E peek() {
		// Go vrakja elementot na vrvot od stekot.
		if (top == null)
			throw new NoSuchElementException();
		return top.element;
	}

	public void clear() {
		// Go prazni stekot.
		top = null;
	}

	public void push(E x) {
		// Go dodava x na vrvot na stekot.
		top = new SLLNode<E>(x, top);
	}

	public E pop() {
		// Go otstranuva i vrakja elementot shto e na vrvot na stekot.
		if (top == null)
			throw new NoSuchElementException();
		E topElem = top.element;
		top = top.succ;
		return topElem;
	}
}

class LinkedQueue<E> implements Queue<E> {

	// Redicata e pretstavena na sledniot nacin:
	// length go sodrzi brojot na elementi.
	// Elementite se zachuvuvaat vo jazli dod SLL
	// front i rear se linkovi do prviot i posledniot jazel soodvetno.
	SLLNode<E> front, rear;
	int length;

	// Konstruktor ...

	public LinkedQueue() {
		clear();
	}

	public boolean isEmpty() {
		// Vrakja true ako i samo ako redicata e prazena.
		return (length == 0);
	}

	public int size() {
		// Ja vrakja dolzinata na redicata.
		return length;
	}

	public E peek() {
		// Go vrakja elementot na vrvot t.e. pocetokot od redicata.
		if (front == null)
			throw new NoSuchElementException();
		return front.element;
	}

	public void clear() {
		// Ja prazni redicata.
		front = rear = null;
		length = 0;
	}

	public void enqueue(E x) {
		// Go dodava x na kraj od redicata.
		SLLNode<E> latest = new SLLNode<E>(x, null);
		if (rear != null) {
			rear.succ = latest;
			rear = latest;
		} else
			front = rear = latest;
		length++;
	}

	public E dequeue() {
		// Go otstranuva i vrakja pochetniot element na redicata.
		if (front != null) {
			E frontmost = front.element;
			front = front.succ;
			if (front == null) rear = null;
			length--;
			return frontmost;
		} else
			throw new NoSuchElementException();
	}
}

public class Lavirint {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] tokens = line.split(",");
		int M = Integer.parseInt(tokens[0]);
		int N = Integer.parseInt(tokens[1]);
		char[][] lavirint = new char[M][N];
		boolean[][] visited = new boolean[M][N];
		Queue<Point> queue = new LinkedQueue<>();
		Stack<Point> stack = new LinkedStack<>();
		int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		Point point = null;

		for (int i = 0; i < M; i++) {
			line = br.readLine();

			for (int j = 0; j < N; j++) {
				lavirint[i][j] = line.charAt(j);

				if (lavirint[i][j] == 'S') {
					visited[i][j] = true;
					queue.enqueue(new Point(i, j, null));
				}
			}
		}

		while (!queue.isEmpty()) {
			point = queue.dequeue();

			if (lavirint[point.i][point.j] == 'E') {
				break;
			}

			for (int[] a : moves) {
				int x = point.i + a[0];
				int y = point.j + a[1];

				if (x < M && y < N && !visited[x][y] && lavirint[x][y] != '#') {
					visited[x][y] = true;
					queue.enqueue(new Point(x, y, point));
				}
			}
		}

		while (point != null) {
			stack.push(point);
			point = point.previous;
		}

		while (!stack.isEmpty()) {
			point = stack.pop();
			System.out.printf("%d,%d%n", point.i, point.j);
		}

		br.close();
	}
}
