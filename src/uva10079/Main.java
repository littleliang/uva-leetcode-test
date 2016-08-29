package uva10079;

import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long num = 0;
		num = scanner.nextLong();
		while(num >= 0){
			System.out.println( num * (num + 1) / 2 + 1);
			num = scanner.nextInt();
		}
		scanner.close();

	}

}
