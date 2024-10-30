package BOJ_G3_14725_개미굴;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static StringBuilder sb;

	static class Node {
		TreeMap<String, Node> child = new TreeMap<>();

		Node() {
		}
	}

	static class Trie {

		Node root = new Node();

		void insert(String[] strs) {
			Node node = root;
			for (String s : strs) {
				if (!node.child.containsKey(s)) {
					node.child.put(s, new Node());
				}
				node = node.child.get(s);
			}
		}

		void appendStr(Node curr, int depth) {
			for (String s : curr.child.keySet()) {
				for (int i = 0; i < depth; i++) {
					sb.append("--");
				}
				sb.append(s).append("\n");
				appendStr(curr.child.get(s), depth + 1);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Trie trie = new Trie();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			String[] strs = new String[k];

			for (int j = 0; j < k; j++) {
				strs[j] = st.nextToken();
			}
			trie.insert(strs);
		}

		Node root = trie.root;

		sb = new StringBuilder();
		trie.appendStr(root, 0);
		System.out.println(sb);
	}
}
