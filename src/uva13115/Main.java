package uva13115;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		for ( int i = 0; i < count; i++){
			int len = scanner.nextInt();
			int sqrtLen = (int)Math.sqrt(len);
			int[][] array = new int[len][len];
			for ( int j = 0; j < len; j++){
				for (int k = 0; k < len; k++){
					array[j][k] = scanner.nextInt();
				}
			}
			boolean flag = true;
			Set<Integer> testSet = new HashSet<>();
			for ( int j = 0; j < len; j++){
				for (int k = 0; k < len; k++){
					testSet.add(array[j][k]);
				}
				if (testSet.size() < len){
					System.out.println("no");
					flag = false;
					break;
				}
				testSet.clear();
				for (int k = 0; k < len; k++){
					testSet.add(array[k][j]);
				}
				if (testSet.size() < len){
					System.out.println("no");
					flag = false;
					break;
				}
				testSet.clear();
				for (int k = 0; k < sqrtLen; k++){
					for (int l = 0; l < sqrtLen; l++){
						testSet.add(array[ j / sqrtLen * sqrtLen + k][ j % sqrtLen * sqrtLen + l]);
					}
				}
				if (testSet.size() < len){
					System.out.println("no");
					flag = false;
					break;
				}
				testSet.clear();
			}
			
			if (flag == false){
				continue;
			}
			
			
			
			System.out.println("yes");
		}
		scanner.close();

	}

}
