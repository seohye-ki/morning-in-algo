import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] nums = new int[1001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		nums[1] = 1;
		nums[2] = 2;
		if (nums[N] == 0) {
			for (int i = 3; i <=N; i++) {
				if(nums[i] != 0) {
					continue;
					}
				nums[i] = (nums[i-1]+nums[i-2])%10007;
			}
		}
		System.out.print(nums[N]);
	}
}