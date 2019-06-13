package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2875 { // 대회 or 인턴 : http://www.acmicpc.net/problem/2875

	static int N, M, K;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int cnt = 0;
		while (N >= 2 && M >= 1 && N + M >= 3 + K) {
			N -= 2;
			M--;
			cnt++;
		}
		System.out.println(cnt);
	}

}
