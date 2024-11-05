import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int[] nums = new int[N];
    	st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
    		nums[i] = Integer.parseInt(st.nextToken());
    	}
    	int[] dp = new int[N];
    	int answer=0;
    	dp[N-1] = 1;
    	for (int i = N-1; i >= 0; i--) {
    		dp[i] = 1;
    		for (int j = i+1; j<N; j++) {
    			if (nums[i] < nums[j]) {
    				dp[i] = Math.max(dp[i], dp[j]+1);
    			}
    		}
    	}
    	for (int i = 0; i< N; i++) {
    		answer = Math.max(answer, dp[i]);
    	}
    	System.out.println(answer);
    }
}