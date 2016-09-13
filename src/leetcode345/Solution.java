package leetcode345;

public class Solution {
    public String reverseVowels(String s) {
    String vowels = "aoeiuAOEIU";
    char[] a = s.toCharArray();
    int i = 0;
    int j = a.length - 1;
    while (i < j) {
        while (i < j && !vowels.contains(a[i] + "")) {
            i++;
        }
        while (i < j && !vowels.contains(a[j] + "")) {
            j--;
        }
        if (i < j) {
            char c = a[i];
            a[i++] = a[j];
            a[j--] = c;
        }
    }

    return new String(a);
}
}
