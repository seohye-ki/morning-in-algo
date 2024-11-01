package BOJ_S5_9655_돌_게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static String[] nms = { "", "SK", "CY" };
	static int[] dp = new int[1001];
	static {
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= 1000; i++) {
			dp[i] = dp[i - 2];
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		System.out.println(nms[dp[N]]);
	}
}
