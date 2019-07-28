package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15662 { // 톱니바퀴2 : http://www.acmicpc.net/problem/14891

	/**
	 * 톱니배열에서 12시방향부터 시계방향으로 0~7 로 인덱싱
	 */

	static int K, T, N, dir;
	static int[][] cogwheel;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		
		cogwheel = new int[T][8];
		visited = new boolean[T];

		for (int i = 0; i < T; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				cogwheel[i][j] = str.charAt(j) - '0';
			}
		}

		K = Integer.parseInt(br.readLine());

		while (K-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()) - 1;
			dir = Integer.parseInt(st.nextToken());

			explore(N, dir);
		}

		int cnt = 0;
		for (int i = 0; i < T; i++) {
			if (cogwheel[i][0] == 1) {
				cnt++;
			}
		}

		System.out.println(cnt);

	}

	private static void explore(int n, int dir) {

		if (visited[n]) { // 탈출 조건
			return;
		}

		visited[n] = true;

		if (n - 1 >= 0 && cogwheel[n][6] != cogwheel[n - 1][2]) { // 왼쪽 톱니 탐색
			explore(n - 1, -dir);
		}
		if (n + 1 < T && cogwheel[n][2] != cogwheel[n + 1][6]) { // 오른쪽 톱니 탐색
			explore(n + 1, -dir);
		}

		visited[n] = false;
		rotate(n, dir);
	}

	private static void rotate(int n, int dir) {
		if (dir == 1) {
			cwRotate(cogwheel, n);
		} else if (dir == -1) {
			ccwRotate(cogwheel, n);
		}
	}

	private static void cwRotate(int[][] arr, int n) { // 시계 방향 회전
		int temp = arr[n][7];
		for (int i = 7; i > 0; i--) {
			arr[n][i] = arr[n][i - 1];
		}
		arr[n][0] = temp;
	}

	private static void ccwRotate(int[][] arr, int n) { // 반시계 방향 회전
		int temp = arr[n][0];
		for (int i = 0; i < 7; i++) {
			arr[n][i] = arr[n][i + 1];
		}
		arr[n][7] = temp;
	}

}
