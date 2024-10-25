package BOJ_S1_2178_미로_탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char[][] mat;
	static int N, M;
	static boolean[][] visited;
	static int[][] d = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		mat = new char[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			mat[i] = br.readLine().toCharArray();
		}
		System.out.println(bfs(0, 0));
	}

	static int bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { r, c, 1 });
		visited[r][c] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			if (curr[0] == N - 1 && curr[1] == M - 1)
				return curr[2];

			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + d[i][0];
				int nc = curr[1] + d[i][1];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if (!visited[nr][nc] && mat[nr][nc] != '0') {
						visited[nr][nc] = true;
						q.offer(new int[] { nr, nc, curr[2] + 1 });
					}
				}
			}
		}
		return -1;
	}
}
