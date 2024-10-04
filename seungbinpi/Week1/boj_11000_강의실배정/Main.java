import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        Long[][] timeInfo = new Long[N][2];
        
        for (int i=0; i<N; i++) {
            timeInfo[i][0] = (long) sc.nextInt();
            timeInfo[i][1] = (long) sc.nextInt();
        }
        
        Arrays.sort(timeInfo, (a, b) -> {
        	if (a[0] > b[0]) return 1;
        	else if (a[0] < b[0]) return -1;
        	else {
        		if (a[1] > b[1]) return 1;
        		else if (a[1] < b[1]) return -1;
        		else return 0;
        	}
        });
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for (int i=0; i<N; i++) {
        	if (!pq.isEmpty()) {
        		if (pq.peek() <= timeInfo[i][0])
        			pq.poll();
        	}
        	pq.offer(timeInfo[i][1]);
        }
        
        System.out.println(pq.size());
    }
}