package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1182 { // 부분수열의 합 : http://www.acmicpc.net/problem/1182

	static int N, S, ans;
	static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0);

		if (S == 0) { // 부분집합이 공집합인 경우 아무것도 더해지지 않는 경우가 카운트되므로 그 경우 하나를 빼준다. 
			ans--;
		}

		System.out.println(ans);

	}

	private static void dfs(int idx, int res) {

		if (idx == N) { // 인덱스 끝에 도달 
			if (res == S) {
				ans++;
			}
			return;
		}

		dfs(idx + 1, res + arr[idx]); // arr[idx]를 선택한경우 
		dfs(idx + 1, res); // arr[idx]를 선택하지 않은 경우 
	}

}
