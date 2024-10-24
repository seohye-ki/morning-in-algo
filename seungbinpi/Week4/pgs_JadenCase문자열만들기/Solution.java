class Solution {
    public String solution(String s) {
        
        int N = s.length();
        s = s.toLowerCase();
        
        StringBuilder sb = new StringBuilder();
        
        char tmp = s.charAt(0);
        if (tmp >= 97 && tmp <= 122)
            tmp -= 32;
        sb.append(tmp);
        
        for (int i=1; i<N; i++) {
            tmp = s.charAt(i);
            if (s.charAt(i-1)==32 && tmp >= 97 && tmp <= 122)
                tmp -= 32;
            sb.append(tmp);
        }
        
        return sb.toString();
    }
}
//97~122
//65~90