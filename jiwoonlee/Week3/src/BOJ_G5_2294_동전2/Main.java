package BOJ_G5_2294_동전2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] coins = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[k + 1];

		for (int i = 1; i <= k; i++) {
			dp[i] = 100000;
		}

		for (int i = 0; i < n; i++) {
			for (int j = coins[i]; j <= k; j++) {
				dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
			}
			System.out.println(Arrays.toString(dp));
		}
		if (dp[k] != 100000) {
			System.out.println(dp[k]);
		} else {
			System.out.println(-1);
		}
	}
}
