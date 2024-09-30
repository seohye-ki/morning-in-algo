package BOJ_S3_9095_1_2_3_더하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] dp = new int[n + 1];
			dp[0] = 1;

			for (int i = 1; i <= n; i++) {
				dp[i] += (i >= 1) ? dp[i - 1] : 0;
				dp[i] += (i >= 2) ? dp[i - 2] : 0;
				dp[i] += (i >= 3) ? dp[i - 3] : 0;
			}
			System.out.println(dp[n]);
		}
	}
}
