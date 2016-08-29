package uva10130;

import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for(int i = 0; i < t; i++){
			int n = scanner.nextInt();
			int[] price = new int[n];
			int[] weight = new int[n];
			for(int j = 0; j < n; j++){
				price[j] = scanner.nextInt();
				weight[j] = scanner.nextInt();
			}
			int[] f = new int[31];
			for ( int j = 0 ; j <= 30 ; j++ )  
	            f[j] = 0;  
	        for ( int j = 0 ; j < n ; j++ )  
		        for ( int k = 30 ; k >= weight[j] ;k-- )  
		            if ( f[k] < f[k-weight[j]] + price[j] )  
		                f[k] = f[k-weight[j]] + price[j]; 
			int g = scanner.nextInt();
			int sum = 0;
 			for(int j = 0; j < g; j++){
				sum+= f[scanner.nextInt()];
			}
 			System.out.println(sum);
		}
		scanner.close();
	}

}
