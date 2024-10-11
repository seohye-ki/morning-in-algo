package BOJ_S3_2346_풍선_터뜨리기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		Deque<int[]> dq = new ArrayDeque<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			dq.offer(new int[] { i, Integer.parseInt(st.nextToken()) });
		}

		StringBuilder sb = new StringBuilder();

		while (!dq.isEmpty()) {
			int[] curr = dq.poll();
			sb.append(curr[0]).append(" ");

			if (dq.isEmpty())
				break;

			if (curr[1] > 0) {
				for (int i = 0; i < curr[1] - 1; i++) {
					dq.offerLast(dq.pollFirst());
				}
			} else {
				for (int i = 0; i < -curr[1]; i++) {
					dq.offerFirst(dq.pollLast());
				}
			}
		}

		bw.write(sb.toString());
		bw.flush();
	}
}
