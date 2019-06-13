/**
 * 
 */
package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @Project : codePlus
 * @Package : sort
 * @FileName : _10814.java
 * @Author : hyunyoungkim
 * @Date : Jan 29, 2019
 */
public class _10814 { // 나이순 정렬 : http://www.acmicpc.net/problem/10814

	/**
	 * @param args
	 */
	static int n;
	static String[][] mb;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		mb = new String[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			mb[i][0] = st.nextToken();
			mb[i][1] = st.nextToken();
		}

		Arrays.sort(mb, new Comparator<String[]>() {
			public int compare(String[] a, String[] b) {
				return Integer.compare(Integer.parseInt(a[0]), Integer.parseInt(b[0]));
			}
		});

		for (int i = 0; i < n; i++) {
			sb.append(mb[i][0] + " " + mb[i][1]).append(System.lineSeparator());
		}

		System.out.println(sb);
	}

}
