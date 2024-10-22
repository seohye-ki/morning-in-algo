
package BOJ_S3_11727_2xn_타일링_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % 10007;
		}

		System.out.println(dp[n]);
	}
}
