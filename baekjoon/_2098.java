import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2098 { // 외판원 순회 
	static int w[][];
	static int d[][];
	static int N;
	static int MIN_COST = 100000000;
	
	//DP+비트마스크 사용
	/*
	현재 외판원이 cur번 마을에 있고, 방문한 마을 집합이 visited일 때
	앞으로 남은 모든 마을을 방문하고 1번 마을로 돌아갈 때 드는 최소 비용
	*/
	static int tsp(int cur, int visited) {
		 
		if (visited == (1 << N) - 1) {
			return w[cur][1] != 0 ? w[cur][1] : MIN_COST;
		}  /*
	   		Base Case : 모든 마을을 방문한 경우,
	    	현재 마을에서 시작지점으로 갈 수 있으면 해당 비용을 리턴하고
	    	아닐 경우 불가능 값을 리턴한다.
		   */
		if (d[cur][visited] != 0) {
			return d[cur][visited];
		}
		int ans = MIN_COST;
		for (int i = 1; i <= N; i++) {
			if ((visited & (1 << (i - 1))) != 0) {
				continue;
			}
			if (w[cur][i] == 0) {
				continue;
			}
			ans = Math.min(ans, w[cur][i] + tsp(i, visited | (1 << (i - 1))));
		}
		//방문하지않은 노드를 모두 순회. 
		return d[cur][visited] = ans;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		w = new int[N + 1][N + 1];
		d = new int[N + 1][1 << N];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				w[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(tsp(1, 1));
	}

}
