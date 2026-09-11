import java.util.*;

class Solution {
    public int totalNumbers(int[] digits) {
        int[] count = new int[10];
        for (int d : digits) {
            count[d]++;
        }

        int total = 0;

        for (int num = 100; num <= 998; num += 2) {
            int d1 = num / 100;      
            int d2 = (num / 10) % 10;  
            int d3 = num % 10;        

            int[] req = new int[10];
            req[d1]++;
            req[d2]++;
            req[d3]++;
            boolean possible = true;
            for (int i = 0; i < 10; i++) {
                if (req[i] > count[i]) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                total++;
            }
        }

        return total;
    }
}