package Kol2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MapEntry<K extends Comparable<K>, E> implements Comparable<K> {

	// Each MapEntry object is a pair consisting of a key (a Comparable
	// object) and a value (an arbitrary object).
	K key;
	E value;

	public MapEntry(K key, E val) {
		this.key = key;
		this.value = val;
	}

	public int compareTo(K that) {
		// Compare this map entry to that map entry.
		@SuppressWarnings("unchecked")
		MapEntry<K, E> other = (MapEntry<K, E>) that;
		return this.key.compareTo(other.key);
	}

	public String toString() {
		return "<" + key + "," + value + ">";
	}
}

class SLLNode<E> {
	protected E element;
	protected SLLNodeK<E> succ;

	public SLLNode(E elem, SLLNodeK<E> succ) {
		this.element = elem;
		this.succ = succ;
	}

	@Override
	public String toString() {
		return element.toString();
	}
}

class CBHT<K extends Comparable<K>, E> {

	// An object of class CBHT is a closed-bucket hash table, containing
	// entries of class MapEntry.
	private SLLNodeK<MapEntry<K, E>>[] buckets;

	@SuppressWarnings("unchecked")
	public CBHT(int m) {
		// Construct an empty CBHT with m buckets.
		buckets = (SLLNodeK<MapEntry<K, E>>[]) new SLLNodeK[m];
	}


	private int hash(K key) {
		// Napishete ja vie HASH FUNKCIJATA
		return Math.abs(key.hashCode()) % buckets.length;
	}

	public SLLNodeK<MapEntry<K, E>> search(K targetKey) {
		// Find which if any node of this CBHT contains an entry whose key is
		// equal
		// to targetKey. Return a link to that node (or null if there is none).
		int b = hash(targetKey);
		for (SLLNodeK<MapEntry<K, E>> curr = buckets[b]; curr != null; curr = curr.succ) {
			if (targetKey.equals(((MapEntry<K, E>) curr.element).key))
				return curr;
		}
		return null;
	}

	public void insert(K key, E val) {        // Insert the entry <key, val> into this CBHT.
		MapEntry<K, E> newEntry = new MapEntry<K, E>(key, val);
		int b = hash(key);
		for (SLLNodeK<MapEntry<K, E>> curr = buckets[b]; curr != null; curr = curr.succ) {
			if (key.equals(((MapEntry<K, E>) curr.element).key)) {
				// Make newEntry replace the existing entry ...
				curr.element = newEntry;
				return;
			}
		}
		// Insert newEntry at the front of the 1WLL in bucket b ...
		buckets[b] = new SLLNodeK<MapEntry<K, E>>(newEntry, buckets[b]);
	}

	public void delete(K key) {
		// Delete the entry (if any) whose key is equal to key from this CBHT.
		int b = hash(key);
		for (SLLNodeK<MapEntry<K, E>> pred = null, curr = buckets[b]; curr != null; pred = curr, curr = curr.succ) {
			if (key.equals(((MapEntry<K, E>) curr.element).key)) {
				if (pred == null)
					buckets[b] = curr.succ;
				else
					pred.succ = curr.succ;
				return;
			}
		}
	}

	public String toString() {
		String temp = "";
		for (int i = 0; i < buckets.length; i++) {
			temp += i + ":";
			for (SLLNodeK<MapEntry<K, E>> curr = buckets[i]; curr != null; curr = curr.succ) {
				temp += curr.element.toString() + " ";
			}
			temp += "\n";
		}
		return temp;
	}

}

public class KumanovskiDijalekt {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in));
		int N = Integer.parseInt(br.readLine());

		CBHT<String, String> dialectToStandard = new CBHT<>(N);

		//nego otkolku
		String pairs[] = new String[N];
		for (int i = 0; i < N; i++) {
			pairs[i] = br.readLine();

			String[] parts = pairs[i].split("\\s+");
			dialectToStandard.insert(parts[0], parts[1]);
		}

		String text = br.readLine();

		//Vasiot kod tuka

		if (N == 0) {
			System.out.println(text);
			return;
		}

		//With . , ?
		String[] words = text.split("\\s+");
		char character = '#';
		String query, value;
		StringBuilder result = new StringBuilder();

		for (String word : words) {
			character = '#'; //Nema character

			if (word.charAt(word.length() - 1) == '.' ||
					word.charAt(word.length() - 1) == ',' ||
					word.charAt(word.length() - 1) == '!' ||
					word.charAt(word.length() - 1) == '?') {
				character = word.charAt(word.length() - 1);

				//Remove from end of word
				word = word.substring(0, word.length() - 1);

			}

			query = word.toLowerCase();

			if (dialectToStandard.search(query) != null) {
				value = dialectToStandard.search(query).element.value;

				//If original word starts with uppercase
				if (Character.isUpperCase(word.charAt(0))) {
					result.append(Character.toUpperCase(value.charAt(0)));
					result.append(value.substring(1));
				} else {
					//Doesn't start with uppercase
					result.append(value);
				}
			} else {
				//Word not in map
				result.append(word);
			}


			if (character != '#') result.append(character);

			result.append(" ");
		}

		System.out.println(result);
	}
}
