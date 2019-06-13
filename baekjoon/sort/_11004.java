/**
 * 
 */
package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Project : codePlus
 * @Package : sort
 * @FileName : _11004.java
 * @Author : hyunyoungkim
 * @Date : Feb 2, 2019
 */
public class _11004 { // K번째 수 : http://www.acmicpc.net/problem/11004

	/**
	 * @param args
	 */
	static int n;
	static int k;
	static int[] a;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		a = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(a);

		System.out.println(a[k - 1]);
	}

}
