package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _3190 { // 뱀 : http://www.acmicpc.net/problem/3190
	
	/**
	 * 큐를 사용해서 꼬리 위치를 계속 갱신시키는 것이 핵심이다. 
	 * map에서 빈곳:0, 뱀:1, 사과:2
	 */

	static int N, K, r, c, L, sec;
	static int[][] map;
	static int[] time, dir;
	static int[] dx = { 0, 1, 0, -1 }; // 북, 동, 남, 서
	static int[] dy = { -1, 0, 1, 0 };
	static Queue<Point> snake;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		K = Integer.parseInt(br.readLine());
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken()) - 1;
			c = Integer.parseInt(st.nextToken()) - 1;
			map[r][c] = 2; // 사과가 있는 곳.
		}

		L = Integer.parseInt(br.readLine());
		time = new int[L];
		dir = new int[L];

		for (int l = 0; l < L; l++) {
			st = new StringTokenizer(br.readLine());
			time[l] = Integer.parseInt(st.nextToken());
			dir[l] = convertDir(st.nextToken()); // 1이면 오른쪽, 0이면 왼쪽
		}

		start(0, 0, 1); // (0,0)에서 오른쪽 방향으로 시작. 

		System.out.println(sec);

	}

	private static void start(int curX, int curY, int d) {

		snake = new LinkedList<>();
		snake.add(new Point(curX, curY));

		map[curY][curX] = 1;
		int curDir = d; // 현재 방향 
		int timeIdx = 0;

		while (true) {

			if (timeIdx < L && time[timeIdx] == sec) { // 시간이 되면 방향 전환
				if (dir[timeIdx] == 1) {
					curDir = (curDir + 1) % 4; // 오른쪽으로 90도 
				} else {
					curDir = (curDir + 3) % 4; // 왼쪽으로 90도 
				}
				timeIdx++;
			}

			int nextX = curX + dx[curDir];
			int nextY = curY + dy[curDir];

			if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) { // 벽이면 종료
				sec++;
				break;
			}
			if (map[nextY][nextX] == 1) { // 자기 몸에 부딪히면 종료
				sec++;
				break;
			}

			snake.add(new Point(nextX, nextY));
			if (map[nextY][nextX] == 2) { // 사과가 있으면
				map[nextY][nextX] = 1;
			} else {	// 없으면 
				map[nextY][nextX] = 1;
				
				Point p = snake.poll(); // 꼬리 이동 
				int tailX = p.x;
				int tailY = p.y;
				map[tailY][tailX] = 0;

			}
			curX = nextX;
			curY = nextY;
			sec++;
		}
	}

	private static int convertDir(String s) { // D면 1, 아니면 0 
		return (s.equals("D")) ? 1 : 0;
	}

	private static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
