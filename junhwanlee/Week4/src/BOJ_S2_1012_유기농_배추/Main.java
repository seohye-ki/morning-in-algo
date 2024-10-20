import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] MAP;
	static int[][] map;
	static int[] dC = {0, 0, 1, -1};
	static int[] dR = {1, -1, 0, 0};
	static int N, M, answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test = 0; test < T; test++ ) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			map = new int[M][N];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			MAP = new boolean[M][N];
			answer = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (MAP[i][j]) continue;
					if (map[i][j] == 1) {
						find(i, j);
						answer += 1;
					}
				}
			}
			System.out.println(answer);
		}
	}
	private static void find(int i, int j) {
		MAP[i][j] = true;
		for (int t = 0; t < 4; t++) {
			int c = i+dC[t];
			int r = j+dR[t];
			if (c < 0 || r < 0 || c >= M || r >= N) continue;
			if (MAP[c][r] || map[c][r] == 0) continue;
			find(c, r);
		}
	}
}