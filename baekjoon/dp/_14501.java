package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14501 { // 퇴사 : https://www.acmicpc.net/problem/14501

	static int N, max;
	static int[] t, p, d;
	
	static void solve() {
		max = 0;
		for (int i = 1; i <= N + 1; i++) {
			d[i] = Math.max(d[i], max);
			d[t[i] + i] = Math.max(d[t[i] + i], p[i] + d[i]);
			max = Math.max(max, d[i]);
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());

		t = new int[N + 6];
		p = new int[N + 6];
		d = new int[N + 6];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
			d[i] = p[i];
		}
		
		solve();
		System.out.println(max);
	}

}
