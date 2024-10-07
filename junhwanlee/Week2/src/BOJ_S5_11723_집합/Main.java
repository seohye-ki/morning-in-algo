import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] nums = new boolean[20];
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String word = st.nextToken();
			switch (word) {
				case "add": {
					int num = Integer.parseInt(st.nextToken())-1;
					nums[num] = true;
					break;
				}
				case "remove": {
					int num = Integer.parseInt(st.nextToken())-1;
					nums[num] = false;
					break;
				}
				case "check": {
					int num = Integer.parseInt(st.nextToken())-1;
					if (nums[num]) {
						sb.append("1\n");
					} 
					else {
						sb.append("0\n");
					}
					break;
				}
				case "toggle": {
					int num = Integer.parseInt(st.nextToken())-1;
					if (nums[num]) {
						nums[num] = false;
					} 
					else {
						nums[num] = true;
					}
					break;
				}
				case "all": {
					Arrays.fill(nums, true);
					break;
				}
				case "empty": {
					nums = new boolean[20];
					break;
				}
			}
		}
		System.out.println(sb);
	}
}