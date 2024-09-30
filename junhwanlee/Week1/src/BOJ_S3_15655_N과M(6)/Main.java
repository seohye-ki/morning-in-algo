import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static Integer[] nums;
    static int N, M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new Integer[N];
        st = new StringTokenizer(br.readLine());
        boolean[] can = new boolean[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        find(0, 0, can);
    }

    static void find(int count, int idx, boolean[] can) {
        if (count == M) {
            for (int i = 0; i < N; i++) {
                if (can[i]) {
                    System.out.print(nums[i]+" ");
                }
            }
            System.out.println();
            return;
        }
        if (idx >= N) {return;}
        can[idx] = true;
        find(count+1, idx+1, can);
        can[idx] = false;
        find(count, idx+1, can);
    }
}