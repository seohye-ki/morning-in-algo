import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	Map<String, Integer> map = new HashMap<>();
    	String[] pok = new String[N+1];
    	for (int i = 1; i <= N; i++) {
    		String poket = br.readLine();
    		pok[i] = poket;
    		map.put(poket, i);
    	}
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < M; i++) {
    		String tmp = br.readLine();
    		if (map.containsKey(tmp)) {
    			sb.append(map.get(tmp)+"\n");
    			continue;
    		}
    		sb.append(pok[Integer.parseInt(tmp)]+"\n");
    	}
    	System.out.println(sb);
    }
}
