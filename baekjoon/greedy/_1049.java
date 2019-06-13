package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1049 { // 기타줄 : http://www.acmicpc.net/problem/1049

	static int N, M;
	static int[] pack;
	static int[] unit;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		pack = new int[M];
		unit = new int[M];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			pack[i] = Integer.parseInt(st.nextToken());
			unit[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(pack);
		Arrays.sort(unit);
		
		/**
		 * 가장 싼 6개짜리 팩으로 모두 사기 vs 가장 싼 가격 낱개로 모두 사기 vs 가장 싼 팩으로 사고 남은 건 낱개로 사기 
		 */
		int min = Integer.MAX_VALUE;
		min = Math.min(Math.min(((N / 6) + 1) * pack[0], N * unit[0]), (N / 6) * pack[0] + (N % 6) * unit[0]);

		System.out.println(min);
	}

}
