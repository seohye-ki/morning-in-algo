import java.util.*;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc=1; tc<=T; tc++) {
			String string = sc.next();
			int N = string.length();
			String front = string.substring(0, N/2);
			String back;
			if (N%2 == 0) {
				back = string.substring(N/2);
			}
			else {
				back = string.substring(N/2 + 1);
			}
			
			String result = "NO";
			if (method(front)) {
				StringBuilder sb = new StringBuilder();
				sb.append(front);
				sb.reverse();
				if (back.equals(sb.toString()))
					result = "YES";
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}
	static boolean method(String string) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(string);
		sb.reverse();
		if (string.equals(sb.toString()))
			return true;		
		
		return false;
	}
}
