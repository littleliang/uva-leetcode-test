package uva11450;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for( int i = 0; i < n; i++){
			int money = scanner.nextInt();
			int garment = scanner.nextInt();
			boolean[] dp = new boolean[money + 1];
			dp[0] = true;
			for( int j = 0; j < garment; j++){
				boolean[] dp1 = new boolean[money + 1];
				int kk = scanner.nextInt();
				for(int k = 0; k < kk; k++){
					int price = scanner.nextInt();
					for(int p = 0; p <= money; p++){
						if(dp[p] && (p + price <= money)){
							dp1[p + price] = true;
						}
					}
				}
				dp = dp1.clone();
			}
			boolean flag = true;
			int res = 0;
			for(int p = money; p >= 0; p--){
				if(dp[p]){
					res = p;
					flag = false;
					break;
				}
			}
			if(flag){
				System.out.println("no solution");
			}else{
				System.out.println(res);
			}
		}
		scanner.close();
	}

}
