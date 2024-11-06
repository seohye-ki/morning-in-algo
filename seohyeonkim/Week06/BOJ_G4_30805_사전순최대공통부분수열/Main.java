import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    static class point implements Comparable<point> {
        int value;
        int idx;

        public point(int value, int idx){
            this.value = value;
            this.idx = idx;
        }

        @Override
        public int compareTo(point p){
            if (this.value == p.value)
                return this.idx - p.idx;
            return p.value - this.value;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i = 0; i < N; i++)
            A[i] = sc.nextInt();
        
        int M = sc.nextInt();
        int[] B = new int[M];
        for(int i = 0; i < M; i++)
            B[i] = sc.nextInt();

        PriorityQueue<point> pqA = new PriorityQueue<>();
        PriorityQueue<point> pqB = new PriorityQueue<>();
        for(int i = 0; i < N; i++)
            pqA.add(new point(A[i], i));
        for(int i = 0; i < M; i++)
            pqB.add(new point(B[i], i));

        List<Integer> result = new ArrayList<>();
        int preIdxA = -1;
        int preIdxB = -1;

        while(!pqA.isEmpty() && !pqB.isEmpty()){
            if(pqA.peek().value == pqB.peek().value) {
                while(!pqA.isEmpty() && !pqB.isEmpty() && pqA.peek().value == pqB.peek().value){
                    if(preIdxA < pqA.peek().idx && preIdxB < pqB.peek().idx){
                        result.add(pqA.peek().value);
                        preIdxA = pqA.poll().idx;
                        preIdxB = pqB.poll().idx;
                        break;
                    }
                    else {
                        if(pqA.peek().idx < preIdxA)
                            pqA.poll();
                        if(pqB.peek().idx < preIdxB)
                            pqB.poll();
                    }
                }
            }
            else if(pqA.peek().value > pqB.peek().value)
                pqA.poll();
            else
                pqB.poll();
        }
        
        sb.append(result.size()).append("\n");
        for(int value : result)
            sb.append(value).append(" ");
        System.out.print(sb);
    }
}