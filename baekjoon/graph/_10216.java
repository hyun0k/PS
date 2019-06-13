package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _10216 { // Count Circle Groups : http://www.acmicpc.net/problem/10216

	static int n;
	static ArrayList<Node> enemy;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {

			enemy = new ArrayList<Node>();
			n = Integer.parseInt(br.readLine());
			visited = new boolean[n];
			Arrays.fill(visited, false);

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				enemy.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken())));
			}

			int cnt = 0;
			for (int i = 0; i < enemy.size(); i++) {
				if (!visited[i]) {
					bfs(i);
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	// bfs로 연결된 진영 탐색
	static void bfs(int start) {
		Queue<Node> q = new LinkedList<>();
		q.add(enemy.get(start));
		visited[start] = true;
		while (!q.isEmpty()) {
			Node node = q.poll();
			for (int i = 0; i < enemy.size(); i++) {
				if (!visited[i] && isConnected(enemy.get(i), node)) {
					visited[i] = true;
					q.add(enemy.get(i));
				}
			}
		}
	}

	// 두 노드 사이가 두 노드 범위 합보다 작거나 같으면 true
	static boolean isConnected(Node a, Node b) {
		return dist(a, b) <= a.r + b.r;
	}

	// 두 노드 사이 거리 계산
	static double dist(Node a, Node b) {
		return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
	}

	// 노드 클래스 생성
	static class Node {
		int x;
		int y;
		int r;

		Node(int x, int y, int r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}
	}

}
