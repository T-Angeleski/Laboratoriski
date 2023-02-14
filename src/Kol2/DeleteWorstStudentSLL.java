package Kol2;

import DadeniKodovi.Kodovi.SLL;
import DadeniKodovi.Kodovi.SLLNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Student {
	String name;
	String index;
	int points;

	public Student(String name, String index, int points) {
		this.index = index;
		this.name = name;
		this.points = points;
	}

	public int getPoints() {
		return points;
	}

	@Override
	public String toString() {
		return name;
	}
}

public class DeleteWorstStudentSLL {
	//Remove student with the least points
	private static void removeStudent(SLL<Student> students) {
		SLLNode<Student> tmp = students.getFirst();
		SLLNode<Student> toRemove = tmp;
		int min = tmp.element.getPoints();
		tmp = tmp.succ;

		while (tmp != null) {
			if (tmp.element.getPoints() < min) {
				min = tmp.element.getPoints();
				toRemove = tmp;
			}
			tmp = tmp.succ;
		}
		tmp = students.getFirst();
		if (tmp == toRemove) {
			students.first = tmp.succ;
		} else {
			while (tmp.succ != toRemove && tmp.succ.succ != null) {
				tmp = tmp.succ;
			}

			if (tmp.succ == toRemove) tmp.succ = tmp.succ.succ;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		SLL<Student> students = new SLL<>();

		br.lines()
				.limit(n)
				.forEach(line -> {
					String[] parts = line.split(" ");
					String name = parts[1];
					String index = parts[0];
					int points = Integer.parseInt(parts[2]);
					Student student = new Student(name, index, points);

					students.insertLast(student);
				});

		removeStudent(students);
		System.out.println(students);
	}

}
