package uva11462;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));
		long[] num = new long[105];
		long n = Long.parseLong(br.readLine());
		while(n > 0){
			for(long i = 0; i < n; i++){
				int m = 0;
				int temp = br.read();
				while(temp >= 48 && temp <= 57){
					m = m * 10 + temp - 48;
					temp = br.read();
				}
				num[m]++;
			}
			br.read();
			boolean count = false;
			for(int i = 1; i < num.length; i++){
				if (num[i] > 0){
					for(long j = 0; j < num[i]; j++){
						if(count){
							System.out.print(' ');
						}
						else
							count = true;
						System.out.print(i);
						
					}
					num[i] = 0;
				}
			}
			System.out.println();
			n = Long.parseLong(br.readLine());
		}
		br.close();
	}

}
