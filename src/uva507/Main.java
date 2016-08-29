package uva507;

import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int stop;
		int sum, temp, begin, end, begintemp;
		for( int i = 0; i < count; i++){
			stop = sc.nextInt();
			int[] nice = new int[stop];
			sum = 0;
			temp = 0;
			begin = 0;
			end = 0;
			begintemp = 0;
			for( int j = 0; j < stop - 1; j++){
				nice[j] = sc.nextInt();
				if(temp + nice[j] > 0){
					if(temp == 0){
						begintemp = j;
					}
					temp = temp + nice[j];
				}
				else if (temp < 0){
					temp = 0;
				}
				if (temp > sum){
					
					sum = temp;
					end = j + 1;
					begin = begintemp;
				}
				else if (temp == sum && ((j + 1 - begintemp) > (end - begin))){
					end = j + 1;
					begin = begintemp;
				}
			}
			if (sum > 0){
				System.out.println("The nicest part of route " + (i + 1) + " is between stops " + (begin + 1) + " and " + ( end + 1));
			}
			else{
				System.out.println("Route " + (i + 1) +" has no nice parts");
			}
			
		}
		sc.close();

	}

}
