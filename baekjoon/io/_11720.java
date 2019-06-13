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
 * @FileName : _11720.java
 * @Author : hyunyoungkim
 * @Date : Jan 28, 2019
 */
public class _11720 { // 숫자의 합 : http://www.acmicpc.net/problem/11720 

	/**
	 * @param args
	 */
	static int n;
	static String[] str;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		str = br.readLine().split("");
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += Integer.parseInt(str[i]);
		}
		System.out.println(sum);
	}
}
