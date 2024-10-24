import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
    	for(int i = 0; i < N; i++) {
    		pq.add(Integer.parseInt(br.readLine()));
    	}
    	int answer = 0;
    	while (K !=0 && !pq.isEmpty()) {
    		int tmp = pq.poll();
    		answer += K/tmp;
    		K %= tmp;
    	}
    	System.out.println(answer);
    }
}
