import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10971 {
	static int[][] w = new int[11][11];
	static boolean[] visited = new boolean[11];
	static int n;
	static int MIN_COST = 100000000;

//	cur  현재 방문 노드
//	sum  현재 최소비용합
//	num  방문 도시
	
	static void tsp(int cur, int sum, int num) {
		if (num == n) { // 정답찾은경우
			if (w[cur][1] != 0) { // 시작점으로 돌아갈수 있을때
				MIN_COST = Math.min(MIN_COST, sum + w[cur][1]);
			}
		}
		visited[cur] = true;
		for (int i = 1; i <= n; i++) {
			if (visited[i] == false && w[cur][i] != 0) { // 현재 노드를 방문하지 않았고 i번째 노드로 갈수 있는 경우
				if (sum + w[cur][i] < MIN_COST) { // 현재까지 구한 최소비용합보다 작은 경우에만 진행.
					tsp(i, sum + w[cur][i], num + 1);
				}
			}
		}
		visited[cur] = false; // 위 조건 만족하지않으면 초기화
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				w[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		tsp(1, 0, 1); // 1번도시부터 탐색시작.
		System.out.println(MIN_COST);

	}

}
