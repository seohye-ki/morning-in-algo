import java.util.*;

public class Solution {
	
	static String S, E;
	static int N;
	static String result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc=1; tc<=T; tc++) {
			S = sc.next();
			E = sc.next();
			N = E.length() - S.length();
			
			result = "No";
			method(0, E);
			
			System.out.println("#" + tc + " " + result);
		}
	}
	static void method(int depth, String string) {
		if (depth == N) {
			if (string.equals(S))
				result = "Yes";
			return;
		}
		
		if (string.charAt(string.length()-1) == 'X') {
			method(depth+1, string.substring(0, string.length()-1));
		}
		else {
			StringBuilder sb = new StringBuilder();
			method(depth+1, sb.append(string.substring(0, string.length()-1)).reverse().toString());
		}
	}
}
