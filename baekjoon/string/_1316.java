package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1316 { // 그룹 단어 체커 : http://www.acmicpc.net/problem/1316

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int cnt = 0;

		while (n-- > 0) {
			String word = br.readLine();
			if (groupChecker(word)) {
				cnt++;
			}
		}
		System.out.println(cnt);

	}

	static boolean groupChecker(String word) {
		boolean[] check = new boolean[26];
		for (int i = 0; i < word.length(); i++) {
			char temp = word.charAt(i);
			if (check[temp - 'a']) { // 현재 알파벳이 이미 나온 알파벳일때 
				return false;
			} else {  // 현재 알파벳이 처음 나온 알파벳일때 
				if (i < word.length() - 1 && temp != word.charAt(i + 1)) {
					check[temp - 'a'] = true;
				}
			}
		}
		return true;
	}

}
