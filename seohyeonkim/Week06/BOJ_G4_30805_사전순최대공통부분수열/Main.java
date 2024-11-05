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
                return Integer.compare(this.idx, p.idx);
            return Integer.compare(p.value, this.value);
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

        List<point> listA = new ArrayList<>();
        List<point> listB = new ArrayList<>();
        for(int i = 0; i < N; i++)
            listA.add(new point(A[i], i));
        for(int i = 0; i < M; i++)
            listB.add(new point(B[i], i));

        Collections.sort(listA);
        Collections.sort(listB);
        
        // for(point p : listA)
        //     sb.append(p.value).append(" ");
        // sb.append("\n");
        // for(point p : listA)
        //     sb.append(p.idx).append(" ");
        // sb.append("\n");
        // for(point p : listB)
        //     sb.append(p.value).append(" ");
        // sb.append("\n");
        // for(point p : listB)
        //     sb.append(p.idx).append(" ");
        // sb.append("\n");
        // System.out.println(sb);
     
        List<Integer> result = new ArrayList<>();
        int idxA = 0;
        int idxB = 0;
        int preIdx = -1;

        while(idxA < N && idxB < M){
            //값이 같고 이미 들어가있는 값의 인덱스보다 크다면
            if(listA.get(idxA).value == listB.get(idxB).value && preIdx < listA.get(idxA).idx) {
                result.add(listA.get(idxA).value);
                preIdx = listA.get(idxA).idx;
                idxA++;
                idxB++;
            }
            else if(listA.get(idxA).value > listB.get(idxB).value)
                idxA++;
            else
                idxB++;
        }
        
        sb.append(result.size()).append("\n");
        for(int value : result)
            sb.append(value).append(" ");
        System.out.println(sb);
    }
}