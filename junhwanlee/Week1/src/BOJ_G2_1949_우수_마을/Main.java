
import java.io.*;
import java.util.*;

public class Main {
	static boolean[] can;
	static int N;
	static int[] pe;
	static int[][] dp;
	static Map<Integer, List<Integer>> map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		pe = new int[N+1];
		map = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			pe[i] = Integer.parseInt(st.nextToken());
			map.put(i, new ArrayList<>());
		}
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			map.get(start).add(end);
			map.get(end).add(start);
		}
		dp = new int[N+1][2];
		can = new boolean[N+1];
		find(1);
		System.out.println(Math.max(dp[1][0], dp[1][1]));
	}
	
	public static void find(int idx) {
		can[idx] = true;
		dp[idx][1] += pe[idx];
		for (int tmp : map.get(idx)) {
			if (!can[tmp]) {
				find(tmp);
				dp[idx][0] += Math.max(dp[tmp][1], dp[tmp][0]);
				dp[idx][1] += dp[tmp][0];
			}	 
		}
	}
}