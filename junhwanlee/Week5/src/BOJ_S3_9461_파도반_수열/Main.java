import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long[] rac = new long[101];
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	rac[1] = 1;
    	rac[2] = 1;
    	rac[3] = 1;
    	rac[4] = 2;
    	rac[5] = 2;
    	for (int test = 0; test < T; test++) {
    		int N = Integer.parseInt(br.readLine());
    		if (rac[N] == 0) {
    			for (int i = 6; i <= N; i++) {
    				rac[i] = rac[i-1]+rac[i-5];
    			}
    		}
    		sb.append(rac[N]+"\n");
    	}
    	System.out.println(sb);
    }
}