package uva11727;

import java.util.Arrays;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[] salary = new int[3];
		for ( int i = 0; i < count; i++){
			salary[0] = sc.nextInt();
			salary[1] = sc.nextInt();
			salary[2] = sc.nextInt();
			Arrays.sort(salary);
			System.out.println("Case " + (i + 1) + ": " + salary[1]);
		}
		sc.close();
	}

}
