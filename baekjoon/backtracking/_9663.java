package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _9663 { // N-Queen : http://www.acmicpc.net/problem/9663

	static int N, cnt;
	static int[] col;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		col = new int[N + 1];

		dfs(1);
		System.out.println(cnt);
	}

	static void dfs(int row) {
		for (int i = 1; i <= N; i++) {
			col[row] = i;
			if (isPossible(row)) {
				if (row == N) {
					cnt++;
				} else {
					dfs(row + 1);
				}
			}
		}
	}

	static boolean isPossible(int row) { // 같은 열에 있거나 대각선에 있으면 놓을수 없음. 대각선 여부는 x,y좌표 차이의 절댓값이 같으면 대각선에 있는것임. 
		for (int i = 1; i < row; i++) {
			if (col[i] == col[row] || Math.abs(i - row) == Math.abs(col[i] - col[row])) {
				return false;
			}
		}
		return true;
	}

}
