import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{ 
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	Map<Integer, List<Integer>> map = new HashMap<>();
    	int[] nums = new int[N+1];
    	nums[1] = 1;
    	for (int i = 1; i <= N; i++) {
    		map.put(i, new ArrayList<>());
    	}
    	for (int i = 0; i < N-1; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int node1 = Integer.parseInt(st.nextToken());
    		int node2 = Integer.parseInt(st.nextToken());
    		map.get(node1).add(node2);
    		map.get(node2).add(node1);
    	}
    	Map<Integer, Integer> MAP = new HashMap<>();
    	Queue<Integer> que = new LinkedList<>();
    	que.add(1);
    	while(!que.isEmpty()) {
    		int num = que.poll();
    		for (int tmp : map.get(num)) {
    			if (nums[tmp] == 0) {
    				nums[tmp] = nums[num]+1;
    				MAP.put(tmp, num);
    				que.add(tmp);
    			}
    		}
    	}
    	StringBuilder sb = new StringBuilder();
    	for (int i = 2; i <= N; i++) {
    		sb.append(MAP.get(i)+"\n");
    	}
    	System.out.print(sb);
    }
}