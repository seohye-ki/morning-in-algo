import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean[] v = new boolean[N+1];
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			map.put(i+1, new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			map.get(start).add(end);
			map.get(end).add(start);
		}
		Queue<Integer> qu = new LinkedList<>();
		qu.add(1);
		while(!qu.isEmpty()) {
			int tmp = qu.poll();
			if (v[tmp]) {
				continue;
			}
			v[tmp] = true;
			if (!map.get(tmp).isEmpty()) {
				for (int num : map.get(tmp)) {
					if (v[num]) {
						continue;
					}
					qu.add(num);
				}
			}
		}
		int answer = -1;
		for (int i = 1; i< N+1; i++) {
			if(v[i]) answer+=1;
		}
		
		System.out.println(answer);
	}
}