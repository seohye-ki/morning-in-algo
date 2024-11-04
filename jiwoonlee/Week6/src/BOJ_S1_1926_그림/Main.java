package BOJ_S1_1926_그림;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static boolean[][] mat;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		mat = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				mat[i][j] = st.nextToken().charAt(0) - '0' > 0;
			}
		}

		int cnt = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (mat[i][j]) {
					max = Math.max(max, dfs(i, j));
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(max);
	}

	static final int[][] D = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	static int dfs(int r, int c) {
		mat[r][c] = false;
		int area = 1;
		for (int i = 0; i < 4; i++) {
			int nr = r + D[i][0];
			int nc = c + D[i][1];

			if (nr >= 0 && nc >= 0 && nr < n && nc < m && mat[nr][nc]) {
				area += dfs(nr, nc);
			}
		}
		return area;
	}
}
