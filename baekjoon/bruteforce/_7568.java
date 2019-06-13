package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _7568 { // 덩치 : http://www.acmicpc.net/problem/7568

	static int N;
	static Build[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		arr = new Build[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Build(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < N; i++) {
			int cnt = 0;
			Build b = arr[i];
			for (int j = 0; j < N; j++) {
				if (b.w < arr[j].w && b.h < arr[j].h) {
					cnt++;
				}
			}
			sb.append(cnt + 1 + " ");
		}
		System.out.println(sb);
	}

	static class Build {
		int w;
		int h;

		Build(int w, int h) {
			this.w = w;
			this.h = h;
		}
	}
}
