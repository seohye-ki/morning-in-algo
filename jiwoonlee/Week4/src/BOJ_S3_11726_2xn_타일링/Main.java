package BOJ_S3_11726_2xn_타일링;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] dp = new int[1001];
	static {
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= 1000; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		System.out.println(dp[n]);
	}
}
