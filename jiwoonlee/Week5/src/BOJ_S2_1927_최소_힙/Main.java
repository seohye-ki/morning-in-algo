package BOJ_S2_1927_최소_힙;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] mh;
	static int size;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		size = 0;

		mh = new int[n + 1];

		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input > 0) {
				insert(input);
			} else {
				if (size == 0) {
					System.out.println(0);
				} else {
					System.out.println(getMin());
				}
			}

		}
	}

	static void insert(int v) {
		mh[++size] = v;
		int idx = size;

		while (mh[idx / 2] > mh[idx] && idx >= 2) {
			swap(idx / 2, idx);
			idx /= 2;
		}
	}

	static int getMin() {
		if (size == 0)
			return 0;
		int min = mh[1];
		mh[1] = mh[size--];
		heap(1);
		return min;
	}

	static void heap(int idx) {
		int min = idx;
		while (true) {
			int l = idx * 2;
			int r = idx * 2 + 1;
			if (l <= size && mh[l] < mh[min])
				min = l;
			if (r <= size && mh[r] < mh[min])
				min = r;

			if (min != idx) {
				swap(idx, min);
				idx = min;
			} else {
				break;
			}
		}
	}

	static void swap(int i, int j) {
		int tmp = mh[i];
		mh[i] = mh[j];
		mh[j] = tmp;
	}
}
