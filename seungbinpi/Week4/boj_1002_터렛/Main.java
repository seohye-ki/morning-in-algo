import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc=1; tc<=T; tc++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();
            
            double d = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
            
            int result = -1;
            
            if (d == 0.0) {
            	if (r1 == r2) result = -1;
            	else result = 0;
            }
            else if (d < Math.max(r1, r2)) {
            	if (d + Math.min(r1, r2) < Math.max(r1, r2)) result = 0;
            	else if (d + Math.min(r1, r2) == Math.max(r1, r2)) result = 1;
            	else result = 2;
            }
            else if (d == Math.max(r1, r2)) result = 2;
            else {
            	if (d > r1+r2) result = 0;
            	else if (d == r1+r2) result = 1;
            	else result = 2;
            }
            
            System.out.println(result);
        }
    }
}