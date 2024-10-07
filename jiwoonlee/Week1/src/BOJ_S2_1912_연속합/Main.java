package BOJ_S2_1912_연속합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int max = arr[0], sum = arr[0];

		for (int i = 1; i < N; i++) {
			sum = Math.max(sum + arr[i], arr[i]);
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
}