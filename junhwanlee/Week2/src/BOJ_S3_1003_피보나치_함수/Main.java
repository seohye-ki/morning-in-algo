import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] nums = new int[41][2];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		nums[0][0] = 1;
		nums[0][1] = 0;
		nums[1][0] = 0;
		nums[1][1] = 1;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int test = 1; test <= T; test++) {
			int num = Integer.parseInt(br.readLine());
			if (nums[num][0] == 0 && nums[num][1] == 0) {
				for (int i = 2; i <= num; i++) {
					if (nums[i][0] != 0) {
						continue;
					}
					nums[i][0] = nums[i-1][0]+nums[i-2][0];
					nums[i][1] = nums[i-1][1]+nums[i-2][1];
				}
			}
			sb.append(nums[num][0]+" "+nums[num][1]+"\n");
		}
		System.out.print(sb);
	}
}
