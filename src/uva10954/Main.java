package uva10954;

import java.util.PriorityQueue;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		while(n > 0){
			
			for(int i = 0; i < n; i++){
				queue.add(scanner.nextInt());
			}
			int sum = 0;
			while(queue.size() > 1){
				int a = queue.poll();
				int b = queue.poll();
				sum += (a + b);
				queue.add(a + b);
			}
			queue.clear();
			System.out.println(sum);
			n = scanner.nextInt();
		}
		scanner.close();
	}

}
