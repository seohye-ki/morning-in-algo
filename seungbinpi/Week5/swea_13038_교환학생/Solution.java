import java.util.*;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc=1; tc<=T; tc++) {
			int n = sc.nextInt();
			int[] week = new int[7];
			int perWeek = 0;
			for (int i=0; i<7; i++) {
				week[i] = sc.nextInt();
				perWeek += week[i];
			}
			
			int result = 7 * (n / perWeek);
			int remain = n % perWeek;
			if (remain == 0) {
				result -= 7;
				remain = perWeek;
			}
			
			int min = 9999;
			for (int start=0; start<7; start++) {
				if (remain == 0) break;
				int days = 0;
				int classDays = 0;
				
				for (int i=0; i<7; i++) {
					days++;
					if (week[(start+i)%7] == 0) continue;
					classDays++;
					if (classDays == remain) break;
				}
				min = Math.min(min, days);
			}
			result += min;
			System.out.println("#" + tc + " " + result);
		}
	}
}
