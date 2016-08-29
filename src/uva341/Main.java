package uva341;

import java.util.Scanner;
import java.util.Stack;

class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int count = 0;
		while(m > 0){
			count++;
			int[][] dis = new int[m][m];
			int[] totaldis = new int[m];
			int[] before = new int[m];
			int[] visit = new int[m];
			for(int i = 0; i < m; i++){
				totaldis[i] = Integer.MAX_VALUE;
				int p = scanner.nextInt();
				for(int j = 0; j < p; j++){
					int end = scanner.nextInt();
					int d = scanner.nextInt();
					dis[i][end - 1] = d;
				}
			}
			int startpoint = scanner.nextInt() - 1;
			int endpoint = scanner.nextInt() - 1;
			int nextpoint = startpoint;
			visit[startpoint] = 1;
			totaldis[startpoint] = 0;
			before[startpoint] = -1;
			while(nextpoint != endpoint){
				for(int i = 0; i < m; i++){
					if (dis[nextpoint][i] > 0 && visit[i] == 0){
						if(totaldis[i] > (dis[nextpoint][i] + totaldis[nextpoint])){
							totaldis[i] = dis[nextpoint][i] + totaldis[nextpoint];
							before[i] = nextpoint;
						}
					}
				}
				int temp = Integer.MAX_VALUE;
				for(int i = 0; i < m; i++){
					if (totaldis[i] < temp && visit[i] == 0){
						temp = totaldis[i];
						nextpoint = i;
					}
				}
				visit[nextpoint] = 1;
			}
			Stack<Integer> ll = new Stack<>();
			ll.push(nextpoint + 1);
			while(before[nextpoint] > -1){
				ll.push(before[nextpoint] + 1);
				nextpoint = before[nextpoint];
			}
			System.out.print("Case ");
			System.out.print(count);
			System.out.print(": Path =");
			while(!ll.isEmpty()){
				System.out.print(' ');
				System.out.print(ll.pop());
			}
			System.out.print("; ");
			System.out.print(totaldis[endpoint]);
			System.out.println(" second delay");
			m = scanner.nextInt();
		}
		scanner.close();

	}

}
