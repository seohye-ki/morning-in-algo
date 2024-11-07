import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	static int[] nums;
	static int[] num;
	static int N, M;
	static boolean[] vi;
	static StringBuilder sb;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	nums = new int[N];
    	vi = new boolean[N];
    	num = new int[M];
    	sb = new StringBuilder();
    	st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
    		nums[i] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(nums);
    	find(0, 0);
    	System.out.print(sb);
    }
    
    public static void find(int i, int count) {
    	if (count == M) {
    		for (int t = 0; t < M; t++) {
    			sb.append(num[t]+" ");
    		}
    		sb.append("\n");
    		return;
    	}
    	if (i > N-1) {
    		return;
    	}
    	if (num[count] == nums[i]) {
    		find(i+1, count);
    		return;
    	}
    	if (vi[i]) {
    		find(i+1, count);
    		return;
    	}
    	num[count] = nums[i];
    	vi[i] =true;
    	find(0, count+1);
    	vi[i] =false;
    	find(i+1, count);
    	num[count] = 0;
    }
}