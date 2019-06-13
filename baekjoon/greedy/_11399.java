package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11399 { // ATM : http://www.acmicpc.net/problem/11399

	static int N;
	static int[] P, S;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		P = new int[N];
		S = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}

		// 오름차순일떄가 대기시간 합 최소. 
		Arrays.sort(P);

		S[0] = P[0];
		int sum = P[0];
		for (int i = 1; i < N; i++) {
			S[i] = S[i - 1] + P[i];
			sum += S[i];
		}

		System.out.println(sum);
	}

}
