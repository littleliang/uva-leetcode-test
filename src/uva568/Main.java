package uva568;

import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] res = new int[10001];
		res[1] = 1;
		res[0] = 1;
		for(int i = 2; i < 10001; i++){
			res[i] = res[i - 1] * i;
			while(res[i] % 10 == 0){
				res[i] = res[i] / 10;
			}
			res[i] = res[i] % 100000;
		}
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			System.out.printf("%5d -> %d\n", n, res[n] % 10);
		}
		scanner.close();
	}

}
