/**
 * 
 */
package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Project : codePlus
 * @Package : graph
 * @FileName : _11724.java
 * @Author : hyunyoungkim
 * @Date : Feb 13, 2019
 */
public class _11724 { // 연결요소의 개수 : http://www.acmicpc.net/problem/11724

	/**
	 * @param args
	 */
	static int n, m;
	static boolean[] visited;
	static int[][] adjMat;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		adjMat = new int[n + 1][n + 1];

		visited = new boolean[n + 1];
		Arrays.fill(visited, false);

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			adjMat[v1][v2] = adjMat[v2][v1] = 1;
		}

		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				dfs(i);
			} else {
				continue;
			}
			cnt++;
		}
		System.out.println(cnt);
	}

	private static void dfs(int start) {
		visited[start] = true;
		for (int i = 1; i <= n; i++) {
			if (adjMat[start][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}
}
