package BOJ_S4_1269_대칭_차집합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();

		BitSet a = new BitSet();
		BitSet b = new BitSet();

		for (String ia : br.readLine().split(" "))
			a.set(Integer.parseInt(ia));

		for (String ib : br.readLine().split(" "))
			b.set(Integer.parseInt(ib));

		a.xor(b);
		System.out.println(a.cardinality());
	}
}
