/**
 * 
 */
package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Project : codePlus
 * @Package : io
 * @FileName : _11721.java
 * @Author : hyunyoungkim
 * @Date : Jan 29, 2019
 */
public class _11721 { // 열 개씩 끊어 출력하기 : http://www.acmicpc.net/11721

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();

		if (str.length() <= 100) {
			for (int i = 1; i <= str.length(); i++) {
				sb.append(str.charAt(i - 1));
				if (i % 10 == 0) {
					sb.append(System.lineSeparator());
				}
			}
		}
		System.out.println(sb);
	}

}
