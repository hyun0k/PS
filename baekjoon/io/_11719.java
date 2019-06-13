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
 * @FileName : _11719.java
 * @Author : hyunyoungkim
 * @Date : Jan 28, 2019
 */
public class _11719 { // 그대로 출력하기2 : http://www.acmicpc.net/problem/11719 

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		ArrayList<String> input = new ArrayList<String>();
		for (int i = 0; i < 100; i++) {
			line = br.readLine();
			if (line == null) {
				input.add("");
			} else {
				input.add(line);
			}
		}

		for (String str : input) {
			System.out.println(str);
		}
	}

}
