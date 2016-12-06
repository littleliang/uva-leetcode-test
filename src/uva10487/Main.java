package uva10487;

import java.util.Arrays;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int count = 0;
    while(scanner.hasNext()) {
      count++;
      int n = scanner.nextInt();
      if (n == 0){
        break;
      }
      int[] num = new int[n];
      for ( int i = 0; i < n; i++){
        num[i] = scanner.nextInt();
      }
      Arrays.sort(num);
      int m = scanner.nextInt();
      System.out.println("Case " + count + ":");
      for (int i = 0; i < m; i++){
        int sum = scanner.nextInt();
        int close = Integer.MIN_VALUE;
        int start = 0;
        int end = n - 1;
        while(start < end){
          int temp = num[start] + num[end];
          if (Math.abs(sum - temp) < Math.abs(close - sum)) {
            close = temp;
          }
          if (temp < sum){
            start++;
          } else if (temp > sum) {
            end--;
          } else {
            break;
          }
        }
        System.out.println("Closest sum to " + sum + " is " + close + ".");
      }
    }
    scanner.close();
  }
}
