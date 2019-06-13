/**
 * 
 */
package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @Project : codePlus
 * @Package : io
 * @FileName : _11718.java
 * @Author : hyunyoungkim
 * @Date : Jan 28, 2019
 */
public class _11718 { // 그대로 출력하기 : http://www.acmicpc.net/problem/11718

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		ArrayList<String> input = new ArrayList<String>();
		int cnt = 0;

		while ((line = br.readLine()) != null) {
			if (line.isEmpty() || cnt > 100 || line.startsWith(" ") || line.endsWith(" ")) {
				break;
			} else {
				input.add(line);
			}
		}

		for (String str : input) {
			System.out.println(str);
		}
	}

}
