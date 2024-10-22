import java.util.*;

class Solution {
    public int solution(String word) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('E', 1);
        map.put('I', 2);
        map.put('O', 3);
        map.put('U', 4);
        
        int N = word.length();
        int result = N;
        
        result += 781 * map.get(word.charAt(0));
        if (N >= 2)
            result += 156 * map.get(word.charAt(1));
        if (N >= 3)
            result += 31 * map.get(word.charAt(2));
        if (N >= 4)
            result += 6 * map.get(word.charAt(3));
        if (N == 5)
            result += map.get(word.charAt(4));
        
        return result;
    }
}