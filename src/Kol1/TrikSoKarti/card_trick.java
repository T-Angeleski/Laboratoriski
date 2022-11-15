package Kol1.TrikSoKarti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.NoSuchElementException;


interface Queue<E> {
    boolean isEmpty();

    int size();

    E peek();

    void clear();

    void enqueue(E x);

    E dequeue();
}


class ArrayQueue<E> implements Queue<E> {
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

interface Stack<E> {
    boolean isEmpty();

    E peek();

    void clear();

    void push(E x);

    E pop();
}

class ArrayStack<E> implements Stack<E> {
    private E[] elems;
    private int depth;

    @SuppressWarnings("unchecked")
    public ArrayStack(int maxDepth) {
        // Konstrukcija na nov, prazen stek.
        elems = (E[]) new Object[maxDepth];
        depth = 0;
    }

    public boolean isEmpty() {
        // Vrakja true ako i samo ako stekot e prazen.
        return (depth == 0);
    }

    public E peek() {
        // Go vrakja elementot na vrvot od stekot.
        if (depth == 0)
            throw new NoSuchElementException();
        return elems[depth - 1];
    }

    public void clear() {
        // Go prazni stekot.
        for (int i = 0; i < depth; i++) elems[i] = null;
        depth = 0;
    }

    public void push(E x) {
        // Go dodava x na vrvot na stekot.
        elems[depth++] = x;
    }

    public E pop() {
        // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
        if (depth == 0)
            throw new NoSuchElementException();
        E topmost = elems[--depth];
        elems[depth] = null;
        return topmost;
    }
}


public class card_trick {
    public static int count(int N) {
        // Vasiot kod tuka
        ArrayQueue<Integer> cardQueue = new ArrayQueue<>(51);
        ArrayStack<Integer> cardStack = new ArrayStack<>(51);

        for (int i = 1; i < 52; i++)
            cardQueue.enqueue(i);

        int count = 0;

        while (cardQueue.peek() != N) {
            for (int i = 0; i < 7; i++)
                cardStack.push(cardQueue.dequeue());

            for (int i = 0; i < 7; i++) {
                cardQueue.enqueue(cardStack.pop());
                cardQueue.enqueue(cardQueue.dequeue());
            }

            count++;
        }

        return count;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(count(Integer.parseInt(br.readLine())));
    }

}
