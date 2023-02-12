package Kol2.Trees;

import DadeniKodovi.Kodovi.BNode;
import DadeniKodovi.Kodovi.BTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestIncreasingSum {

	public static int maxRoute(BNode<Integer> node, int prevVal, int prevLen) {
		if (node == null) return prevLen;
		int curr = node.info;
		if (curr == prevVal + 1) {
			int left = maxRoute(node.left, curr, prevLen + 1);
			int right = maxRoute(node.right, curr, prevLen + 1);

			return Math.max(left, right);
		}
		//Reset length
		int left = maxRoute(node.left, curr, 1);
		int right = maxRoute(node.right, curr, 1);

		return Math.max(left, right);
	}

	public static int maxRouteCall(BNode<Integer> root) {
		if (root == null) return 0;

		return maxRoute(root, root.info - 1, 0);
	}

	public static void main(String[] args) throws IOException {
		int i, j, k;
		int index;
		String action;

		String line;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		@SuppressWarnings("unchecked")
		BNode<Integer>[] nodes = new BNode[N];
		BTree<Integer> tree = new BTree<>();

		for (i = 0; i < N; i++)
			nodes[i] = new BNode<Integer>();

		for (i = 0; i < N; i++) {
			line = br.readLine();
			st = new StringTokenizer(line);
			index = Integer.parseInt(st.nextToken());
			nodes[index].info = Integer.valueOf(st.nextToken());
			action = st.nextToken();
			if (action.equals("LEFT")) {
				tree.addChild(nodes[Integer.parseInt(st.nextToken())], BNode.LEFT, nodes[index].info);
			} else if (action.equals("RIGHT")) {
				tree.addChild(nodes[Integer.parseInt(st.nextToken())], BNode.RIGHT, nodes[index].info);
			} else {
				// this node is the root
				tree.makeRoot(nodes[index].info);
			}
		}

		br.close();

		System.out.println(maxRouteCall(tree.root));
	}
}
