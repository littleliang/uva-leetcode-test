package uva10003;

import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int len, num;
		len = scanner.nextInt();
		while(len > 0){
			num = scanner.nextInt();
			int[] node = new int[num + 2];
			for(int i = 0; i < num; i++){
				node[i + 1] = scanner.nextInt();
			}
			node[num + 1] = len;
			node[0] = 0;
			int[][] dp = new int[num + 2][num + 2];
			for(int p = 2; p < num + 2; p++){
				for(int i = 0; i < num; i++){
					int j = i + p;
					if (j > num + 1)
						break;
					int min = Integer.MAX_VALUE;
					int tmp;
					for(int k=i+1; k < j; k++)
		               {
		                   tmp = dp[i][k] + dp[k][j] + node[j] - node[i];
		                   if(min > tmp)
		                	   min = tmp;
		               }
		               if(min != Integer.MAX_VALUE)
		            	   dp[i][j]=min;
				}
			}
			System.out.println("The minimum cutting is " + dp[0][num+1] + ".");
			len = scanner.nextInt();
		}
		scanner.close();
	}

}
