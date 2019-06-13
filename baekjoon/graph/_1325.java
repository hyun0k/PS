package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class _1325 { // 효율적인 해킹 : http://www.acmicpc.net/problem/1325

	/**
	 * 2차원 배열로 인접행렬을 통해 구현하면 시간초과가 나므로 인접리스트를 이용해서 구현해야함.
	 */
	static int n, m;
	static boolean[] visited;
	static ArrayList<Integer>[] adjList;
	static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		adjList = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			adjList[v1].add(v2);
		}

		arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];
			Arrays.fill(visited, false);
			dfs(i);
		}

		int max = -1;
		for (int i = 1; i <= n; i++) {
			if (arr[i] >= max) {
				max = arr[i];
			}
		}

		for (int i = 1; i <= n; i++) {
			if (arr[i] == max) {
				sb.append(i + " ");
			}
		}
		System.out.println(sb);

	}

	static void dfs(int start) {
		visited[start] = true;
		for (int i : adjList[start]) {
			if (!visited[i]) {
				arr[i]++;
				dfs(i);
			}
		}
	}

}
