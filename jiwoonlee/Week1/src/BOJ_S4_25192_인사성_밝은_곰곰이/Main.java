package BOJ_S4_25192_인사성_밝은_곰곰이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws Exception {
		Set<String> set = new HashSet<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String chat = br.readLine();
			if (chat.equals("ENTER")) {
				set.clear();
			} else if (set.add(chat)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
