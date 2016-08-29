package uva10083;

import java.math.BigInteger;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BigInteger one = new BigInteger("1");
		BigInteger a, res;
		int b,c;
		while(scanner.hasNext()){
			a = scanner.nextBigInteger();
			b = scanner.nextInt();
			c = scanner.nextInt();
			if(b < c || a.intValue() == 1){
				System.out.println("(" + a + "^" + b + "-1)/(" + a + "^" + c + "-1) is not an integer with less than 100 digits.");
				continue;
			}
			if(b == c) {
                System.out.println("(" + a + "^" + b + "-1)/(" + a + "^" + c + "-1) " + 1);
                continue;
            }
            if(b % c!=0){
            	System.out.println("(" + a + "^" + b + "-1)/(" + a + "^" + c + "-1) is not an integer with less than 100 digits.");
                continue;
            }
            if(b == 0){
            	System.out.println("(" + a + "^" + b + "-1)/(" + a + "^" + c + "-1) " + 0);
                continue;
            }
            if((b - c) * (Math.log10(Integer.parseInt(a.toString())))>100){
            	System.out.println("(" + a + "^" + b + "-1)/(" + a + "^" + c + "-1) is not an integer with less than 100 digits.");
                continue;
            }
            res = (a.pow(b).subtract(one)).divide(a.pow(c).subtract(one));
			if(res.toString().length() > 100 || a.pow(b).subtract(one).mod(a.pow(c).subtract(one)).compareTo(BigInteger.valueOf(0)) != 0){
				System.out.println("(" + a + "^" + b + "-1)/(" + a + "^" + c + "-1) is not an integer with less than 100 digits.");
			}
			else{
				System.out.println("(" + a + "^" + b + "-1)/(" + a + "^" + c + "-1) " + res);
			}
		}
		scanner.close();
	}

}
