package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1520 { // 내리막길 : http://www.acmicpc.net/problem/1520 
	
	static int m, n;
	static int[][] map;
	static int[][] d;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		// 2차원배열에 지도 저장. 
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
	}

}
