package BOJ_S1_1389_케빈_베이컨의_6단계_법칙;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static List<List<Integer>> adj;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adj = new ArrayList<>();
		for (int i = 0; i <= N; i++)
			adj.add(new ArrayList<>());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adj.get(a).add(b);
			adj.get(b).add(a);
		}
		int min = Integer.MAX_VALUE;
		int person = 0;

		for (int i = 1; i <= N; i++) {
			int sum = bfs(i);
			if (sum < min) {
				min = sum;
				person = i;
			}
		}

		System.out.println(person);
	}

	static int bfs(int st) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		int[] dist = new int[N + 1];

		q.offer(st);
		visited[st] = true;
		dist[st] = 0;

		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int next : adj.get(curr)) {
				if (!visited[next]) {
					visited[next] = true;
					dist[next] = dist[curr] + 1;
					q.offer(next);
				}
			}
		}

		int sum = 0;
		for (int i = 1; i <= N; i++)
			if (i != st)
				sum += dist[i];

		return sum;
	}
}
