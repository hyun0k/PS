package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class _16235 { // 나무 재테크 :http://www.acmicpc.net/problem/16235  

	/**
	 *  한 칸안에 나무 여러개가 있을 수 있다는 점을 List를 이용해서 구현하는 것이 핵심이다. 
	 *  칸 마다 ArrayList를 만들어서 한 칸에 여러개의 나무가 들어가도록 한다. 또한 어린나무부터
	 *  양분을 먹는 과정을 위해 Comparator로 오름차순 정렬을 한다. 
	 */
	
	static int N, M, K, r, c, z, ans;
	static int[][] map, nut;
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static List<Integer>[][] trees;

	static Comparator<Integer> comparator = new Comparator<Integer>() {
		public int compare(Integer o1, Integer o2) {
			if (o1 < o2) {
				return -1;
			} else if (o1 > o2) {
				return 1;
			}
			return 0;
		}
	};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		nut = new int[N][N];
		trees = new ArrayList[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				nut[i][j] = Integer.parseInt(st.nextToken());
				trees[i][j] = new ArrayList<>();
				map[i][j] = 5;
			}
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken()) - 1; // 나무 위치
			c = Integer.parseInt(st.nextToken()) - 1;
			z = Integer.parseInt(st.nextToken()); // 나이
			trees[r][c].add(z);
		}

		start();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ans += trees[i][j].size();
			}
		}

		System.out.println(ans);
	}

	private static void start() {
		
		int year = 0;

		while (true) {
			if (year == K) {
				return;
			}

			for (int i = 0; i < N; i++) { // 봄, 여름
				for (int j = 0; j < N; j++) {

					Collections.sort(trees[i][j], comparator);
					List<Integer> alive = new ArrayList<>(); // 살아남은 나무 
					int dead = 0;

					for (int k = 0; k < trees[i][j].size(); k++) {

						int age = trees[i][j].get(k);

						if (map[i][j] < age) { // 양분이 모자라면
							dead += (age / 2);
						} else { 		       // 양분이 충분하면
							map[i][j] -= age;
							alive.add(age + 1);
						}
					}
					
					map[i][j] += dead;
					trees[i][j] = alive;
					
				}
			}

			for (int i = 0; i < N; i++) { // 가을
				for (int j = 0; j < N; j++) {
					
					for (int k = 0; k < trees[i][j].size(); k++) {
						
						int age = trees[i][j].get(k);
						
						if (age % 5 == 0) {
							for (int l = 0; l < 8; l++) {
								int tx = j + dx[l];
								int ty = i + dy[l];

								if (tx >= 0 && ty >= 0 && tx < N && ty < N) {
									trees[ty][tx].add(1);
								}
							}
						}
					}
					
				}
			}

			for (int i = 0; i < N; i++) { // 겨울
				for (int j = 0; j < N; j++) {
					map[i][j] += nut[i][j];
				}
			}

			year++;
		}
	}

}
