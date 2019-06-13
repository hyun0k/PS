package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _10451 { // 순열 사이클 : http://www.acmicpc.net/problem/10451

	static int n;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			n = Integer.parseInt(br.readLine());
			visited = new boolean[n + 1];
			Arrays.fill(visited, false);

			adjList = new ArrayList[n + 1];

			for (int i = 1; i <= n; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				int v1 = i;
				int v2 = Integer.parseInt(st.nextToken());
				adjList[v1].add(v2);
			}

			int cnt = 0;
			for (int i = 1; i <= n; i++) {
				if (visited[i]) {
					continue;
				}
				dfs(i);
				cnt++;
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);

	}

	static void dfs(int start) {
		visited[start] = true;
		for (int i : adjList[start]) {
			if (!visited[i]) {
				dfs(i);
			}
		}
	}

}
