package leetcode168;

public class Solution {
    public String convertToTitle(int n) {

        char[] result = new char[20];
        int index = 20;
        n--;
        do {
            result[--index] = (char) ('A' + n % 26);
            n = n / 26 - 1;
        } while (n >= 0);
        return new String(result, index, 20 - index);
    }
}