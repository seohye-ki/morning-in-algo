import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	for (int test = 0; test < T; test++) {
    		int N = Integer.parseInt(br.readLine());
    		Map<String, Integer> map = new HashMap<>();
    		for (int i = 0; i < N; i++) {
    			StringTokenizer st = new StringTokenizer(br.readLine());
    			st.nextToken();
    			String tmp = st.nextToken();
    			if (map.containsKey(tmp)) {
    				map.put(tmp, map.get(tmp)+1);
    			}
    			else {
    				map.put(tmp, 2);
    			}
    		}
    		int answer = 1;
    		for (String wear : map.keySet()) {
    			answer *= map.get(wear);
    		}
    		answer -= 1;
    		sb.append(answer+"\n");
    	}
    	System.out.println(sb);
    }
}