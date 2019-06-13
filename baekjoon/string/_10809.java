/**
 * 
 */
package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Project : codePlus
 * @Package : string
 * @FileName : _10809.java
 * @Author : hyunyoungkim
 * @Date : Feb 8, 2019
 */
public class _10809 { // 알파벳 찾기 : http://www.acmicpc.net/problem/10809

	/**
	 * @param args
	 */
	static String word;
	static int[] start;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		word = br.readLine();
		start = new int[26];

		for (int i = 0; i < start.length; i++) {
			start[i] = -1;
		}

		for (int i = 0; i < word.length(); i++) {
			int pos = word.charAt(i) - 'a';
			if (start[pos] == -1) {
				start[pos] = i;
			}
		}

		for (int i : start) {
			sb.append(i + " ");
		}

		System.out.println(sb);
	}

}
