package uva10106;

import java.math.BigInteger;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()){
			BigInteger a = new BigInteger(scanner.nextLine());
			BigInteger b = new BigInteger(scanner.nextLine());
			System.out.println(a.multiply(b));
			
		}
		scanner.close();

	}

}
