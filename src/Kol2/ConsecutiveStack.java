package Kol2;

import DadeniKodovi.Kodovi.ArrayStack;
import DadeniKodovi.Kodovi.Stack;
import DadeniKodovi.Kodovi.ArrayQueue;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ConsecutiveStack {


	private static boolean isConsecutive(Stack<Integer> stack) {
		ArrayQueue<Integer> queue = new ArrayQueue<>(100);
		queue.enqueue(stack.pop());

		while (!stack.isEmpty()) {
			if (stack.peek() + 1 != queue.peek()) return false;
			queue.dequeue();
			queue.enqueue(stack.pop());
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<Integer> stack = new ArrayStack<>(100);
		IntStream.range(0, n).mapToObj(i -> sc.nextInt()).forEach(stack::push);
		System.out.println(isConsecutive(stack));
	}
}
