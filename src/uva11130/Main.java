package uva11130;

import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double a, b, v, A, s;
		a = scanner.nextDouble();
		b = scanner.nextDouble();
		v = scanner.nextDouble();
		A = scanner.nextDouble();
		s = scanner.nextDouble();
		while((a + b + v + A + s) > 1e-9){
			A = A / 180 * Math.PI;
			double hor = v * s / 2 * Math.cos(A);
			double ver = v * s / 2 * Math.sin(A);
			int ans;
			if(hor >= a/2.0)  
	        {  
	            ans = (int) Math.round(hor/a);
	            System.out.print(ans);
	            System.out.print(' ');
	        }  
	        else{
	        	System.out.print(0);
	        	System.out.print(' ');
	        }
	        if(ver >= b/2.0)  
	        {  
	        	ans = (int) Math.round(ver/b);  
	        	System.out.println(ans);
	        }  
	        else  
	        	System.out.println(0);
	        a = scanner.nextDouble();
			b = scanner.nextDouble();
			v = scanner.nextDouble();
			A = scanner.nextDouble();
			s = scanner.nextDouble();
		}
		scanner.close();
	}

}
