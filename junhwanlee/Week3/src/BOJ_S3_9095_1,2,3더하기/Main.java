import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int nums[] = new int[12];
		nums[1] = 1;
		nums[2] = 2;
		nums[3] = 4;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (nums[num] != 0) {
				sb.append(nums[num]+"\n");
				continue;
			}
			for (int j = 4; j <= num; j++) {
				if (nums[j] == 0)
					nums[j] = nums[j-1] + nums[j-2] + nums[j-3];
			}
			sb.append(nums[num]+"\n");
		}
		System.out.print(sb);
	}
}