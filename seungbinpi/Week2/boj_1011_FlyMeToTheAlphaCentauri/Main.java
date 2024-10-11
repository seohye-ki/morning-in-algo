import java.util.Scanner;

public class Main {
	
	static long distance;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc=1; tc<=T; tc++) {
			
			long start = sc.nextInt();
			long end = sc.nextInt();
			distance = end - start;
			
			long result = method(0, 0, 0, true);
			
			System.out.println(result);
		}

	}
	static long method(long num, long cnt, int prev, boolean flag) {
		
		if (num >= distance) {
			return cnt;
		}
		
		if (flag) {
			return method(num+(prev+1), cnt+1, prev+1, false);
		} else {
			return method(num+prev, cnt+1, prev, true);
		}
	}

}
