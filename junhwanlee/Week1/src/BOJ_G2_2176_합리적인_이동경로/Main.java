import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] pro = new int[N+1];
		Map<Integer, List<int[]>> map = new HashMap<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if (!map.containsKey(start)) {
				map.put(start, new ArrayList<>());
			}
			if (!map.containsKey(end)) {
				map.put(end, new ArrayList<>());
			}
			map.get(start).add(new int[] {end, num});
			map.get(end).add(new int[] {start, num});
		}
		PriorityQueue<long[]> queue = new PriorityQueue<>((a, b) -> Long.compare(a[1] , b[1]));
		long[] djk1 = new long[N+1];
		Arrays.fill(djk1, Long.MAX_VALUE);
		djk1[2] = 0;
		queue.add(new long[] {2, 0});
		while(!queue.isEmpty()) {
			long[] tmp = queue.poll();
			int n = (int) tmp[0];
			long v = tmp[1];
			if ( v > djk1[n]) {
				continue;
			}
            if (map.get(n) != null) {
    			for (int[] nums : map.get(n)) {
    				int next = nums[0];
    				long wei = v+nums[1];
    				
    				if (wei < djk1[next]) {
    					djk1[next] = wei;
    					queue.add(new long[] {next, wei});
    				}
    			}
            }
		}
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Long.compare(djk1[a] , djk1[b]));
		int[] dp = new int[N+1];
		dp[2] = 1;
        for (int tmp = 1; tmp <= N; tmp++) {
            pq.add(tmp);
        }
    	while(!pq.isEmpty()) {
            int tmp = pq.poll();
            if (map.get(tmp) != null) {
    			for (int[] nums : map.get(tmp)) {
    				if (djk1[nums[0]] < djk1[tmp]) {
    					dp[tmp] += dp[nums[0]];
    				}
    			}
            }
            if (tmp == 1) break;
		}
		System.out.println(dp[1]);
	}
}