package uva443;

import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] num = {2, 3, 5, 7};
		int[] freq = {1, 1, 1, 1};
		int[] res = new int[5843];
		res[1] = 1;
		int count = 2;
		while(count < 5843){
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < 4; i++){
				if(min > num[i] * res[freq[i]]){
					min = num[i] * res[freq[i]];
				}
			}
			for(int i = 0; i < 4; i++){
				if(min == num[i] * res[freq[i]]){
					freq[i]++;
				}
			}
			res[count++] = min;
		}
		int n = scanner.nextInt();
		while(n > 0){
			System.out.print("The " + n);
	        if ( n%100 == 11 || n%100 == 12 || n%100 == 13 )  
	        	System.out.print("th");  
	        else if ( n % 10 == 1 )  
	        	System.out.print("st");  
	        else if ( n % 10 == 2 )  
	        	System.out.print("nd");  
	        else if ( n % 10 == 3 )  
	        	System.out.print("rd");  
	        else System.out.print("th");  
	        System.out.println(" humble number is " + res[n] + ".");
	        n = scanner.nextInt();
		}
		
		scanner.close();
	}

}
