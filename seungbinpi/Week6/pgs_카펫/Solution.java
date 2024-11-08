class Solution {
    public int[] solution(int brown, int yellow) {
        int a = 0;
        int b = 0;
        int total = brown + yellow;
        
        for (int v=3; v<2500000; v++) {
            if (total % v == 0) {
                if (yellow % (v-2) == 0 && (v-2)*(total/v-2)==yellow) {
                    a = v;
                    b = total / v;
                    break;
                }
            }
        }
        int[] result = {b, a};
        return result;
    }
}