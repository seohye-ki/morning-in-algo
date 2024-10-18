package BOJ_S3_10974_모든_순열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int N;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		do {
			for (int i = 0; i < N; i++) {
				bw.write(arr[i] + " ");
			}
			bw.write("\n");
		} while (nextP());

		bw.flush();
	}

	static boolean nextP() {
		int i = N - 1;
		int j = N - 1;

		while (i > 0 && arr[i - 1] >= arr[i])
			i--;

		if (i <= 0)
			return false;

		while (arr[j] <= arr[i - 1])
			j--;

		swap(i - 1, j);
		j = N - 1;

		while (i < j) {
			swap(i, j);
			i++;
			j--;
		}

		return true;
	}

	static void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
