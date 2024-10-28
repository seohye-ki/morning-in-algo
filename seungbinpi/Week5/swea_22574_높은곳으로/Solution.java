import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc=1; tc<=T; tc++) {
			
			int N = sc.nextInt();
			int P = sc.nextInt();
			
			int result = 0;
			for (int i=1; i<=N; i++) {
				result += i;
				if (result == P)
					result -= 1;
			}
			System.out.println(result);
		}
	}
}
