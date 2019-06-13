package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2941 { // 크로아티아 알파벳 : http://www.acmicpc.net/problem/2941

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] croatian = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

		String input = br.readLine();
		int cnt = 0;

		for (int i = 0; i < croatian.length; i++) {
			if (input.contains(croatian[i])) {
				input = input.replaceAll(croatian[i], "*");
			}
		}

		cnt = input.length();
		System.out.println(cnt);

	}

}
