import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _15686 { // 치킨 배달 : https://www.acmicpc.net/problem/15686
	static class Node { 	// 좌표를 저장하기 위해 Node클래스 생성
		int x, y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M;
	static int chickenDist;
	static int visited;
	static int[][] map;
	static ArrayList<Node> chicken;
	static ArrayList<Node> home;

	static int calcDist(Node a, Node b) { // 거리계산함수
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}

	static int sumDist() { // 치킨거리합 계산 함수
		int sum = 0;
		for (int i = 0; i < home.size(); i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < chicken.size(); j++) {
				if ((visited & (1 << j)) != 0) {
					min = Math.min(min, calcDist(home.get(i), chicken.get(j)));
				}
			}
			sum += min;
		}
		return sum;
	}

	static void dfs(int cnt, int idx) {
		if (cnt == M) {
			int temp = sumDist();
			chickenDist = Math.min(chickenDist, temp);
		}
		for (int i = idx; i < chicken.size(); i++) {
			visited = visited | (1 << i); // 방문한 치킨집은 1로 
			dfs(cnt + 1, i + 1);
			visited = visited & ~(1 << i); // 다시 0으로 
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		chicken = new ArrayList<>();
		home = new ArrayList<>();

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					home.add(new Node(i, j));
				} else if (map[i][j] == 2) {
					chicken.add(new Node(i, j));
				}
			}
		}
		chickenDist = Integer.MAX_VALUE;
		dfs(0, 0);
		System.out.println(chickenDist);
	}

}
