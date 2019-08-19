package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _14889 { // 스타트와 링크 : http://www.acmicpc.net/problem/14889

	/**
	 *  백트래킹 
	 */
	
	static int N, min;
	static int[][] map;
	static boolean[] team;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		team = new boolean[N];

		min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);

		System.out.println(min);

	}

	private static void dfs(int k, int cur) {

		if (k == N / 2) {

			ArrayList<Integer> start = new ArrayList<>();
			ArrayList<Integer> link = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				if (team[i]) {
					start.add(i);
				} else {
					link.add(i);
				}
			}

			int t1 = 0, t2 = 0;
			for (int i = 0; i < start.size(); i++) {
				for (int j = i + 1; j < start.size(); j++) {
					int start_x = start.get(j);
					int start_y = start.get(i);
					int link_x = link.get(j);
					int link_y = link.get(i);

					t1 += map[start_y][start_x] + map[start_x][start_y];
					t2 += map[link_y][link_x] + map[link_x][link_y];
				}
			}
			int diff =  Math.abs(t1 - t2);
			min = Math.min(min, diff);

			return;
		}

		for (int i = cur + 1; i < N; i++) {
			if (!team[i]) {
				team[i] = true;
				dfs(k + 1, i);
				team[i] = false;
			}

		}
	}

}
