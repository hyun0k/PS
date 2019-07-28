package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14891 { // 톱니바퀴 : http://www.acmicpc.net/problem/14891
	
	/**
	 *  톱니배열에서 12시방향부터 시계방향으로 0~7 로 인덱싱 
	 */

	static int K, N, dir;
	static int[][] cogwheel;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		cogwheel = new int[4][8];
		visited = new boolean[4];

		for (int i = 0; i < 4; i++) {
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

		int sum = 0;
		for (int i = 0; i < 4; i++) {
			sum += (cogwheel[i][0] == 0) ? 0 : 1 << i;
		}

		System.out.println(sum);

	}

	private static void explore(int n, int dir) {

		if (visited[n]) { // 탈출 조건
			return;
		}

		visited[n] = true;

		if (n - 1 >= 0 && cogwheel[n][6] != cogwheel[n - 1][2]) { // 왼쪽 톱니 탐색
			explore(n - 1, -dir);
		}
		if (n + 1 < 4 && cogwheel[n][2] != cogwheel[n + 1][6]) { // 오른쪽 톱니 탐색
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
