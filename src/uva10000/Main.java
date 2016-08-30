package uva10000;

import java.util.ArrayDeque;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int count = 0;
		while (0 != n) {
			count++;
			int s = scanner.nextInt();
			int[][] maps = new int[n][n];
			int[] dis = new int[n];
			boolean[] vis = new boolean[n];
			ArrayDeque<Integer> queue = new ArrayDeque<>();
			int p = scanner.nextInt();
			int q = scanner.nextInt();
			while (p + q != 0) {
				maps[p - 1][q - 1] = 1;
				p = scanner.nextInt();
				q = scanner.nextInt();
			}
			vis[s - 1] = true;
			queue.addLast(s - 1);
			while (!queue.isEmpty()) {
				int now = queue.pollFirst();
				for (int i = 0; i < n; i++) {
					if (maps[now][i] == 1 && dis[i] > dis[now] - 1) {
						dis[i] = dis[now] - 1;
						if (!vis[i]) {
							vis[i] = true;
							queue.addLast(i);
						}
					}
				}
				vis[now] = false;
			}
			int space = 0;
			for (int i = 0; i < n; i++) {
				if (dis[i] < dis[space])
					space = i;
			}
			System.out.println("Case "+ count + ": The longest path from " + s + " has length " + -1 * dis[space] + ", finishing at " + (space + 1) +".");
			System.out.println();
			n = scanner.nextInt();
		}
		scanner.close();
	}
}
