import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N+1];
		for (int i = 2; i < N+1; i++) {
			nums[i] = nums[i-1]+1;
			if (i % 2 == 0) {
				nums[i] = Math.min(nums[i], nums[i/2]+1);
			}
			if (i % 3 == 0) {
				nums[i] = Math.min(nums[i], nums[i/3]+1);
			}
		}
		System.out.println(nums[N]);
	}
}