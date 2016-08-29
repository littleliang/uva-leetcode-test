package uva104;

import java.util.Scanner;
import java.util.Stack;

class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			double[][][] D = new double[n][n][n];
			int[][][] P = new int[n][n][n];
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					if(i == j){
						D[i][j][0] = 1.0;
					}
					else{
						D[i][j][0] = scanner.nextDouble();
					}
				}
			}
			
			boolean flag = false;
			
			for(int s = 1; s < n; s++){
				for(int i = 0; i < n; i++){
					for(int j = 0; j < n; j++){
						double max = -1;
						int index = 0;;
						for(int k = 0; k < n; k++){
							if(max < D[i][k][s - 1] * D[k][j][0]){
								max = D[i][k][s - 1] * D[k][j][0];
								D[i][j][s] = max;
								index = k;
							}
						}
						P[i][j][s] = index;
					}
					
					if (D[i][i][s] - 1.01 > 1e-9) {
						Stack<Integer> ll = new Stack<>();
						int temp = P[i][i][s];
						ll.push(temp);
						for(int p = s - 1; p > 0; p--){
							temp = P[i][temp][p];
							ll.push(temp);
						}
						ll.push(i);
						while(!ll.isEmpty()){
							System.out.print(ll.pop() + 1);
							System.out.print(' ');
						}
						System.out.print(i + 1);
						System.out.println();
						flag = true;
		                break;
		            }  
				}
				if(flag)
					break;
			}
			
			if(!flag)
				System.out.println("no arbitrage sequence exists");
		}
		scanner.close();

	}

}
