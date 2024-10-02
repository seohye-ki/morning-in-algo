package BOJ_S3_2579_계단_오르기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] stairs = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[n + 1];

		// i번째 칸에 도착하는 경우:
		// 1. 한칸전에서 오는 경우 - 한칸전 계단값이랑 (한칸전 + 두칸전 = 세칸전) 계단값 더함
		// 2. 두칸전에서 오는 경우 - 걍 두칸전계단값 더함

		// 두 가지 중 점수가 최대인 경우를 dp배열에 반영

		dp[1] = stairs[1];
		if (n >= 2) {
			dp[2] = stairs[1] + stairs[2];
		}

		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];
		}

		System.out.println(dp[n]);

	}
}
