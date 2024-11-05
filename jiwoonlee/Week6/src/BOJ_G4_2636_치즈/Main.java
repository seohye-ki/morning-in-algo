package BOJ_G4_2636_치즈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int[][] D = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0},
    };
    static int n, m;
    static int[][] mat;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        mat = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {

                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int time = 0;
        int lastCount = 0;

        while (true) {
            visit = new boolean[n][m];
            int count = bfs();
            if (count == 0) break;

            lastCount = count;
            time++;
        }
        System.out.println(time);
        System.out.println(lastCount);
    }

    static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        visit[0][0] = true;
        int count = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + D[i][0];
                int nc = c + D[i][1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visit[nr][nc]) {
                    visit[nr][nc] = true;
                    if (mat[nr][nc] == 1) {
                        mat[nr][nc] = 0;
                        count++;
                    } else if (mat[nr][nc] == 0) {
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        return count;
    }
}
