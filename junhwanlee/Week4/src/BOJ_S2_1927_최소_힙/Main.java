import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main  {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		
		for (int test = 0; test < T; test++ ) {
			int d = Integer.parseInt(br.readLine());
			if (d == 0) {
				if (pq.isEmpty()) {
					sb.append(0+"\n");
				}
				else {
					sb.append(pq.poll()+"\n");
				}
				continue;
			}
			pq.add(d);
		}
		System.out.println(sb);
	}
}