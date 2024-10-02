import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        int[] count = new int[10000001];
        
        // tangerine 순회하며 카운트
        for (int i=0; i<tangerine.length; i++) {
            count[tangerine[i]]++;
        }
        
        // count 배열 정렬
        Arrays.sort(count);
        
        // 종류 개수 변수
        int kind = 0;
        
        // count 배열 뒤에서부터 하나씩 순회
        for (int i=count.length-1; i>=0; i--) {
            kind++;
            
            k -= count[i];
            
            if (k <= 0) break;
        }
        
        return kind;
    }
}