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
 * @FileName : _10808.java
 * @Author : hyunyoungkim
 * @Date : Feb 8, 2019
 */
public class _10808 { // 알파벳 개수 : http://www.acmicpc.net/problem/10808

	/**
	 * @param args
	 */

	static String word;
	static int[] alphabet;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		word = br.readLine();
		alphabet = new int[26];

		for (int i = 0; i < word.length(); i++) {
			alphabet[word.charAt(i) - 'a']++;
		}

		for (int i : alphabet) {
			sb.append(i + " ");
		}

		System.out.println(sb);
	}

}
