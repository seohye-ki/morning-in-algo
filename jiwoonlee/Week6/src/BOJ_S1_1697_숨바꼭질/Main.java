package BOJ_S1_1697_숨바꼭질;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int a, b;
    static boolean[] visited;
    static int[] dist;
    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];
        dist = new int[100001];

        bfs();
    }

    static void bfs() {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(a);
        visited[a] = true;
        dist[a] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (curr == b) {
                System.out.println(dist[curr]);
                return;
            }

            if (curr - 1 >= 0 && !visited[curr - 1]) {
                q.offer(curr - 1);
                visited[curr - 1] = true;
                dist[curr - 1] = dist[curr] + 1;
            }
            if (curr + 1 <= b && !visited[curr + 1]) {
                q.offer(curr + 1);
                visited[curr + 1] = true;
                dist[curr + 1] = dist[curr] + 1;
            }
            if (curr * 2 <= 100000 && !visited[curr * 2]) {
                q.offer(curr * 2);
                visited[curr * 2] = true;
                dist[curr * 2] = dist[curr] + 1;
            }
        }
    }
}
