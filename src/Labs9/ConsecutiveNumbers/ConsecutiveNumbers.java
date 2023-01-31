package Labs9.ConsecutiveNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BNode<E> {
	public E info;
	public BNode<E> left;
	public BNode<E> right;
	char ltag;
	char rtag;
	static int LEFT = 1;
	static int RIGHT = 2;

	public BNode(E info) {
		this.info = info;
		left = null;
		right = null;
		ltag = '-';
		rtag = '-';
	}
}

class BTree<E> {
	public BNode<E> head;

	public BTree() {
		head = new BNode<E>(null);
		// po definicija ako nema koren, t.e. ako stebloto e prazno
		head.left = head;
		head.ltag = '-';
		// kaj vodacot sekogas desnata vrska pokazuva kon samiot sebe
		head.right = head;
		head.rtag = '+';
	}

	public BNode<E> makeRoot(E elem) {
		BNode<E> tmp = new BNode<E>(elem);
		head.left = tmp;
		head.ltag = '+';

		tmp.left = head;
		tmp.ltag = '-';
		tmp.right = head;
		tmp.rtag = '-';

		return tmp;
	}

	public BNode<E> makeRootNode(BNode<E> tmp) {
		head.left = tmp;
		head.ltag = '+';

		tmp.left = head;
		tmp.ltag = '-';
		tmp.right = head;
		tmp.rtag = '-';

		return tmp;
	}

	public BNode<E> addChild(BNode<E> node, int where, E elem) {
		BNode<E> tmp = new BNode<E>(elem);

		if (where == BNode.LEFT) {

			if (node.ltag == '+') // veke postoi element
			{
				return null;
			}

			tmp.left = node.left;
			tmp.ltag = '-';
			tmp.right = node;
			tmp.rtag = '-';
			node.left = tmp;
			node.ltag = '+';
		} else {

			if (node.rtag == '+') // veke postoi element
			{
				return null;
			}

			tmp.right = node.right;
			tmp.rtag = '-';
			tmp.left = node;
			tmp.ltag = '-';
			node.right = tmp;
			node.rtag = '+';
		}

		return tmp;
	}

	public BNode<E> addChildNode(BNode<E> node, int where, BNode<E> tmp) {

		if (where == BNode.LEFT) {

			if (node.ltag == '+') // veke postoi element
			{
				return null;
			}

			tmp.left = node.left;
			tmp.ltag = '-';
			tmp.right = node;
			tmp.rtag = '-';
			node.left = tmp;
			node.ltag = '+';
		} else {

			if (node.rtag == '+') // veke postoi element
			{
				return null;
			}

			tmp.right = node.right;
			tmp.rtag = '-';
			tmp.left = node;
			tmp.ltag = '-';
			node.right = tmp;
			node.rtag = '+';
		}

		return tmp;
	}

	public BNode<E> insertRight(BNode<E> parent, E info) {

		BNode<E> child = new BNode<E>(info);

		child.ltag = '-';
		child.left = parent;
		child.rtag = parent.rtag;
		child.right = parent.right;

		parent.right = child;
		parent.rtag = '+';

		if (child.rtag == '+') {
			BNode<E> temp = child.right;
			while (temp.ltag == '+') {
				temp = temp.left;
			}
			temp.left = child;
		}

		return child;
	}

	public BNode<E> predecessorInorder(BNode<E> node) {

		if (node.ltag == '-') {
			return node.left;
		}

		BNode<E> p = node.left;
		while (p.rtag == '+') {
			p = p.right;
		}

		return p;
	}

	public BNode<E> successorInorder(BNode<E> node) {

		if (node.rtag == '-') {
			return node.right;
		}

		BNode<E> p = node.right;
		while (p.ltag == '+') {
			p = p.left;
		}

		return p;
	}
}

public class ConsecutiveNumbers {
	public static void main(String[] args) throws IOException {
		try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
			BTree<Integer> bTree = new BTree<>();
			int n = Integer.parseInt(input.readLine());
			@SuppressWarnings("unchecked")
			BNode<Integer>[] nodes = (BNode<Integer>[]) new BNode[n];

			for (int i = 0; i < n; ++i) {
				String[] lineParts = input.readLine().split("\\s+");
				int index = Integer.parseInt(lineParts[0]);
				int data = Integer.parseInt(lineParts[1]);
				String where = lineParts[2];
				if (where.equals("ROOT")) {
					nodes[index] = bTree.makeRoot(data);
				} else {
					int nodePosition = Integer.parseInt(lineParts[3]);
					int whereInt = 1;
					if (where.equals("RIGHT"))
						whereInt = 2;
					nodes[index] = bTree.addChild(nodes[nodePosition], whereInt, data);
				}
			}

			System.out.println(consecutiveNumbers(bTree));
		}
	}

	public static boolean consecutiveNumbers(BTree<Integer> tree) {
		if (tree.head.ltag == '-') {
			return true;
		}

		BNode<Integer> node = tree.head.left;

		while (node.ltag == '+') {
			node = node.left;
		}

		while (node != tree.head) {
			if (tree.successorInorder(node).info != null && tree.successorInorder(node).info - node.info != 1) {
				return false;
			}

			node = tree.successorInorder(node);
		}

		return true;
	}
}

