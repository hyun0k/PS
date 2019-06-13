package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2908 { // 상수 : http://www.acmicpc.net/problem/2908

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String A = st.nextToken();
		String B = st.nextToken();

		StringBuilder reverseA = new StringBuilder();
		for (int i = A.length() - 1; i >= 0; i--) {
			char temp = A.charAt(i);
			reverseA.append(temp);
		}

		StringBuilder reverseB = new StringBuilder();
		for (int i = B.length() - 1; i >= 0; i--) {
			char temp = B.charAt(i);
			reverseB.append(temp);
		}

		int renewA = Integer.parseInt(reverseA.toString());
		int renewB = Integer.parseInt(reverseB.toString());

		System.out.println(Math.max(renewA, renewB));
	}

}
