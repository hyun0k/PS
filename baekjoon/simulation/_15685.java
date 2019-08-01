package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _15685 { // 드래곤 커브 : http://www.acmicpc.net/problem/15685

	/**
	 *	드래곤 커브 방향의 규칙성을 찾아내는것이 핵심이다. 직접 그려보면서 규칙을 찾아보자.  
	 */
	
	static int N, x, y, d, g, cnt;
	static int[][] map;
	static int[] dx = { 1, 0, -1, 0 }; 
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[101][101];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());

			dragonCurve(x, y, d, g);
		}
		countRect();

		System.out.println(cnt);
	}

	private static void dragonCurve(int x, int y, int d, int g) {

		ArrayList<Integer> dir = new ArrayList<>();
		dir.add(d);

		for (int i = 1; i <= g; i++) { // g세대까지 방향값 저장
			int size = dir.size() - 1;
			for (int j = size; j >= 0; j--) {
				dir.add((dir.get(j) + 1) % 4);
			}
		}

		map[y][x]++; // 드래곤 커브가 그려지는 좌표 체크
		for (int i = 0; i < dir.size(); i++) {
			x = x + dx[dir.get(i)];
			y = y + dy[dir.get(i)];
			map[y][x]++;
		}

	}

	private static void countRect() {

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] != 0 && map[i + 1][j] != 0 && map[i][j + 1] != 0 && map[i + 1][j + 1] != 0) {
					cnt++;
				}
			}
		}
	}

}
