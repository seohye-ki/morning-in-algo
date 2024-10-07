
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, Boolean> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			map.put(br.readLine(), true);
		}
		PriorityQueue<String> pq = new PriorityQueue<>();
		for (int j = 0; j < M; j++) {
			String word = br.readLine();
			if (map.containsKey(word)) {
				pq.add(word);
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(pq.size()+"\n");
		while(!pq.isEmpty()) {
			sb.append(pq.poll()+"\n");	
		}
		System.out.println(sb);
	}
}