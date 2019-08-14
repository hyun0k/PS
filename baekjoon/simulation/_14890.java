package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14890 { // 경사로 : http://www.acmicpc.net/problem/14890

	/**
	 * 길을 지나갈 수 없는 경우의 조건을 체크해준다.
	 */

	static int N, L, cnt;
	static int[][] map1, map2;
	static boolean[] slope;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		map1 = new int[N][N];
		map2 = new int[N][N];

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
		
		System.out.println(cnt);

	}

	private static void roadBuild(int idx, int[][] arr) {
		slope = new boolean[N];

		for (int i = 0; i < N - 1; i++) {

			if (arr[idx][i] != arr[idx][i + 1]) { // 길의 높이가 같지 않으면
				
				int diff = arr[idx][i] - arr[idx][i + 1]; // 높이 차이
				
				if (diff < -1 || diff > 1) { // 차이가 1보다 크면 길이 될 수 없음
					return;
				}
				
				if (diff == -1) { // 왼쪽 경사로 설치
					
					for (int j = 0; j < L; j++) {
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
				if (diff == 1) { // 오른쪽 경사로 설치 
					
					for (int j = 1; j <= L; j++) {
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
			}
		}
		cnt++;
	}

}
