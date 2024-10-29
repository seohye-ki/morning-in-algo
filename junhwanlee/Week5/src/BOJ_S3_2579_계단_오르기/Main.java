import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int[] nums = new int[N+1];
    	int[] sta = new int[N+1];
    	if (N == 1) {
    		System.out.println(Integer.parseInt(br.readLine()));
    	}
    	else {    
	    	for (int i = 1; i <= N; i++) {
	    		int num = Integer.parseInt(br.readLine());
	    		if (i > 2) {
	    			int num1 = nums[i-2];
	    			int num2 = nums[i-3]+ sta[i-1];
	    			nums[i] = Math.max(num1, num2) + num;
	    		}
	    		else {
	    			nums[i] = num+sta[i-1];
	    		}
	    		sta[i] = num;
	    	}
	    	System.out.println(nums[N]);
    	}
    }
}