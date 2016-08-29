package uva562;


import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		for(int i = 0; i < count; i++){
			int m = scanner.nextInt();
			int[] coins = new int[m];
			int sum = 0;
			for(int j = 0; j < m; j++){
				coins[j] = scanner.nextInt();
				sum += coins[j];
			}
			int[] d = new int[sum + 1];
			d[0] = 1;
			int temp = 0;
			for(int j = 0; j < m; j++){
				temp += coins[j];
				for(int k = temp; k >= coins[j]; k--){
					if (d[k - coins[j]] == 1)
						d[k] = 1;
				}
			}
			for(temp = sum / 2; temp >= 0; temp--)  
	            if(d[temp] == 1)  
	             break;  
			
			
			System.out.println((sum - temp - temp));
		}
		scanner.close();

	}

}
