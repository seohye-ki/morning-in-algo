import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	sb = new StringBuilder();
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int[] nums = new int[M];
    	find(N, 1, 0, nums); 
    	System.out.println(sb);
    }
	private static void find(int n, int i, int count, int[] nums) {
		if (count == nums.length) {
			for (int t = 0; t < nums.length; t++) {
				sb.append(nums[t]+" ");
			}
			sb.append("\n");
			return;
		}
		if (i > n) {
			return;
		}
		nums[count] = i;
		find(n, i, count+1, nums);
		find(n, i+1, count, nums);
	}
}