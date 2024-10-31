package BOJ_G4_14502_연구소;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int[][] lab;
	static int[][] tmp;
	static int N, M;
	static int C = 3;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		lab = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0, 0);
		System.out.println(max);
	}

	public static void comb(int st, int cnt) {
		if (cnt == C) {
			calSafe();
			return;
		}

		for (int i = st; i < N * M; i++) {
			int r = i / M;
			int c = i % M;

			if (lab[r][c] == 0) {
				lab[r][c] = 1;
				comb(i + 1, cnt + 1);
				lab[r][c] = 0;
			}
		}
	}

	public static void calSafe() {
		Queue<int[]> q = new ArrayDeque<>();

		tmp = new int[N][M];
		int initialSafe = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[i][j] = lab[i][j];

				if (tmp[i][j] == 2) {
					q.offer(new int[] { i, j });
				} else if (tmp[i][j] == 0) {
					initialSafe++;
				}
			}
		}

		if (initialSafe <= max)
			return;
		int safeCnt = initialSafe;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0], c = curr[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr >= 0 && nc >= 0 && nr < N && nc < M && tmp[nr][nc] == 0) {
					tmp[nr][nc] = 2;
					q.offer(new int[] { nr, nc });
					safeCnt--;
					if (safeCnt <= max)
						return;
				}
			}
		}
		max = Math.max(max, safeCnt);
	}
}
