package fundamental;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _10817 { // 세 수 : http://www.acmicpc.net/problem/10817

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[] a = new int[3];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(a);

		System.out.println(a[1]);
	}

}
