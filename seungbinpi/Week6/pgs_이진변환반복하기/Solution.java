class Solution {
    static int convert = 0;
    static int zeros = 0;
    
    public int[] solution(String s) {
        method(s);
        
        int[] result = {convert, zeros};
        return result;
    }
    static void method(String s) {
        if (s.equals("1")) return;
        convert++;
        
        int tmpZero = 0;
        for (int i=0; i<s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '0') {
                tmpZero++;
                zeros++;
            }
        }
        int tmpInt = s.length() - tmpZero;
        if (tmpInt == 1) return;
        s = Integer.toBinaryString(tmpInt);
        
        method(s);
    }
}