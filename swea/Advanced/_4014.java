package Advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4014 { // 활주로 건설

	static int T, N, X, cnt;
	static int[][] map1, map2;
	static boolean[] slope;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());

			map1 = new int[N][N];
			map2 = new int[N][N];

			cnt = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map1[i][j] = map2[j][i] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				roadBuild(i, map1);
				roadBuild(i, map2);
			}

			sb.append("#" + tc + " " + cnt + "\n");
		}
		System.out.println(sb);
	}

	private static void roadBuild(int idx, int[][] arr) {

		slope = new boolean[N];

		for (int i = 0; i < N - 1; i++) {
			
			if (arr[idx][i] != arr[idx][i + 1]) {
				
				int diff = arr[idx][i] - arr[idx][i + 1];
				
				if (diff < -1 || diff > 1) {
					return;
				}
				if (diff == 1) { // 오른쪽에 경사로

					for (int j = 1; j <= X; j++) {
						if (i + j >= N || slope[i + j]) {
							return;
						}
						if (arr[idx][i] - 1 == arr[idx][i + j]) {
							slope[i + j] = true;
						} else {
							return;
						}
					}
				}
				if (diff == -1) { // 왼쪽에 경사로

					for (int j = 0; j < X; j++) {
						if (i - j < 0 || slope[i - j]) {
							return;
						}
						if (arr[idx][i] == arr[idx][i - j]) {
							slope[i - j] = true;
						} else {
							return;
						}
					}
				}
			}
		}
		cnt++;
	}
}
