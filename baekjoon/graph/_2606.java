package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2606 { // 바이러스 : http://www.acmicpc.net/problem/2606

	static int n, m;
	static int[][] adjMat;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		adjMat = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		Arrays.fill(visited, false);
		
		// 인접 행렬 생성
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			adjMat[v1][v2] = adjMat[v2][v1] = 1;
		}

		dfs(1);

		int cnt = 0;
		for (int i = 1; i < visited.length; i++) {
			if (visited[i]) {
				cnt++;
			}
		}

		System.out.println(cnt - 1);
	}

	static void dfs(int start) {
		visited[start] = true;
		for (int i = 1; i <= n; i++) {
			if (adjMat[start][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}

}
