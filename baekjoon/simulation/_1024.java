package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1024 { // 수열의 합 : http://www.acmicpc.net/problem/1024

	/**
	 *  수학적 지식을 이용하면 간단히 풀 수 있다. n을 길이가 l인 연속된 수들의 합으로 나타낸다. 
	 *  여기서 x가 0보다 크거나 같고 정수임을 주의해야한다. 
	 */
	static int n, l;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());

		int start = 0;
		int length = 0;
		boolean flag = true;
		for (int i = l; i <= 100; i++) {
			int x = (n - ((i - 1) * i) / 2);
			if (x / i >= 0 && x % i == 0) {
				flag = true;
				start = x / i;
				length = i;
				break;
			} else {
				flag = false;
			}
		}

		if (flag) {
			for (int i = start; i < start + length; i++) {
				sb.append(i + " ");
			}
		} else {
			sb.append(-1);
		}

		System.out.println(sb);
	}

}
