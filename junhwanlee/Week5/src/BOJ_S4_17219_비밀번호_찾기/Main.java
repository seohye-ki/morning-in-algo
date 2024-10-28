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
    	Map <String, String> map = new HashMap<>();
    	for (int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		map.put(st.nextToken(), st.nextToken());
    	}
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < K; i++) {
    		sb.append(map.get(br.readLine())+"\n");
    	}
    	System.out.println(sb);
    }
}