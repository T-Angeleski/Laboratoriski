package Kol2;


import java.util.Scanner;

class ElementK {
	private int id;

	public ElementK(int id) {
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

public class TransformationDLLKolok {
	private static void listTransform(DLL<ElementK> list, int n) {
		DLLNode<ElementK> last;
		DLLNode<ElementK> tmp;
		while (n > 0) {
			--n;
			last = list.getLast();
			tmp = list.getFirst();
			int sum = 0;
			int elementSum = last.element.getId();

			while (tmp != null) {
				if (sum <= elementSum) {
					sum += tmp.element.getId();
				}
				if (sum > elementSum) {
					list.insertBefore(last.element, tmp);
					list.deleteLast();
					break;
				}
				tmp = tmp.succ;
			}

		}

		System.out.println(list);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = Integer.parseInt(scanner.nextLine());
		int N = Integer.parseInt(scanner.nextLine());

		DLL<ElementK> list = new DLL<ElementK>();

		for (int i = 0; i < num; i++) {
			int n = scanner.nextInt();
			list.insertLast(new ElementK(n));
		}

		listTransform(list, N);
	}


}
