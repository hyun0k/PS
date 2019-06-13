import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1697 { // 숨바꼭질 : https://www.acmicpc.net/problem/1697

	static class Node {
		int x, step;

		Node(int x, int step) {
			this.x = x;
			this.step = step;
		}
	}

	static int N, K, ans;
	static int[] go = { -1, 1, 0 };
	static boolean[] visited = new boolean[100001];

	static void bfs(int x) {
		Queue<Node> q = new LinkedList<>();
		visited[x] = true;
		q.offer(new Node(x, 0));
		while (!q.isEmpty()) {
			Node v = q.poll();
			int cur = v.x;
			int cnt = v.step;
			if (cur == K) {
				ans = cnt;
				break;
			}
			for (int i = 0; i < 3; i++) {
				int next;
				if (go[i] != 0) {
					next = cur + go[i];
				} else {
					next = cur * 2;
				}
				if (0 <= next && next <= 100000) {
					if (!visited[next]) {
						q.offer(new Node(next, cnt + 1));
						visited[next] = true;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		bfs(N);
		System.out.println(ans);
	}

}
