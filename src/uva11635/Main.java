package uva11635;

import java.util.ArrayDeque;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int city = scanner.nextInt();
		while (city != 0) {

			int[][] maps = new int[city][city];
			boolean[] isHotel = new boolean[city];
			isHotel[0] = true;
			isHotel[city - 1] = true;
			int hotel = scanner.nextInt();

			for (int i = 0; i < hotel; i++) {
				isHotel[scanner.nextInt() - 1] = true;
			}
			int road = scanner.nextInt();
			for (int i = 0; i < road; i++) {
				int p = scanner.nextInt() - 1;
				int q = scanner.nextInt() - 1;
				int t = scanner.nextInt();
				maps[p][q] = t;
				maps[q][p] = t;
			}
			
			int[][] hotelmaps = new int[city][city];

			for (int k = 0; k < city; k++) {
				if (isHotel[k]) {
					int[] totaldis = new int[city];
					int[] visit = new int[city];
					ArrayDeque<Integer> queue = new ArrayDeque<>();
					for (int i = 0; i < city; i++) {
						totaldis[i] = Integer.MAX_VALUE;
					}
					queue.addLast(k);
					visit[k] = 1;
					totaldis[k] = 0;
					while(!queue.isEmpty()){
						int now = queue.pollFirst();
						for (int i = 0; i < city; i++) {
							if (maps[now][i] > 0 && totaldis[i] > totaldis[now] + maps[now][i]) {
								totaldis[i] = totaldis[now] + maps[now][i];
								if (visit[i] == 0) {
									visit[i] = 1;
									queue.addLast(i);
								}
							}
						}
						visit[now] = 0;
					}
					for(int j = k + 1; j < city; j++){
						if(isHotel[j] && totaldis[j] <= 600){
							hotelmaps[j][k] = 1;
							hotelmaps[k][j] = 1;
						}
					}
				}
			}
			int[] totaldis = new int[city];
			int[] visit = new int[city];
			ArrayDeque<Integer> queue = new ArrayDeque<>();
			for (int i = 0; i < city; i++) {
				totaldis[i] = Integer.MAX_VALUE;
			}
			queue.addLast(0);
			visit[0] = 1;
			totaldis[0] = 0;
			while(!queue.isEmpty()){
				int now = queue.pollFirst();
				for (int i = 0; i < city; i++) {
					if (hotelmaps[now][i] == 1 && totaldis[i] > totaldis[now] + 1) {
						totaldis[i] = totaldis[now] + 1;
						if (visit[i] == 0) {
							visit[i] = 1;
							queue.addLast(i);
						}
					}
				}
				visit[now] = 0;
			}
			
			if(totaldis[city - 1] == Integer.MAX_VALUE){
				System.out.println(-1);
			}
			else{
				System.out.println(totaldis[city - 1] - 1);
			}
			city = scanner.nextInt();
		}
		scanner.close();
	}
}
