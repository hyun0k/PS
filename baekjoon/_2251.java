import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2251 { // 물통 : https://www.acmicpc.net/problem/2251 

	static class Bottle {
		int a, b, c;

		Bottle(int x, int y, int z) {
			this.a = x;
			this.b = y;
			this.c = z;
		}
	}

	static int A, B, C;
	static int MAX = 201;
	static boolean[][] visited = new boolean[MAX][MAX];
	static Queue<Bottle> q = new LinkedList<>();
	static ArrayList<Integer> ans = new ArrayList<>();

	static void bfs() {

		q.offer(new Bottle(0, 0, C));
		while (!q.isEmpty()) {
			Bottle bot = q.poll();
			if (visited[bot.a][bot.b]) {
				continue;
			}
			visited[bot.a][bot.b] = true;
			if (bot.a == 0) {
				ans.add(bot.c);
			}

			// A-->B
			if (bot.a + bot.b > B) {
				q.offer(new Bottle(bot.a + bot.b - B, B, bot.c));
			} else {
				q.offer(new Bottle(0, bot.a + bot.b, bot.c));
			}
			// A-->C
			if (bot.a + bot.c > C) {
				q.offer(new Bottle(bot.a + bot.c - C, bot.b, C));
			} else {
				q.offer(new Bottle(0, bot.b, bot.a + bot.c));
			}
			// B-->A
			if (bot.b + bot.a > A) {
				q.offer(new Bottle(A, bot.a + bot.b - A, bot.c));
			} else {
				q.offer(new Bottle(bot.a + bot.b, 0, bot.c));
			}
			// B-->C
			if (bot.b + bot.c > C) {
				q.offer(new Bottle(bot.a, bot.b + bot.c - C, C));
			} else {
				q.offer(new Bottle(bot.a, 0, bot.b + bot.c));
			}
			// C-->A
			if (bot.c + bot.a > A) {
				q.offer(new Bottle(A, bot.b, bot.c + bot.a - A));
			} else {
				q.offer(new Bottle(bot.c + bot.a, bot.b, 0));
			}
			// C-->B
			if (bot.c + bot.b > B) {
				q.offer(new Bottle(bot.a, B, bot.c + bot.b - B));
			} else {
				q.offer(new Bottle(bot.a, bot.c + bot.b, 0));
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		bfs();

		Collections.sort(ans);
		for (Integer i : ans) {
			sb.append(i);
			sb.append(" ");
		}
		System.out.println(sb);
	}

}
