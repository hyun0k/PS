package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11047 { // 동전0 : http://www.acmicpc.net/problem/11047
	/**
	 *   동전이 오름차순으로 배열에 들어있으므로 가장 큰 동전부터 사용해보면서 최소 동전개수를 찾는다. 
	 */
	static int N, K;
	static int[] coin;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		coin = new int[N];

		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		int cnt = 0;
		for (int i = N - 1; i >= 0; i--) {
			cnt += K / coin[i];
			K %= coin[i];
		}
		System.out.println(cnt);
	}

}
