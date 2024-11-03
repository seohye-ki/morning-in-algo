import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static int[] nums;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	sb = new StringBuilder();
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	nums = new int[N];
    	st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
    		nums[i] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(nums);
    	int[] find = new int[M];
    	boolean[] can = new boolean[N];
    	find(N, 0, 0, find, can);
    	System.out.println(sb);
    }
	private static void find(int n, int i, int count, int[] find, boolean[] can) {
		if (count == find.length) {
			for (int t = 0; t < find.length; t++) {
				sb.append(find[t]+" ");
			}
			sb.append("\n");
			return;
		}
		if (i >= n) {
			return;
		}
		if (!can[i]) {
			find[count] = nums[i];
			can[i] = true;
			find(n, 0, count+1, find, can);
			can[i] = false;
			find(n, i+1, count, find, can);
		}
		else {
			find(n, i+1, count, find, can);
		}
	}
}