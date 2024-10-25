package BOJ_G3_2252_줄_세우기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<List<Integer>> al = new ArrayList<>();
	static int N, M;
	static int[] cnt;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		cnt = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			al.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			al.get(a).add(b); // 간선 추가
			cnt[b]++; // b로 들어오는 진입 차수 증가
		}
		tpSort();
		System.out.println(sb);

	}

	static void tpSort() {
		Queue<Integer> q = new ArrayDeque<>();
		// 모든 노드에 대해
		for (int i = 1; i <= N; i++) {
			// 진입 차수가 0인 노드를 큐에 넣음
			if (cnt[i] == 0) {
				q.offer(i);
			}
		}

		// 모든 노드에 대해
		for (int i = 0; i < N; i++) {
			if (!q.isEmpty()) {
				// 큐에서 꺼낸 노드는 진입 차수가 0
				int curr = q.poll();
				sb.append(curr).append(" ");

				// 현재 노드의 하위 노드에 대해
				for (int j = 0; j < al.get(curr).size(); j++) {
					// 하위 노드의 진입차수를 감소시킴
					cnt[al.get(curr).get(j)]--;
					if (cnt[al.get(curr).get(j)] == 0) {
						// 진입 차수가 0인 노드를 큐에 넣음
						q.offer(al.get(curr).get(j));
					}
				}
			}
		}

	}
}
