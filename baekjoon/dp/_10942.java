package dp;

import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

public class _10942 { // 팰린드롬? : https://www.acmicpc.net/problem/10942 
	static int[] a;
	static int[][] d;

	public static int go(int x, int y) {
		if (x == y) {              //길이 1일때 
			return 1;
		} else if (x + 1 == y) {   //길이 2일때 
			if (a[x] == a[y]) {    //두 숫자 같으면 팰린드롬 
				return 1;
			} else {
				return 0;
			}
		}
		if (d[x][y] != -1) {
			return d[x][y];
		}
		if (a[x] != a[y]) {        
			return d[x][y] = 0;
		} else {
			return d[x][y] = go(x + 1, y - 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		a = new int[n];
		d = new int[n][n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			Arrays.fill(d[i], -1); // 아직채우지 않음 -> -1로 초기
		}
		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			sb.append(go(x - 1, y - 1));
			sb.append('\n');
		}
		System.out.println(sb);
	}

}
