package Kol2.Trees;

import DadeniKodovi.Kodovi.BNode;
import DadeniKodovi.Kodovi.BTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ValidityCheck {

	private static boolean validityCheckRecursive(BNode<Integer> node) {
		//1 -Kako da zastaneme?
		if (node == null) return true; // celo drvo izminato
		if (node.left == null && node.right == null) return true; //nema deca

		//Jazol so edno levo, edno desno ili 2 deca
		if (node.left == null) { // desno dete
			if (node.right.info.compareTo(node.info) <= 0)
				return validityCheckRecursive(node.right);
			else return false;
		}

		if (node.right == null) {
			if (node.left.info.compareTo(node.info) <= 0)
				return validityCheckRecursive(node.left);
			else return false;
		}

		//2 deca
		if (node.left.info.compareTo(node.info) <= 0 &&
				node.right.info.compareTo(node.info) <= 0)     //proveri decata
			return validityCheckRecursive(node.left) && validityCheckRecursive(node.right);

		return false;
	}

	public static boolean treeValidityCheck(BTree<Integer> tree) {
		return validityCheckRecursive(tree.root);
	}

	public static void main(String[] args) throws IOException {
		int i, j, k;
		int index;
		String action;

		String line;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		BNode<Integer> nodes[] = new BNode[N];
		BTree<Integer> tree = new BTree<Integer>();

		for (i = 0; i < N; i++)
			nodes[i] = new BNode<Integer>();

		for (i = 0; i < N; i++) {
			line = br.readLine();
			st = new StringTokenizer(line);
			index = Integer.parseInt(st.nextToken());
			nodes[index].info = Integer.parseInt(st.nextToken());
			action = st.nextToken();
			if (action.equals("LEFT")) {
				tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.LEFT, nodes[index]);
			} else if (action.equals("RIGHT")) {
				tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.RIGHT, nodes[index]);
			} else {
				// this node is the root
				tree.makeRootNode(nodes[index]);
			}
		}

		br.close();
		tree.inorderNonRecursive();
		// vasiot kod ovde
		System.out.println(treeValidityCheck(tree));
	}


}
