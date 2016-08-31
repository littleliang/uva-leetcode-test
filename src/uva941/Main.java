package uva941;

import java.util.Arrays;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int s = Integer.parseInt(scanner.nextLine());
		String input;
		long index;
		char[] temp;
		long[] factorial = new long[22];
		long tempindex;
		long count;
		factorial[0] = 1;
		for(int i = 1; i < 22; i++){
			factorial[i] = (long) i * factorial[i - 1];
		}
		while(s > 0){
			input = scanner.nextLine();
			index = Long.parseLong(scanner.nextLine());
			temp = input.toCharArray();
			Arrays.sort(temp);
			for(int i = input.length() - 1; i >= 0; i--){
				if(index < factorial[i]){
					tempindex = 0;
				}
				else{
					tempindex = index / factorial[i];
				}
				count = 0;
				for(int j = 0; j < input.length(); j++){
					if(temp[j] > 0){
						if (count == tempindex) {  
		                    System.out.print(temp[j]); 
		                    temp[j] = 0;  
		                    break;  
		                }else {  
		                    count ++;  
		                }  
					}
				}
				index = index % factorial[i];
			}
			System.out.println();
			s--;
		}
		scanner.close();
	}

}
