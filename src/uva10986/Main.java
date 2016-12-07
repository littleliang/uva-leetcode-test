package uva10986;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();
    for (int i = 0; i < num; i++) {
      int n = scanner.nextInt();
      int m = scanner.nextInt();
      int s = scanner.nextInt();
      int t = scanner.nextInt();
      ArrayList<Edge>[] edges = new ArrayList[n];
      for (int j = 0; j < m; j++) {
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        if (edges[a] == null) {
          edges[a] = new ArrayList<Edge>();
        }
        if (edges[b] == null) {
          edges[b] = new ArrayList<Edge>();
        }
        edges[a].add(new Edge(b, c));
        edges[b].add(new Edge(a, c));
      }
      int[] dist = new int[n];
      Arrays.fill(dist, Integer.MAX_VALUE);
      dist[s] = 0;
      PriorityQueue<Node> pq = new PriorityQueue<Node>();
      pq.offer(new Node(s, 0));
      boolean ada = false;
      while (!pq.isEmpty()) {
        Node c = pq.poll();
        if (c.pos == t) {
          ada = true;
          System.out.println("Case #" + (i + 1) + ": " + c.cost);
          break;
        }
        if (edges[c.pos] != null) {
          for (Edge e : edges[c.pos]) {
            if (dist[e.cur] > c.cost + e.w) {
              dist[e.cur] = c.cost + e.w;
              pq.offer(new Node(e.cur, dist[e.cur]));
            }
          }
        }
      }
      if (!ada) {
        System.out.println("Case #" + (i + 1) + ": unreachable");
      }
    }
    scanner.close();
  }
}


class Node implements Comparable<Node> {
  int pos, cost;

  public Node(int pos, int cost) {
    this.pos = pos;
    this.cost = cost;
  }

  public int compareTo(Node o) {
    return cost - o.cost;
  }
}


class Edge {
  int cur, w;

  public Edge(int a, int w) {
    this.cur = a;
    this.w = w;
  }
}
