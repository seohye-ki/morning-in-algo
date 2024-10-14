package BOJ_S4_1620_나는야_포켓몬_마스터_이다솜;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		HashMap<String, Integer> map = new HashMap<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[] nameArr = new String[N + 1];

		for (int i = 1; i <= N; i++) {
			String input = br.readLine();
			map.put(input, i);
			nameArr[i] = input;
		}

		for (int i = 1; i <= M; i++) {
			String input = br.readLine();
			if (map.containsKey(input)) {
				System.out.println(map.get(input));
			} else {
				System.out.println(nameArr[Integer.parseInt(input)]);
			}
		}
	}
}
