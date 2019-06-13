/**
 * 
 */
package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @Project : codePlus
 * @Package : graph
 * @FileName : _1260.java
 * @Author : hyunyoungkim
 * @Date : Jan 24, 2019
 */
public class _1260 { // DFS와 BFS : http://www.acmicpc.net/1260

	/**
	 * @param args
	 */
	static int n, m, v;
	static int[][] adjMat;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());

		visited = new boolean[n + 1];
		Arrays.fill(visited, false);

		adjMat = new int[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			adjMat[v1][v2] = adjMat[v2][v1] = 1;
		}

		dfs(v);
		sb.append(System.lineSeparator());

		Arrays.fill(visited, false);
		bfs(v);

		System.out.println(sb);

	}

	private static void dfs(int start) {
		visited[start] = true;
		sb.append(start + " ");
		for (int i = 1; i <= n; i++) {
			if (adjMat[start][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}

	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		while (!queue.isEmpty()) {
			start = queue.poll();
			sb.append(start + " ");
			for (int i = 1; i <= n; i++) {
				if (adjMat[start][i] == 1 && !visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}

}
